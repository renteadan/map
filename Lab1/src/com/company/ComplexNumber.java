package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
class ComplexNumber {
    private int real ,imaginary;

    ComplexNumber(String complex) {
        Pattern p = Pattern.compile("([+-]?\\d+(?![iI.\\d]))?([+-]?\\d*\\*?[iI])?");
        Pattern t = Pattern.compile("(?=[iI.\\d+-])([+-]?(?:\\d+)(?![iI.\\d]))?([+-]?(?:(?:\\d+(?:\\.\\d*)?|\\.\\d+)(?:[eE][+-]?\\d+)?)?[iI])?");
        Matcher m = t.matcher(complex);
        String re = "", img = "";
        if(m.find()) {
            try {
                re = m.group(1);
                try {
                    real = Integer.parseInt(re);
                } catch (NumberFormatException e) {
                    real = 0;
                }
            } catch (NullPointerException e) {
                real = 0;
            }
            try {
                img = m.group(2);
            } catch (NullPointerException e) {
                imaginary = 0;
                return;
            }
        }

        if(img == null) {
            imaginary = 0;
            return;
        }
        if(img.equals("-i")) {
            imaginary = -1;
            return;
        }

        if(img.equals("i") || img.equals("+i")) {
            imaginary = 1;
            return;
        }
        Pattern p2 = Pattern.compile("(?:([+-]?\\d+)\\*?[Ii])?");
        Matcher m2 = p2.matcher(img);
        try {
            if (m2.find()) {
                String a = m2.group(1);
                imaginary = Integer.parseInt(a);
            }
        } catch (NumberFormatException e) {
            imaginary = 0;
        }
    }


    int getReal() {
        return real;
    }

    int getImaginary() {
        return imaginary;
    }

    private ComplexNumber(int a, int b) {
        real = a;
        imaginary = b;
    }

    ComplexNumber add (@NotNull ComplexNumber other) {
        int a = real + other.real;
        int b = imaginary + other.imaginary;
        return new ComplexNumber(a ,b);
    }
}
