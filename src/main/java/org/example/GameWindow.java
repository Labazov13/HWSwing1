package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 0;
    private static final int WINDOW_POSY = 0;
    JButton btnStart = new JButton("New game");
    JButton btnExit = new JButton("Exit");
    Map map;
    SettingWindow setting;

    GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setResizable(false);
        map = new Map();
        setting = new SettingWindow(this);
        btnExit.addActionListener((e) -> System.exit(0));

        btnStart.addActionListener((e) -> setting.setVisible(true));

        setting.setVisible(true);
        JPanel panelBottom = new JPanel(new GridLayout(1, 2));
        panelBottom.add(btnStart);
        panelBottom.add(btnExit);
        add(panelBottom, BorderLayout.SOUTH);
        add(map);
        setVisible(true);
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}
