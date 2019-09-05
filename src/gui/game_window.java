package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class game_window {
    JFrame mainframe;
    JButton button_replay;
    JButton button_mainwindow;

    JPanel panel;
    JButton button[][];

    int status[][];

    boolean currentPlayerIsX;

    public game_window(){
        status = new int[3][3];
        for (int i = 0; i<3;i++){
            for (int j = 0; j < 3; j++){
                status[i][j] = -1;
            }
        }
        setup_window();
    }

    void setup_window(){
        currentPlayerIsX = true;

        mainframe = new JFrame();

        panel = new JPanel(new GridLayout(3,3));
        button = new JButton[3][3];
        setup_panel();

        button_replay = new JButton("play again");
        setup_replayButton();

        button_mainwindow = new JButton("Go Back");
        setup_mainmenuButton();

        mainframe.add(button_mainwindow);

        mainframe.setLayout(null);
        mainframe.setVisible(true);
        mainframe.setSize(800, 1000);
    }

    void setup_panel(){

        panel.setBounds(100, 100, 600, 600);
        mainframe.add(panel);

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                button[i][j] = new JButton("");
                panel.add(button[i][j]);
                setupGameButton(button[i][j], i, j);
            }
        }
    }

    void setupGameButton(JButton button, int x, int y){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentPlayerIsX){
                    currentPlayerIsX = false;
                    button.setText("x");
                    status[x][y] = 1;
                    button.setEnabled(false);
                }
                else {
                    currentPlayerIsX = true;
                    button.setText("O");
                    status[x][y] = 0;
                    button.setEnabled(false);
                }
            }
        });
    }

    void setup_mainmenuButton(){
        button_mainwindow.setBounds(350, 900, 100, 40);
        button_mainwindow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainframe.dispose();
                new main_window();
            }
        });
    }

    void setup_replayButton(){
        button_replay.setBounds(350, 800, 100, 40);
        button_replay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetBoard();
            }
        });
        mainframe.add(button_replay);
    }

    void resetBoard(){
        currentPlayerIsX = true;

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                button[i][j].setEnabled(true);
                button[i][j].setText("");
                status[i][j] = -1;
            }
        }
    }
}
