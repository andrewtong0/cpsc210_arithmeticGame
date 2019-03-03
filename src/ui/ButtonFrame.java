package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrame extends JFrame{
    JButton bChange ; // reference to the button object

    // constructor for ButtonFrame
    ButtonFrame(String title)
    {
        super( title );                     // invoke the JFrame constructor
        setLayout( new FlowLayout() );      // set the layout manager

        bChange = new JButton("Click Me!"); // construct a JButton
        add( bChange );                     // add the button to the JFrame
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}
