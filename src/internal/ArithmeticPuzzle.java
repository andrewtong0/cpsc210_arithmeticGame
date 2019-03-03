package internal;

import external.Composite;
import external.Leaf;
import external.NumberFact;
import ui.GUI;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class ArithmeticPuzzle {
    private int questionCount = 0;
    private int maxQuestions;
    private int percentage;
    private int difficulty;

    private QuestionHandler questionHandler;

    // REQUIRES: int, maxQuestions for completion
    // MODIFIES: this
    // EFFECTS: constructs ArithmeticPuzzleOld with specified number of questions
    public ArithmeticPuzzle(int maxQuestions){
        this.maxQuestions = maxQuestions;
        questionHandler = new QuestionHandler();
        System.out.println("Creating puzzle with " + String.valueOf(maxQuestions) + " questions.");
    }

    // MODIFIES: this
    // EFFECTS: adds one to the question count
    public void addOneToCounter(){
        if (this.questionCount < maxQuestions){
            this.questionCount += 1;
        }
    }

    // EFFECTS: returns true if all questions are done, false if not
    public boolean areQuestionsComplete(){
        if (questionCount == maxQuestions){
            return true;
        }
        else{
            return false;
        }
    }

    public String returnScoreAsString(int score, User user){
        String extraMessage;
        String message = ("You got " + String.valueOf(score) + " out of " + String.valueOf(maxQuestions) + " questions correct. ");
        this.percentage = score*100/maxQuestions;
        if (percentage <= 50){
            extraMessage = "Work harder!";
        }
        else if (percentage <= 75){
            extraMessage = "Not bad, keep it up!";
        }
        else if (percentage <= 90){
            extraMessage = "Good job!";
        }
        else{
            extraMessage = "Excellent job!";
            Achievement perfectScore = new Achievement("Perfection");
            user.addAchievement(perfectScore);
        }
        return(message + extraMessage);
    }

    public void initComposite(){
        Composite global = new Composite("Global Hierarchy");
        Composite team1 = new Composite("Team 1");
        Composite team2 = new Composite("Team 2");
        Composite team1RedFaction = new Composite("Red Faction (1)");
        Composite team1BlueFaction = new Composite("Blue Faction (1)");
        Composite team2YellowFaction = new Composite("Yellow Faction (2)");
        Leaf player1 = new Leaf ("Player 1");
        Leaf player2 = new Leaf ("Player 2");
        Leaf player3 = new Leaf ("Player 3");
        Leaf player4 = new Leaf ("Player 4");

        global.addComponent(team1);
        global.addComponent(team2);
        team1.addComponent(team1RedFaction);
        team1.addComponent(team1BlueFaction);
        team2.addComponent(team2YellowFaction);
        team1RedFaction.addComponent(player1);
        team1BlueFaction.addComponent(player2);
        team2YellowFaction.addComponent(player3);
        team2YellowFaction.addComponent(player4);

        global.print();
    }

    // EFFECTS: returns question count
    public int getQuestionCount(){
        return questionCount;
    }

    // EFFECTS: returns maximum number of questions
    public int getMaxQuestions(){
        return maxQuestions;
    }

    // EFFECTS: generates questions based on the for loop
    public static void main(String[] args) throws IOException {
        GUI gui = new GUI();
        int score = 0;

        gui.setState("setup");
        gui.createMenuUI();

        while(gui.getCurrentState() == "setup"){
            gui.sleep();
        }
        gui.setState("num_questions");
        gui.displayString("Please input how many questions you would like to answer.", 80, 225);
        gui.awaitValidInput();
        int numQuestions = gui.answer;

        NumberFact funFact = new NumberFact(numQuestions);
        funFact.printFact();

        ArithmeticPuzzle puzzle = new ArithmeticPuzzle(numQuestions);
        puzzle.initComposite();
        UserAuthentication ua = new UserAuthentication();
        gui.setState("difficulty_selector");
        gui.displayString("Please select your difficulty [1] = Easy | [2] = Hard", 130, 225);

        QuestionHandler questionHandler = new QuestionHandler();

        gui.awaitValidInput();
        int difficulty = gui.answer;
        questionHandler.setDifficulty(difficulty);

        User user = new User("", 2);
        System.out.println(gui.getCurrentState());
        gui.gameInit();
        gui.setState("request_ready");

        while(gui.getCurrentState() == "request_ready"){
            gui.sleep();
        }

        questionHandler.setNumberOfQuestions(numQuestions);
        score = questionHandler.generateQuestions(gui);

        gui.gameOver();

        gui.displayString(puzzle.returnScoreAsString(score, user), 110, 230);
        gui.displayStringNoClear("Percentage: " + String.valueOf(puzzle.percentage) + "%", 300, 260);
        gui.displayAchievement(puzzle.percentage);
        user.getAchievements();
        Reader newReader = new Reader();
        newReader.writePercentageToFile(puzzle.percentage);
    }
}
