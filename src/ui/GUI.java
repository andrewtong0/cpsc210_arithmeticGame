package ui;

import exceptions.InvalidInputException;
import org.omg.CORBA.DynAnyPackage.Invalid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    Image image = Toolkit.getDefaultToolkit().getImage("img/perfect.png");
    Image startscreen = Toolkit.getDefaultToolkit().getImage("img/startscreen.png");
    ImagePanel ip = new ImagePanel();
    JFrame frm = new JFrame("Some Sort of Math Game");
    Boolean button_pressed = false;
    private int width = 800;
    private int height = 450;
    private String state = "";
    public int answer;

    JButton submit = new JButton("Submit");
    JTextField textField = new JTextField(25);

    public void initGUI(){
        frm.setLayout(null);
        frm.setSize( width, height );
        frm.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frm.setVisible( true );
        frm.setResizable(false);

        Font font = new Font(null, Font.PLAIN, 24);
        frm.setFont(font);
    }

    public void sleep(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
    }

    public void awaitValidInput(){
        while(!button_pressed){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        button_pressed = false;
    }

    public void handleInput(String s){
        try {
            checkInput(s);
            answer = Integer.parseInt(s);
            System.out.println(answer);
            button_pressed = true;
        } catch (Exception e){
            System.out.println("Invalid input. Please try again!");
        }
    }

    public void checkInput(String s) throws InvalidInputException{
        if (state == "num_questions"){
            try {
                int input = Integer.parseInt(s);
                if (input <= 0){
                    throw new InvalidInputException();
                }
            }
            catch (Exception e){
                displayString("Please input how many questions you would like to answer.", 80, 225);
                displayStringNoClear("Please ensure your # questions is > 0!", 200, 260 );
                throw new InvalidInputException();
            }
        }
        if (state == "difficulty_selector"){
            try {
                int input = Integer.parseInt(s);
                if (input != 1 && input != 2){
                    throw new InvalidInputException();
                }
            }
            catch (Exception e){
                displayString("Please select your difficulty [1] = Easy | [2] = Hard", 130, 225);
                displayStringNoClear("Please ensure your difficulty selector is a 1 or a 2!", 130, 260 );
                throw new InvalidInputException();
            }
        }
    }

    public void clear(Graphics g){
        super.paint(g);
        g.setColor(Color.ORANGE);
        g.fillRect(0, -50, width, height);
    }

    public void setState(String s){
        this.state = s;
        ip.syncState(s);
    }

    public String getCurrentState(){
        return this.state;
    }

    public void displayString(String s, int x, int y){
        sleep();
        clear(frm.getGraphics());
        frm.getGraphics().drawString(s, x, y);
    }

    public void displayStringNoClear(String s, int x, int y){
        sleep();
        frm.getGraphics().drawString(s, x, y);
    }

    public void createMenuUI(){
        initGUI();
        ip.paintComponent(frm.getGraphics());
        int menu_placement_x = width/2;
        int menu_placement_y = 323;

        JButton quit = new JButton("Quit");
        JButton play = new JButton("Play");
        play.setBounds(menu_placement_x - 100, menu_placement_y, 80, 30);
        quit.setBounds(menu_placement_x, menu_placement_y, 80, 30);
        frm.add(quit);
        frm.add(play);

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createGameUI();
                setState("ready");
                frm.remove(quit);
                frm.remove(play);
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frm.setVisible(true);
    }

    public void gameInit(){
        JButton confirmReady = new JButton("START");
        confirmReady.setBounds(width/2-60, height/2-60, 120, 60);
        frm.add(confirmReady);
        initGUI();
        confirmReady.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setState("game_start");
                frm.remove(confirmReady);
            }
        });
    }

    public void displayAchievement(int p){
        if (p == 100){
            sleep();
            frm.getGraphics().drawImage(image, 350, 270, this);
        }
    }

    public void gameOver(){
        JButton quit = new JButton("Quit");

        submit.setVisible(false);
        textField.setVisible(false);
        frm.remove(submit);
        frm.remove(textField);
        frm.add(quit);

        quit.setBounds(width/2-65, 385, 120, 20);

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void createGameUI(){
        int menu_placement_x = width/2;

        submit.setBounds(menu_placement_x - 90, 380, 80, 30);
        textField.setBounds(menu_placement_x, 380, 80, 30);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleInput(textField.getText());
                textField.setText("");
            }
        });

        // Adding elements to frame
        frm.add(submit);
        frm.getContentPane().add(textField);
        frm.getGraphics().drawImage(image, -500, -500, this);
        initGUI();
    }
}
