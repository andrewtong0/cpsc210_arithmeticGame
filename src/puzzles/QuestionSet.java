package puzzles;

import java.util.Random;
import java.util.Scanner;

public class QuestionSet implements createQuestion, createQuestionSet {
    public Integer num1;
    public Integer num2;
    public String operand;
    public Integer answer;
    private Integer rIntLimit = 10; // Max number that can be generated for a question
    Random rInt = new Random();
    Scanner scan = new Scanner(System.in);

    @Override
    public void generateNumbers() {
        num1 = rInt.nextInt(rIntLimit) + 1;
        num2 = rInt.nextInt(rIntLimit) + 1;
    }

    @Override
    public String selectOperand() {
        System.out.println("Please select the type of questions to be generated:");
        System.out.println("[1] Addition | [2] Subtraction | [3] Multiplication");
        Integer operandInput = scan.nextInt();
        String operandWord = "";

        switch(operandInput) {
            case 1: // Addition
                operand = " + ";
                operandWord = "addition";
                break;
            case 2: // Subtraction
                operand = " - ";
                operandWord = "subtraction";
                break;
            case 3: // Multiplication
                operand = " x ";
                operandWord = "multiplication";
                break;
        }
        System.out.println("The system will now generate " + operandWord + " questions.");
        return(operand);
    }

    @Override
    public int calculateAnswer(Integer num1, Integer num2) {
        switch(operand){
            case(" + "):
                answer = (num1 + num2);
                break;
            case(" - "):
                answer = (num1 - num2);
                break;
            case(" x "):
                answer = (num1 * num2);
                break;
        }
        return(answer);
    }

    @Override
    public String presentQuestionAsString() {
        if(answer != null){
            String question = num1.toString() + operand + num2.toString();
            System.out.println(question);
            return(question);
        }
        else{
            return("Error, no question detected");
        }
    }

    @Override
    public void makeQuestion() {
        generateNumbers();
        selectOperand();
        calculateAnswer(num1, num2);
        presentQuestionAsString();
    }

    @Override
    public void setWithNumQuestions(Integer numQuestions) {
        for(Integer i = 0; i < numQuestions; i++){
            System.out.println("Question " + i.toString());
            makeQuestion();
            requestAnswerAndCheck();
        }
    }

    @Override
    public void requestAnswerAndCheck(){
        Integer userAnswer = scan.nextInt();
        if(userAnswer == answer){
            System.out.println("Correct!");
        }
        else {
            System.out.println("Incorrect.");
        }
    }
}
