/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Skripsi_Dicky;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Software
 */
public class Menu_Manager extends javax.swing.JFrame {

    /**
     * Creates new form Menu_user
     */
    public Menu_Manager() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        button23 = new sample.Button();
        button19 = new sample.Button();
        button20 = new sample.Button();
        button24 = new sample.Button();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Penggajian");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bpo.png"))); // NOI18N
        jPanel1.add(jLabel4);

        jPanel2.setBackground(new java.awt.Color(0, 51, 255));

        jPanel3.setBackground(new java.awt.Color(0, 51, 255));

        button23.setBackground(new java.awt.Color(153, 255, 255));
        button23.setForeground(new java.awt.Color(255, 255, 255));
        button23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1369491940_cash_register.png"))); // NOI18N
        button23.setText("Master Data Karyawan");
        button23.setFocusable(false);
        button23.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        button23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button23.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        button23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button23MouseExited(evt);
            }
        });
        button23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button23ActionPerformed(evt);
            }
        });
        jPanel3.add(button23);

        button19.setBackground(new java.awt.Color(153, 255, 255));
        button19.setForeground(new java.awt.Color(255, 255, 255));
        button19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/printer_on.png"))); // NOI18N
        button19.setText("Tambah Admin");
        button19.setFocusable(false);
        button19.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        button19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button19.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        button19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button19MouseExited(evt);
            }
        });
        button19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button19ActionPerformed(evt);
            }
        });
        jPanel3.add(button19);

        button20.setBackground(new java.awt.Color(153, 255, 255));
        button20.setForeground(new java.awt.Color(255, 255, 255));
        button20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/printer_on.png"))); // NOI18N
        button20.setText("Master Data Gaji Kryawan");
        button20.setFocusable(false);
        button20.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        button20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button20.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        button20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button20MouseExited(evt);
            }
        });
        button20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button20ActionPerformed(evt);
            }
        });
        jPanel3.add(button20);

        button24.setBackground(new java.awt.Color(51, 102, 255));
        button24.setForeground(new java.awt.Color(255, 255, 255));
        button24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exit.png"))); // NOI18N
        button24.setText("LOG OUT");
        button24.setFocusable(false);
        button24.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        button24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button24.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        button24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button24MouseExited(evt);
            }
        });
        button24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button24ActionPerformed(evt);
            }
        });
        jPanel3.add(button24);

        jPanel2.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button19MouseExited
             // TODO add your handling code here:
    }//GEN-LAST:event_button19MouseExited

    private void button19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button19MouseEntered
       // TODO add your handling code here:
    }//GEN-LAST:event_button19MouseEntered

    private void button19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button19ActionPerformed
      new Tambah_admin().show();this.dispose();      // TODO add your handling code here:
    }//GEN-LAST:event_button19ActionPerformed

    private void button23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button23MouseExited
                // TODO add your handling code here:
    }//GEN-LAST:event_button23MouseExited

    private void button23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button23MouseEntered
       // TODO add your handling code here:
    }//GEN-LAST:event_button23MouseEntered

    private void button23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button23ActionPerformed
    new master_data_peg1().show();        // TODO add your handling code here:
    }//GEN-LAST:event_button23ActionPerformed

    private void button24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button24MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_button24MouseExited

    private void button24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button24MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_button24MouseEntered

    private void button24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button24ActionPerformed
         JOptionPane.showMessageDialog(null,"Anda Akan keluar dari program ini","INFORMASI",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Icons/gnome_session_logout.png"));
          try {
            new login().show();
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_button24ActionPerformed

    private void button20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button20MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_button20MouseEntered

    private void button20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button20MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_button20MouseExited

    private void button20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button20ActionPerformed
 new Cetak_Slip1().show();         // TODO add your handling code here:
    }//GEN-LAST:event_button20ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Manager().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sample.Button button19;
    private sample.Button button20;
    private sample.Button button23;
    private sample.Button button24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
