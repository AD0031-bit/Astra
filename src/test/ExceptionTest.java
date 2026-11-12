package test;

import astra.exceptions.InvalidChoiceException;
import astra.exceptions.InsufficientResourceException;

public class ExceptionTest {

    public static void main(String[] args) {

        // Test InvalidChoiceException
        try {
            throw new InvalidChoiceException("Invalid menu choice!");
        } 
        catch (InvalidChoiceException e) {
            System.out.println(e.getMessage());
        }

        // Test InsufficientResourceException
        try {
            throw new InsufficientResourceException("Not enough resources!");
        } 
        catch (InsufficientResourceException e) {
            System.out.println(e.getMessage());
        }
    }
}