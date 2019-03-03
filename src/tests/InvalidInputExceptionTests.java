package tests;

import exceptions.InvalidInputException;
import org.junit.jupiter.api.Test;
import puzzles.ArithmeticQuestion;

import static org.junit.jupiter.api.Assertions.fail;

public class InvalidInputExceptionTests {
    ArithmeticQuestion question = new ArithmeticQuestion(1);

    @Test
    public void validInputPositiveInteger(){
        try {
            question.validateInput("3");
        } catch (InvalidInputException e) {
            fail("Unexpected InvalidInputException thrown");
        }
    }

    @Test
    public void validInputNegativeInteger(){
        try {
            question.validateInput("-5");
        } catch (InvalidInputException e) {
            fail("Unexpected InvalidInputException thrown");
        }
    }

    @Test
    public void invalidInputDecimalNoTrailingDigits(){
        try {
            question.validateInput("3.");
            fail("No exceptions thrown when expected");
        } catch (InvalidInputException e) {
        }
    }

    @Test
    public void invalidInputDecimalTrailingDigits(){
        try {
            question.validateInput("41.2");
            fail("No exceptions thrown when expected");
        } catch (InvalidInputException e) {
        }
    }

    @Test
    public void invalidInputLettersInString(){
        try {
            question.validateInput("21as");
            fail("No exceptions thrown when expected");
        } catch (InvalidInputException e) {
        }
    }

    @Test
    public void invalidInputUnknownSymbolsInString(){
        try {
            question.validateInput("251$");
            fail("No exceptions thrown when expected");
        } catch (InvalidInputException e) {
        }
    }
}
