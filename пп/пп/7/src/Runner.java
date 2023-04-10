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
        g.setColor(Color.BLACK);

        g.fillRoundRect( 170, 150,  100, 180, 80, 60);

        g.fillRect(120, 285, 200, 50);

        g.setColor(new Color(5, 0, 0));

        int[] x  = {42,52,72,52,60,40,15,28,9,32,42};
        int[] y = {38,62,68,80,105,85,102,75,58,60,38};
        g.fillPolygon(x , y, 11);

        g.drawString("Ритуальные услуги", 140, 80);
        g.drawString("Минимализм нынче в моде", 120, 110);
    }
}

class Form extends JFrame {
    public Form() {
        super("Приходите ещё");
        setBounds(200, 100, 480, 450);
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