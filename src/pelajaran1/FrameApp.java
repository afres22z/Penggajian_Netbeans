package pelajaran1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingUtilities;

/**
 *
 * @author usu
 */
public class FrameApp extends Frame {

    public FrameApp() {
        super();
        setTitle("Animasi Frame");
        setSize(200, 200);
        setLocationRelativeTo(null);
        setAnimationShow(Animation.SHOW_FROM_TOP);
        setAnimationHide(Animation.HIDE_TO_BOTTOM);
        
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
    }

    public static void main(String[] usu) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new FrameApp().setVisible(true);
            }
        });
    }
}
