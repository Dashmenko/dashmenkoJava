package laba5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

class WindowGUI extends JFrame {
    public WindowGUI() {
        super("Graphic");
        this.setBounds(100,100,250,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(7,2,3,3));

        JLabel startXLabel  = new JLabel(" start:");
        JLabel endXLabel    = new JLabel(" end:");
        JLabel aLabel       = new JLabel(" a:");
        JLabel bLabel       = new JLabel(" b:");
        JLabel cLabel       = new JLabel(" c:");
        JLabel dLabel       = new JLabel(" d:");

        JTextField startXTextField  = new JTextField();
        JTextField endXTextField    = new JTextField();
        JTextField aTextField       = new JTextField();
        JTextField bTextField       = new JTextField();
        JTextField cTextField       = new JTextField();
        JTextField dTextField       = new JTextField();

        container.add(startXLabel);
        container.add(startXTextField);
        container.add(endXLabel);
        container.add(endXTextField);
        container.add(aLabel);
        container.add(aTextField);
        container.add(bLabel);
        container.add(bTextField);
        container.add(cLabel);
        container.add(cTextField);
        container.add(dLabel);
        container.add(dTextField);

        JButton buldGraphic = new JButton("Build");
        buldGraphic.addActionListener(
                new laba5.buildGraphic(startXTextField, endXTextField, aTextField, bTextField, cTextField, dTextField, rTextFiel)
        );
        container.add(buldGraphic);

        validate();
        setVisible(true);
    }
}


class buildGraphic implements ActionListener {
    JTextField start, end, a, b, c, d, r;

    public buildGraphic(JTextField start, JTextField end, JTextField a, JTextField b, JTextField c, JTextField d, JTextField r) {
        this.start  = start;
        this.end    = end;
        this.a      = a;
        this.b      = b;
        this.c      = c;
        this.d      = d;
        this.r =r;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        new laba5.Graphic(
                Integer.parseInt(start.getText()),
                Integer.parseInt(end.getText()),
                Double.parseDouble(a.getText()),
                Double.parseDouble(b.getText()),
                Double.parseDouble(c.getText()),
                Double.parseDouble(d.getText()));
    }
}

class Graphic extends JFrame {
    public static final int X_CENTER = 250;
    public static final int Y_CENTER = 250;
    public static final int SCALE = 24; // еденица масштаба


    ArrayList<Double> arrayX = new ArrayList<>(); // автоматически расширяемый массив
    ArrayList<Double> arrayY = new ArrayList<>();

    public Graphic(int start, int end, double a, double b, double c,  double d) {
        setBounds(230, 100, 500, 500);

        for(double x = start; x < end; x+=0.001) {
            arrayX.add(x * SCALE + X_CENTER);
            arrayY.add((double)function(x, a, b, c, d) * SCALE + Y_CENTER);
        }
        setVisible(true);
    }

    public double function(double x, double a, double b, double c, double d) {
        //return a * Math.cos(b * x) + c*Math.log(d*x*x+1);
        return a * Math.sin(b * x) + c * Math.cos(d * x);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1.5f));    //толщина
        g2.drawLine(X_CENTER, 0, X_CENTER, this.getHeight()); //ось х
        g2.drawLine(0, Y_CENTER, this.getWidth() , Y_CENTER); //ось у
        g.drawString("a*sin(b*x)+c*cos(d*x)", 10, 50);
        g.drawString("Y", 255, 50);
        g.drawString("X", 480, 250);
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(3.0f));
        GeneralPath genPath = new GeneralPath();
        genPath.moveTo(arrayX.get(0), arrayY.get(0));
        for(int i = 1; i < arrayX.size() ; i++) {   //отрисовка графика
            genPath.lineTo(arrayX.get(i), arrayY.get(i));
        }

        g2.draw(genPath);
        g2.dispose();
    }
}




public class Zadanie4{

    public static void main(String[] args) {
        new laba5.WindowGUI();
    }
}

