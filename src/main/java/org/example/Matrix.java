package org.example;

public class Matrix {

    int[][] matrix;
    int[] oneElementMatrix;
    int rowSize;

    public Matrix(String matrixAsString) {
        if (matrixAsString.toCharArray().length == 1) {
            oneElementMatrix = new int[1];
            oneElementMatrix[0] = Integer.parseInt(matrixAsString);
        } else {
            String[] rowsWithSpaces = matrixAsString.split("\n");
            String[] rows = new String[rowsWithSpaces.length];
            int newColumnSize = rowsWithSpaces[0].split(" ").length;
            matrix = new int[newColumnSize][rows.length];
            rowSize = rows.length;
            int counter = 0;
            for (String row : rowsWithSpaces) {
                String[] onlyDigits = row.split(" ");
                int i = 0;
                for (String s : onlyDigits) {
                    matrix[i][counter] = Integer.parseInt(s);
                    i++;
                }
                counter++;
            }
        }
    }

    public int[] getRow(int rowNumber) {
        if (oneElementMatrix == null) {
            int[] row = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                row[i] = matrix[i][rowNumber - 1];
            }
            return row;
        } else {
            return oneElementMatrix;
        }
    }

    public int[] getColumn(int columnNumber) {
        if (oneElementMatrix == null) {
            int[] column = new int[rowSize];
            for (int i = 0; i < rowSize; i++) {
                column[i] = matrix[columnNumber - 1][i];
            }
            return column;
        } else {
            return oneElementMatrix;
        }

    }
}