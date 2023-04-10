package org.example;
import java.awt.*;
import javax.swing.JFrame;

class Picture extends Canvas {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("вызван метод paint() ");
        Rectangle r = g.getClipBounds();

        g.setColor(new Color(25, 168, 1));
        g.fillRoundRect(r.x + 11, r.y + 11, r.width - 22, r.height - 22,150,150);
        g.setColor(new Color(0, 0, 0));
        g.drawRoundRect(r.x + 11, r.y + 11, r.width - 22, r.height - 22,150,150);

        g.setFont(new Font("Areal",3,150));
        g.drawString("fmiit",(int)r.getCenterX()-150,(int)r.getCenterY()+90);

        int[] Xmas = {200,265,295,300,365,305,320,275,200,250};
        int[] Ymas = {370,370,305,370,370,405,470,430,470,405};
        Polygon polyg = new Polygon(Xmas,Ymas,10);
        g.setColor(new Color(25, 255, 255));
        g.fillPolygon(polyg);
        g.setColor(new Color(0, 0, 0));
        g.drawPolygon(polyg);
    }
}

class Form extends JFrame {
    public Form() {
        super("Рисунок");
        setBounds(10, 10, 500, 510);
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


