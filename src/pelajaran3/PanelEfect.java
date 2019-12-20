package pelajaran3;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import pelajaran1.Frame;
/**
 *
 * @author usu
 */
public class PanelEfect extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint paint = new GradientPaint(0, 0, Color.WHITE, 0, getHeight(), Color.BLUE);
       
        g2.setPaint(paint);
        g2.fillRect(0, 0, getWidth(), getHeight());

        int width = getWidth();
        int height = getHeight() * 5 / 100;

        Color light = new Color(1F, 1F, 1F, 0.5F);
        Color dark = new Color(1F, 1F, 1F, 0.0F);

        paint = new GradientPaint(0, 0, light, 0, height, dark);
        GeneralPath path = new GeneralPath();
        path.moveTo(0, 0);
        path.lineTo(0, height);
        path.curveTo(0, height, width / 2, height / 2, width, height);
        path.lineTo(width, 0);
        path.closePath();

        g2.setPaint(paint);
        g2.fill(path);

        paint = new GradientPaint(0, getHeight(), light, 0, getHeight() - height, dark);
        path = new GeneralPath();
        path.moveTo(0, getHeight());
        path.lineTo(0, getHeight() - height);
        path.curveTo(0, getHeight() - height, width / 2, getHeight() - height / 2, width, getHeight() - height);
        path.lineTo(width, getHeight());
        path.closePath();

        g2.setPaint(paint);
        g2.fill(path);
    }

    public static void main(String[] usu) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                Frame frame = new Frame();
                frame.setBounds(100, 100, 400, 400);
                frame.add(new PanelEfect());
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
