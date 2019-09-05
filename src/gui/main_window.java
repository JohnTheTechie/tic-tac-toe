package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_window{
    boolean b_vsComp;

    JFrame frame;
    JButton button_play;
    JCheckBox button_playFirst;
    JButton button_vsComp;

    private static final String[] array_versus_text = {"vs comp", "vs human"};


    public main_window(){
        b_vsComp = true;

        frame = new JFrame();

        button_play = new JButton("play");
        button_play.setBounds(100, 100, 100, 40);
        button_play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Starter_config_object message = new Starter_config_object();
                message.setPlayFirst(button_playFirst.isSelected());
                message.setVsComp(b_vsComp);
                message.setRemote(false);
                new game_window();
                frame.dispose();
            }
        });
        frame.add(button_play);

        button_vsComp = new JButton("vs comp");
        button_vsComp.setBounds(100, 150, 100, 40);
        button_vsComp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(b_vsComp){
                    b_vsComp = false;
                    button_vsComp.setText(array_versus_text[1]);
                }
                else {
                    b_vsComp = true;
                    button_vsComp.setText(array_versus_text[0]);
                }
            }
        });
        frame.add(button_vsComp);

        button_playFirst = new JCheckBox("play first?", true);
        button_playFirst.setBounds(100, 200, 100, 40);
        frame.add(button_playFirst);

        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }


}
