package com.company;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class ComplexNumber {
    int real, imaginary;


    public ComplexNumber(String complex) {
        Pattern p = Pattern.compile("([+-]?\\d+)?([+-]\\d+[iI])");
        Pattern p3 = Pattern.compile("");
        Matcher m = p3.matcher(complex);
        System.out.println(m.group(1) + "\n" + m.group(2));
        try {
            if (m.find()) {
                String a = m.group(1);
                real = Integer.parseInt(a);
            }
        } catch (NumberFormatException e) {
            real = 0;
        }

        Pattern p2 = Pattern.compile("([+-]{1}\\d+)i");
        Matcher m2 = p2.matcher(m.group(2));
        try {
            if (m2.find()) {
                String a = m2.group(1);
                imaginary = Integer.parseInt(a);
            }
        } catch (NumberFormatException e) {
            imaginary = 0;
        }
        System.out.println(real + " real\n" + imaginary + " imaginary\n");
    }


}
