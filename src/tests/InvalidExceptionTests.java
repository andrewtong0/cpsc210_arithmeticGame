package tests;

import exceptions.ExceededInputException;
import exceptions.InvalidInputException;
import org.junit.jupiter.api.Test;
import puzzles.ArithmeticQuestion;

import static org.junit.jupiter.api.Assertions.fail;

public class InvalidExceptionTests {
    ArithmeticQuestion question = new ArithmeticQuestion(1);

    @Test
    public void validInputPositive() {
        try {
            question.validateInput("2");
        } catch (InvalidInputException e) {
            fail("Failed test");
        }
    }

    @Test
    public void validInputNegative() {
        try {
            question.validateInput("-2");
        } catch (InvalidInputException e) {
            fail("Failed test");
        }
    }

    @Test
    public void invalidInputLetters() {
        try {
            question.validateInput("21a");
            fail("Failed test");
        } catch (InvalidInputException e) {
        }
    }

    @Test
    public void invalidInputSymbols() {
        try {
            question.validateInput("2&");
            fail("Failed test");
        } catch (InvalidInputException e) {
        }
    }

    @Test
    public void validInputWithinRange() {
        try {
            question.exceedInput("2");
        } catch (ExceededInputException e) {
            fail("Failed test");
        }
    }

    @Test
    public void invalidInputNegative() {
        try {
            question.exceedInput("-200");
            fail("Failed test");
        } catch (ExceededInputException e) {
        }
    }

    @Test
    public void invalidInputPositive() {
        try {
            question.exceedInput("200");
            fail("Failed test");
        } catch (ExceededInputException e) {
        }
    }
}
