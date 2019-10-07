package com.company;

import org.junit.Test;
import static  org.junit.Assert.*;

public class TestComplex {

    @Test
    public void testAll() {
        testParse();
        testPlus();
    }

    @Test
    public void testParse() {

        // both real and imaginary
        ComplexNumber a = new ComplexNumber("5+3i");
        assertEquals(a.getReal(), 5);
        assertEquals(a.getImaginary(), 3);
        a = new ComplexNumber("5-3i");
        assertEquals(a.getReal(), 5);
        assertEquals(a.getImaginary(), -3);
        a = new ComplexNumber("-5+3i");
        assertEquals(a.getReal(), -5);
        assertEquals(a.getImaginary(), 3);
        a = new ComplexNumber("-5-3i");
        assertEquals(a.getReal(), -5);
        assertEquals(a.getImaginary(), -3);
        a = new ComplexNumber("+5+3i");
        assertEquals(a.getReal(), 5);
        assertEquals(a.getImaginary(), 3);
        a = new ComplexNumber("+5-3i");
        assertEquals(a.getReal(), 5);
        assertEquals(a.getImaginary(), -3);
        a = new ComplexNumber("+5-i");
        assertEquals(a.getReal(), 5);
        assertEquals(a.getImaginary(), -1);
        a = new ComplexNumber("+5+i");
        assertEquals(a.getReal(), 5);
        assertEquals(a.getImaginary(), 1);
        a = new ComplexNumber("5-i");
        assertEquals(a.getReal(), 5);
        assertEquals(a.getImaginary(), -1);
        a = new ComplexNumber("5+i");
        assertEquals(a.getReal(), 5);
        assertEquals(a.getImaginary(), 1);
        a = new ComplexNumber("-5-i");
        assertEquals(a.getReal(), -5);
        assertEquals(a.getImaginary(), -1);
        a = new ComplexNumber("-5+i");
        assertEquals(a.getReal(), -5);
        assertEquals(a.getImaginary(), 1);

        // only real value
        a = new ComplexNumber("5");
        assertEquals(a.getReal(), 5);
        assertEquals(a.getImaginary(), 0);
        a = new ComplexNumber("+5");
        assertEquals(a.getReal(), 5);
        assertEquals(a.getImaginary(), 0);
        a = new ComplexNumber("-5");
        assertEquals(a.getReal(), -5);
        assertEquals(a.getImaginary(), 0);

        // only imaginary value
        a = new ComplexNumber("-3i");
        assertEquals(a.getReal(), 0);
        assertEquals(a.getImaginary(), -3);
        a = new ComplexNumber("3i");
        assertEquals(a.getReal(), 0);
        assertEquals(a.getImaginary(), 3);
        a = new ComplexNumber("+3i");
        assertEquals(a.getReal(), 0);
        assertEquals(a.getImaginary(), 3);
        a = new ComplexNumber("+i");
        assertEquals(a.getReal(), 0);
        assertEquals(a.getImaginary(), 1);
        a = new ComplexNumber("i");
        assertEquals(a.getReal(), 0);
        assertEquals(a.getImaginary(), 1);
        a = new ComplexNumber("-i");
        assertEquals(a.getReal(), 0);
        assertEquals(a.getImaginary(), -1);

        //empty string
        a = new ComplexNumber("");
        assertEquals(a.getReal(), 0);
        assertEquals(a.getImaginary(), 0);
    }

    @Test
    public void testPlus() {
        ComplexNumber a = new ComplexNumber("5+3i");
        ComplexNumber b = new ComplexNumber("2-3i");
        ComplexNumber c = a.add(b);
        assertEquals(c.getReal(), 7);
        assertEquals(c.getImaginary(), 0);
        b = new ComplexNumber("-7-6i");
        c = a.add(b);
        assertEquals(c.getReal(), -2);
        assertEquals(c.getImaginary(), -3);
    }
}
