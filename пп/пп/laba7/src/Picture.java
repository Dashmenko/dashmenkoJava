import java.awt.*;

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
