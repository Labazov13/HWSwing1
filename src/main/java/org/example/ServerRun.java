package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ServerRun extends JFrame implements ListenerInterface{
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JButton runServer = new JButton("Запустить сервер");
    JButton stopServer = new JButton("Остановить сервер");

    ServerListener serverSetting = new ServerSetting(this);

    public ServerRun() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server");
        setResizable(false);

        runServer.addActionListener((e) -> {
            serverSetting.serverListener(false);
        });

        stopServer.addActionListener((e) -> {
            serverSetting.serverListener(true);
        });
        setLayout(new GridLayout(1, 2));
        add(runServer);
        add(stopServer);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ServerRun();
    }

    @Override
    public void messageResult(String text) {
        System.out.println(text);
    }
}
