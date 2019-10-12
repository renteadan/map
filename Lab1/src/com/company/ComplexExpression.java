package com.company;

class ComplexExpression {
    private ComplexNumber result;

    ComplexExpression(String[] expression) throws ComplexExpressionError, ComplexNumberError {
        if(expression.length==0)
        {
            throw new ComplexExpressionError("Empty expression");
        }

        if(expression.length % 2 ==0) {
            throw new ComplexExpressionError("Incorrect number of operands");
        }
        result = new ComplexNumber(expression[0]);
        if(!result.isValid())
            throw new ComplexExpressionError("Invalid complex number");
        for(int i=1; i<expression.length-1;i+=2) {
            result = operation(expression[i+1], expression[i]);
        }
    }

    ComplexExpression() {
        result = new ComplexNumber();
    }

    private ComplexNumber operation(String operand, String operation) throws ComplexExpressionError, ComplexNumberError {
        ComplexNumber a = new ComplexNumber(operand);
        if(!a.isValid())
            throw new ComplexNumberError("Complex number is invalid");
        switch (operation) {
            case "+":
                return result.add(a);
            case "-":
                return result.subtract(a);
            case "*":
                return result.multiply(a);
            case "/":
                return result.divide(a);
            default:
                throw new ComplexExpressionError("Operation doesn't exist");

        }
    }

    ComplexNumber getResult() {
        return result;
    }
}
