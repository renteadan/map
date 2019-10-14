package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexNumberTest {

    @Test
    public void parseTest() {

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

        a = new ComplexNumber("5+3i");
        assertEquals(a.getReal(), 5);
        assertEquals(a.getImaginary(), 3);
        a = new ComplexNumber("-testi");
        assertFalse(a.isValid());
    }

    @Test
    void addTest() {
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

    @Test
    void subtractTest() {
        ComplexNumber a = new ComplexNumber("5+3i");
        ComplexNumber b = new ComplexNumber("2-3i");
        ComplexNumber c = a.subtract(b);
        assertEquals(c.getReal(), 3);
        assertEquals(c.getImaginary(), 6);
    }

    @Test
    void multiplyTest() {
        ComplexNumber a = new ComplexNumber("5+3i");
        ComplexNumber b = new ComplexNumber("2-4i");
        ComplexNumber c = a.multiply(b);
        assertEquals(c.getReal(),22 );
        assertEquals(c.getImaginary(), -14);
        b = new ComplexNumber("5");
        c = a.multiply(b);
        assertEquals(c.getReal(), 25);
        assertEquals(c.getImaginary(), 15);
        a = new ComplexNumber("3i");
        c = a.multiply(b);
        assertEquals(c.getReal(), 0);
        assertEquals(c.getImaginary(), 15);
    }

    private boolean compareFloats(float a, float b) {
        return Math.abs(a-b) < 0.001f;
    }
    @Test
    void divideTest() {
        ComplexNumber a = new ComplexNumber("5+3i");
        ComplexNumber b = new ComplexNumber("2-4i");
        ComplexNumber c = a.divide(b);
        assertTrue(compareFloats(c.getReal(), -0.1f));
        assertTrue(compareFloats(c.getImaginary(), (13.0f / 10.0f)));
    }
}
