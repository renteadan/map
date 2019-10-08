package com.company;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
class ComplexNumber {
    private float real ,imaginary;

    ComplexNumber(String complex) {
        Pattern p = Pattern.compile("([+-]?\\d+(?![iI.\\d]))?([+-]?\\d*\\*?[iI])?");
        Pattern t = Pattern.compile("(?=[iI.\\d+-])([+-]?(?:\\d+)(?![iI.\\d]))?([+-]?(?:(?:\\d+(?:\\.\\d*)?|\\.\\d+)(?:[eE][+-]?\\d+)?)?[iI])?");
        Matcher m = t.matcher(complex);
        String re = "", img = "";
        if(m.find()) {
            re = m.group(1);
            try {
                real = Integer.parseInt(re);
            } catch (NumberFormatException e) {
                real = 0;
            }
            img = m.group(2);
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


    float getReal() {
        return real;
    }

    float getImaginary() {
        return imaginary;
    }

    private ComplexNumber(float a, float b) {
        real = a;
        imaginary = b;
    }

    ComplexNumber add (@NotNull ComplexNumber other) {
        float a = real + other.real;
        float b = imaginary + other.imaginary;
        return new ComplexNumber(a ,b);
    }

    ComplexNumber subtract(@NotNull ComplexNumber other) {
        float a = real - other.real;
        float b = imaginary - other.imaginary;
        return new ComplexNumber(a ,b);
    }

    ComplexNumber multiply(@NotNull ComplexNumber other) {
        float a = real * other.real - imaginary*other.imaginary;
        float b = real * other.imaginary + imaginary * other.real;
        return new ComplexNumber(a, b);
    }

    private String convert(float a) {
        return new BigDecimal(String.valueOf(a)).setScale(2,RoundingMode.FLOOR).toString();
    }
    ComplexNumber divide(@NotNull ComplexNumber other) {
        float a = (real * other.real + imaginary * other.imaginary) / (other.real * other.real + other.imaginary * other.imaginary);
        float b = (imaginary * other.real - real * other.imaginary) / (other.real * other.real + other.imaginary * other.imaginary);
        a = Float.parseFloat(convert(a));
        b = Float.parseFloat(convert(b));
        return new ComplexNumber(a, b);
    }
}
