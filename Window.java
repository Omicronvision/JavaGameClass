package com.example.main;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    private static final long serialVersionUID = -6158311525001836764L;

    public Window(int sizeX, int sizeY,String title, Game game)
    {
        JFrame frame = new JFrame(title); //set the title of the game
        frame.setPreferredSize(new Dimension(sizeX, sizeY)); //size of the game
        frame.setMaximumSize(new Dimension(sizeX, sizeY)); //max size of the game
        frame.setMinimumSize(new Dimension(sizeX, sizeY)); //min size of the game
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when game is closed
        frame.setResizable(false); //set if the game can be resized
        frame.setLocationRelativeTo(null); //set the position of the game
        frame.add(game); //add things to the game

        frame.setVisible(true); //make the game window visible
        game.start(); //start the game

    }
}
