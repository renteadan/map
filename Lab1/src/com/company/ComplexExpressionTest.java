package com.company;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
class ComplexExpressionTest {

    private String[] arr;
    void initializeFirst() {
        arr = new String[3];
        arr[0] = "3+5i";
        arr[1] = "+";
        arr[2] = "2-4i";
    }

    void initializeSecond() {
        arr = new String[7];
        arr[0] = "3+5i";
        arr[1] = "+";
        arr[2] = "2-4i";
        arr[3] = "-";
        arr[4] = "2+7i";
        arr[5] = "-";
        arr[6] = "-9-5i";
    }

    void initializeThird() {
        arr = new String[2];
        arr[0] = "3+5i";
        arr[1] = "+";
    }

    @Test
    void expressionTest() {
        initializeFirst();
        expressionBlockTest(5, 1, false);
        initializeSecond();
        expressionBlockTest(12 ,-1, false);
        arr = new String[]{"2+3i", "*", "1+5i"};
        expressionBlockTest(-13, 13, false);
        arr = new String[]{};
        expressionBlockTest(0, 0,true);

    }

    void expressionBlockTest(float real, float img, boolean isFailing) {
        ComplexExpression exp = new ComplexExpression();
        try {
            exp = new ComplexExpression(arr);
        } catch (ComplexExpressionError | ComplexNumberError err) {
            assertTrue(isFailing);
            return;
        }
        ComplexNumber result = exp.getResult();
        assertEquals(result.getReal(), real);
        assertEquals(result.getImaginary(), img);
    }

    void tryCatchInitialize() {
        ComplexExpression exp = new ComplexExpression();
        try {
            exp = new ComplexExpression(arr);
        } catch (ComplexExpressionError | ComplexNumberError err) {
            assertEquals(1, 1); }
    }

    private void divideTest() {
        try {
            ComplexExpression err = new ComplexExpression(arr);
            ComplexNumber c = err.getResult();
            assertTrue(compareFloats(c.getReal(), -0.1f));
            assertTrue(compareFloats(c.getImaginary(), (13.0f / 10.0f)));
        } catch (ComplexNumberError | ComplexExpressionError ignored) {};
    }

    @Test
    void expressionErrorsTest() {
        initializeThird();
        tryCatchInitialize();
        arr = new String[]{};
        tryCatchInitialize();
        arr = new String[]{"random", "+", "string"};
        tryCatchInitialize();
        arr = new String[]{"5+3i", "x", "9-2i"};
        tryCatchInitialize();
        arr = new String[]{"5+3i", "+", "random"};
        tryCatchInitialize();
        arr = new String[]{"5+3i", "/", "2-4i"};
        divideTest();
    }

    private boolean compareFloats(float a, float b) {
        return Math.abs(a-b) < 0.001f;
    }
}
