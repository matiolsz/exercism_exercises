package org.example;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String s = "dad";
        Optional<String> stringOptional = Optional.ofNullable(s);

        if(stringOptional.isPresent()) {
            System.out.println(stringOptional.get());
        }
    }
}