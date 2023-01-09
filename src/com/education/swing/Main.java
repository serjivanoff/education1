package com.education.swing;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < 300; i++) {
            g.drawString("Тимофей молодчина", i, 300-i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.clearRect(0, 0, 300, 300);
        }
    }

    public static void main(String[] args) {
        new Main("Тимофей учится");
    }
}
