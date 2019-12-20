
package Skripsi_Dicky;

import java.sql.SQLException;
import javax.swing.UIManager;

public class Tugas_besar_LAb {
    public static void main(String[] args) throws SQLException {
     
     try {
UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");         
new login().show();
}
catch (Exception ax) {
}
    }
}
