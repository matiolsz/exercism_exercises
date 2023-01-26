package org.example;

public class Triangle {

    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) throws TriangleException {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        double maxSide;
        double otherSide;
        double otherSide2;

        if ( side1==0 || side2 == 0 || side3 == 0) {
            throw new TriangleException();
        }

        if ( side1 >= side2 && side1 >= side3) {
            maxSide = side1;
            otherSide = side2;
            otherSide2 = side3;
        } else if ( side2 >= side1 && side2 >= side3) {
            maxSide = side2;
            otherSide = side1;
            otherSide2 = side3;
        } else {
            maxSide = side3;
            otherSide = side2;
            otherSide2 = side1;
        }

        if ( maxSide > (otherSide + otherSide2)){
            throw new TriangleException();
        }
    }

    public boolean isEquilateral() {
        return ( side1 == side2 && side2 == side3 );
    }

    public boolean isIsosceles() {
        return ((side1==side2 && side1!=side3) || (side2==side3 && side1!=side2) || (side1==side3 && side2!=side3)) || isEquilateral();
    }

    public boolean isScalene() {
        return side1 != side2 && side2 != side3;
    }

}
