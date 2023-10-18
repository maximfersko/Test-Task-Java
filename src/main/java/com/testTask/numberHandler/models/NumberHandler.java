package com.testTask.numberHandler.models;

public class NumberHandler {

    public enum OperationType {
        ADD,
        MULTIPLY,
        MULTIPLY_AND_ADD,
        CUSTOM
    }


    private static double add(double[] numbers) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException("Error! that requires 2 or more digits for addition");
        }
        double result = 0;
        for (double number : numbers) {
            result += number;
        }
        return result;
    }

    private static double multiply(double[] numbers) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException("Error! that requires 2 or more digits for multiply");
        }
        double result = 1;
        for (double number : numbers) {
            result *= number;
        }
        return result;
    }

    private static double multAndAdd(double[] numbers) {
        if (numbers.length != 3) {
            throw new IllegalArgumentException("Error ! this operation requires 3 numbers");
        }
        return numbers[0] * numbers[1] + numbers[2];
    }

    private static double div(double[] numbers) {
        if (numbers.length != 2) {
            throw new IllegalArgumentException("Error! that requires 2  digits for divided");
        }
        return  numbers[0] / numbers[1];
    }

    public static double calculate(String data, OperationType operationType) {
        String[] stringNumbers = data.split(",");
        double[] numbers = new double[stringNumbers.length];

       try {
           for (int i = 0; i < stringNumbers.length; ++i) {
               numbers[i] = Double.parseDouble(stringNumbers[i]);
           }

           switch (operationType) {
               case ADD -> {
                   return add(numbers);
               }
               case MULTIPLY -> {
                   return multiply(numbers);
               }
               case MULTIPLY_AND_ADD -> {
                   return multAndAdd(numbers);
               }
               case CUSTOM -> {
                   return div(numbers);
               }
               default -> throw new IllegalArgumentException("Unknown operation: " + operationType);
           }
       } catch (NumberFormatException exp) {
           throw new IllegalArgumentException("Invalid number format");
       }

    }

}
