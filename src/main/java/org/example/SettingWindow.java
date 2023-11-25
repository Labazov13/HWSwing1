package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    JButton btnStart = new JButton("Start new game");
    JLabel gameMode = new JLabel("Выберите режим игры");
    JLabel gameField = new JLabel("Выберите размер поля");
    JSlider fieldS = new JSlider(3, 10);
    JLabel heightWin = new JLabel("Выберите длину для победы");
    JSlider heightS = new JSlider(3, 10);
    JRadioButton hVSai = new JRadioButton("Человек -комп");
    JRadioButton hVSh = new JRadioButton("Человек - человек");
    ButtonGroup mode = new ButtonGroup();
    JPanel panCenter;

    SettingWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        panCenter = new JPanel(new GridLayout(8, 1));
        mode.add(hVSai);
        mode.add(hVSh);
        panCenter.add(gameMode);
        panCenter.add(hVSai);
        panCenter.add(hVSh);
        panCenter.add(gameField);
        panCenter.add(fieldS);
        panCenter.add(heightWin);
        panCenter.add(heightS);
        panCenter.add(btnStart);
        fieldS.addChangeListener(
                (e) -> gameField.setText("Установленный размер: " + fieldS.getValue()));

        btnStart.addActionListener((e) -> {
            gameWindow.startNewGame(hVSai.isSelected() ? 0 : 1, fieldS.getValue(), fieldS.getValue(), heightS.getValue());
            setVisible(false);
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        add(panCenter);
        heightS.addChangeListener(
                (e) -> heightWin.setText("Установленная длина победы: " + heightS.getValue()));
    }


}
