package sample;

import javax.swing.Icon;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import pelajaran1.Frame;
import pelajaran3.EfekGambar;

/**
 *
 * @author usu
 */
public class Button extends JButton {

    private boolean over;
    private boolean press;

    public Button() {
        super();
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOver(false);
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setOver(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setOver(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setPress(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setPress(false);
            }
        });
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
        repaint();
    }

    public boolean isPress() {
        return press;
    }

    public void setPress(boolean press) {
        this.press = press;
        repaint();
    }

    @Override
    public void setIcon(Icon defaultIcon) {
        if (defaultIcon instanceof ImageIcon) {
            ImageIcon icon = (ImageIcon) defaultIcon;
            icon = new ImageIcon(EfekGambar.getEfekKaca(icon.getImage()));
            super.setIcon(icon);
        } else {
            super.setIcon(defaultIcon);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Color light = new Color(1F, 1F, 1F, 0.5F);
        Color dark = new Color(1F, 1F, 1F, 0F);

        GradientPaint paint = null;

        if (over) {
            if (press) {
                paint = new GradientPaint(0, 0, light, 0, getHeight(), light);
            } else {
                paint = new GradientPaint(0, 0, dark, 0, getHeight(), light);
            }
        } else {
            paint = new GradientPaint(0, 0, light, 0, getHeight(), dark);
        }

        RoundRectangle2D.Double kotak = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), getHeight(), getHeight());

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(paint);
        g2.fill(kotak);

        super.paintComponent(g);
    }

    public static void main(String[] usu) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                Frame frame = new Frame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                JPanel panel = new JPanel(new FlowLayout());
                panel.setBackground(Color.RED);
                frame.add(panel);
                frame.setBounds(100, 100, 300, 200);
                panel.add(new Button());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
