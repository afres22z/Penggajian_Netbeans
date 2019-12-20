package sample;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import pelajaran3.EfekGambar;

/**
 *
 * @author usu
 */
public class Label extends JLabel {

    public Label() {
        super();
    }

    @Override
    public void setIcon(Icon icon) {
        if (icon instanceof ImageIcon) {
            ImageIcon con = (ImageIcon) icon;
            con = new ImageIcon(EfekGambar.getEfekKaca(con.getImage()));
            super.setIcon(con);
        } else {
            super.setIcon(icon);
        }
    }
}
