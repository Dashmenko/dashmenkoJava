package org.example;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JFrame;

class Picture extends Canvas {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Rectangle r = g.getClipBounds();
        g.setColor(Color.ORANGE);
        g.fillOval(r.x + 10, r.y + 10, r.width - 20, r.height - 20);
        g.setColor(new Color(0, 127, 0));
        g.drawOval(r.x + 11, r.y + 11, r.width - 22, r.height - 22);
    }
}

class Form extends JFrame {
    public Form() {
        super("Рисунок");
        setBounds(100, 50, 380, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Picture());
        validate();
        setVisible(true);
    }
}

public class Runner {
    public static void main(String[] args) {
        new Form();
    }
}