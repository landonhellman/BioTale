package Main;

import javax.swing.*;
import java.awt.*;
import Main.GamePanel;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        GamePanel gp = new GamePanel();
        Container con = window.getContentPane();
        JPanel titleNamePanel = new JPanel();
        JLabel timeNameLabel = new JLabel("Lives: " + gp.getLives());
        titleNamePanel.setBounds(620, 48, 100, 48);
        titleNamePanel.setBackground(Color.blue);
        timeNameLabel.setForeground(Color.white);
        titleNamePanel.add(timeNameLabel);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Avoid the Bile!");
        con.add(titleNamePanel);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);


        gamePanel.startGameThread();


    }
}