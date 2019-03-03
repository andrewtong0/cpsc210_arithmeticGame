package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import puzzles.QuestionSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterfaceTests {
    QuestionSet newQuestionSet;
    @BeforeEach
    public void initialize(){
        newQuestionSet = new QuestionSet();
    }

    // ADDITION
    @Test
    public void calculateAnswerGeneralIntsAddition(){
        newQuestionSet.num1 = 10;
        newQuestionSet.num2 = 5;
        newQuestionSet.operand = " + ";
        assertEquals(newQuestionSet.calculateAnswer(newQuestionSet.num1, newQuestionSet.num2), 15);
    }

    @Test
    public void calculateAnswerZeroesAddition(){
        newQuestionSet.num1 = 0;
        newQuestionSet.num2 = 0;
        newQuestionSet.operand = " + ";
        assertEquals(newQuestionSet.calculateAnswer(newQuestionSet.num1, newQuestionSet.num2), 0);
    }

    @Test
    public void calculateAnswerNegativesAddition(){
        newQuestionSet.num1 = -4;
        newQuestionSet.num2 = -6;
        newQuestionSet.operand = " + ";
        assertEquals(newQuestionSet.calculateAnswer(newQuestionSet.num1, newQuestionSet.num2), -10);
    }

    // SUBTRACTION
    @Test
    public void calculateAnswerGeneralIntsSubtraction(){
        newQuestionSet.num1 = 10;
        newQuestionSet.num2 = 5;
        newQuestionSet.operand = " - ";
        assertEquals(newQuestionSet.calculateAnswer(newQuestionSet.num1, newQuestionSet.num2), 5);
    }

    @Test
    public void calculateAnswerZeroesSubtraction(){
        newQuestionSet.num1 = 0;
        newQuestionSet.num2 = 0;
        newQuestionSet.operand = " - ";
        assertEquals(newQuestionSet.calculateAnswer(newQuestionSet.num1, newQuestionSet.num2), 0);
    }

    @Test
    public void calculateAnswerNegativesSubtraction(){
        newQuestionSet.num1 = -4;
        newQuestionSet.num2 = -6;
        newQuestionSet.operand = " - ";
        assertEquals(newQuestionSet.calculateAnswer(newQuestionSet.num1, newQuestionSet.num2), 2);
    }

    // MULTIPLICATION
    @Test
    public void calculateAnswerGeneralIntsMultiplication(){
        newQuestionSet.num1 = 10;
        newQuestionSet.num2 = 5;
        newQuestionSet.operand = " x ";
        assertEquals(newQuestionSet.calculateAnswer(newQuestionSet.num1, newQuestionSet.num2), 50);
    }

    @Test
    public void calculateAnswerZeroesMultiplication(){
        newQuestionSet.num1 = 0;
        newQuestionSet.num2 = 0;
        newQuestionSet.operand = " x ";
        assertEquals(newQuestionSet.calculateAnswer(newQuestionSet.num1, newQuestionSet.num2), 0);
    }

    @Test
    public void calculateAnswerNegativesMultiplicationPositiveAnswer(){
        newQuestionSet.num1 = -4;
        newQuestionSet.num2 = -6;
        newQuestionSet.operand = " x ";
        assertEquals(newQuestionSet.calculateAnswer(newQuestionSet.num1, newQuestionSet.num2), 24);
    }

    @Test
    public void calculateAnswerNegativesMultiplicationNegativeAnswer(){
        newQuestionSet.num1 = 4;
        newQuestionSet.num2 = -6;
        newQuestionSet.operand = " x ";
        assertEquals(newQuestionSet.calculateAnswer(newQuestionSet.num1, newQuestionSet.num2), -24);
    }

    @Test
    public void presentQuestionAsStringValid() {
        newQuestionSet.num1 = 3;
        newQuestionSet.num2 = 4;
        newQuestionSet.operand = " + ";
        newQuestionSet.answer = 7;
        assertEquals(newQuestionSet.presentQuestionAsString(), "3 + 4");
    }

    @Test
    public void presentQuestionAsStringInvalidError() {
        newQuestionSet.answer = null;
        assertEquals(newQuestionSet.presentQuestionAsString(), "Error, no question detected");
    }
}
