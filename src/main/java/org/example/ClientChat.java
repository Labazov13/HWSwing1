package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class ClientChat extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JPanel panel = new JPanel(new GridLayout(6, 1));
    JPanel panelClient = new JPanel(new GridLayout(4, 1));
    JButton buttonSend = new JButton("Отправить");
    String message;
    Label lblLogin = new Label("Login:");
    Label lblMessage = new Label("Message");
    private static JTextField login = new JTextField();

    private static JTextField fieldMessage = new JTextField();
    JTextArea area = new JTextArea(6, 1);


    public ClientChat() throws HeadlessException, IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat");
        setResizable(false);
        area.setEditable(false);
        panel.add(lblLogin);
        panel.add(login);

        panelClient.add(area);
        panelClient.add(lblMessage);
        panelClient.add(fieldMessage);

        panelClient.add(buttonSend);
        setLayout(new GridLayout(2, 1));
        add(panel);
        add(panelClient);
        new WriteHistory(this);

        fieldMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if(key == KeyEvent.VK_ENTER){
                    message = login.getText() + " " + fieldMessage.getText() + "\n";
                    area.append(message);
                    try {
                        FileOperation fileOperation = new FileOperation(message);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println("Отправлено " + fieldMessage.getText());
                }
            }
        });


        buttonSend.addActionListener((e) -> {
            message = login.getText() + " " + fieldMessage.getText() + "\n";
            area.append(message);
            System.out.println("Отправлено " + fieldMessage.getText());
        });
        setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        new ClientChat();
    }
}
