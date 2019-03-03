package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import internal.ArithmeticPuzzle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArithmeticPuzzleTests {

    ArithmeticPuzzle newPuzzle;
    @BeforeEach
    public void initialize(){
         newPuzzle = new ArithmeticPuzzle(10);
    }

    @Test
    public void addOneToCounterZero(){
        newPuzzle.addOneToCounter();
        assertEquals(newPuzzle.getQuestionCount(), 1);
    }

    @Test
    public void addOneToCounterMax(){
        for (int i = 0; i < 15; i++){
            newPuzzle.addOneToCounter();
        }
        assertEquals(newPuzzle.getQuestionCount(), 10);
    }

    @Test
    public void questionsNotComplete(){
        assertFalse(newPuzzle.areQuestionsComplete());
    }
    @Test
    public void someQuestionsCompleteButNotAll(){
        for (int i = 0; i < 3; i++){
            newPuzzle.addOneToCounter();
        }
        assertFalse(newPuzzle.areQuestionsComplete());
    }

    @Test
    public void allQuestionsComplete(){
        for (int i = 0; i< 10; i++){
            newPuzzle.addOneToCounter();
        }
        assertTrue(newPuzzle.areQuestionsComplete());
    }

    @Test
    public void getQuestionCountVerify(){
        assertEquals(newPuzzle.getQuestionCount(), 0);
    }

    @Test
    public void getMaxQuestionsVerify(){
        assertEquals(newPuzzle.getMaxQuestions(), 10);
    }
}
