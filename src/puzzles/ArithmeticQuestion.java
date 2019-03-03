package puzzles;

import exceptions.ExceededInputException;
import exceptions.InvalidInputException;

import java.util.Random;

public class ArithmeticQuestion {
    Random rInt = new Random();

    private Integer int1;
    private Integer int2;
    private String questionString;
    private int difficulty;
    private String operator;

    public ArithmeticQuestion(int difficulty){
        this.difficulty = difficulty;
    }

    public void generateNumbers(){
        int1 = rInt.nextInt(10) + 1;
        int2 = rInt.nextInt(10) + 1;
    }

    public void makeQuestion(){
        generateNumbers();
        switch(difficulty){
            case(1):
                int operatorInt = rInt.nextInt(2);
                if (operatorInt == 0){
                    operator = " + ";
                }
                else {
                    operator = " - ";
                }
                break;
            case(2):
                operator = " x ";
                break;
        }
    }

    public int getAnswer(){
        if (operator == " + "){
            return (int1 + int2);
        }
        else if (operator == " - "){
            return (int1 - int2);
        }
        else {
            return (int1 * int2);
        }
    }

    public String returnQuestion(){
        makeQuestion();
        questionString = Integer.toString(int1) + operator + Integer.toString(int2);
        return(questionString);
    }

    public void validateInput(String input) throws InvalidInputException{
        if (!input.matches("^-?[0-9]+$")){
            throw new InvalidInputException();
        }
    }

    public void exceedInput (String input) throws ExceededInputException{
        int userInput = Integer.valueOf(input);
        if (userInput > 101 || userInput < -101){
            throw new ExceededInputException();
        }
    }
}