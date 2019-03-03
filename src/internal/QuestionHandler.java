package internal;

import puzzles.ArithmeticQuestion;
import ui.GUI;

import java.util.Scanner;

public class QuestionHandler {
    private String nextQuestionString;
    private int nextQuestionAnswer;
    private int difficulty;
    private int numQuestions;
    private int score;
    Scanner scan = new Scanner(System.in);

    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }

    public void setNumberOfQuestions(int num){
        numQuestions = num;
    }

    public int generateQuestions(GUI g){
        score = 0;
        for (int i = 0; i < numQuestions; i++){
            int answer = makeNextQuestion(g);
            g.awaitValidInput();
            if (answer == g.answer){
                score += 1;
                System.out.println("Correct");
            }
            else {
                System.out.println("Incorrect");
            }
        }
        return score;
    }

    // MODIFIES: nextQuestionString/nextQuestionAnswerString with associated values
    // EFFECTS: makes a new question and prints its values
    public int makeNextQuestion(GUI g){
        ArithmeticQuestion nextQuestion = new ArithmeticQuestion(difficulty);
        g.displayString(nextQuestion.returnQuestion(), 360, 225);
        g.displayStringNoClear("Score: " + String.valueOf(score), 80, 80);
        nextQuestionAnswer = nextQuestion.getAnswer();
        System.out.println(nextQuestionString);
        return nextQuestionAnswer;
    }
}
