/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Skripsi_Dicky;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Software
 */
public class Cetak_Laporan extends javax.swing.JFrame {
JasperReport jasperReport; 
JasperDesign jasperDesign;
JasperPrint jasperPrint;

Map <String,Object> parham = new HashMap<String,Object>();
Connection conn = new koneksidb.koneksi().getConnection();
    ResultSet r;
    Statement s;
    /**
     * Creates new form Cetak_Slip
     */
    public Cetak_Laporan() {
        initComponents();
    }
 private void cetak_laporan1 () {
        try { 
            String name = "";
            name = JOptionPane.showInputDialog("Please enter the password: ");
            if (name.equals("ALIHDAYA")){
         
            File file = new File("src/Laporan/lap_gaji.jrxml");
            jasperDesign = JRXmlLoader.load(file);
            parham.put("parap_bulan",combo_tahun.getSelectedItem());
             parham.put("pass", name);
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport,parham,conn);
            JasperViewer.viewReport(jasperPrint, false);
            }else{
                JOptionPane.showMessageDialog(null, "Password salah, Tidak Akan Dicetak");}
            
            
            } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data tidak dapat dicetak!"+ "\n" + e.getMessage(), "Cetak Data", JOptionPane.ERROR_MESSAGE);
}
    }
   
    
 private void cetak_laporan2 () {
        try {    
           
            String name = "";
            name = JOptionPane.showInputDialog("Please enter the password: ");
            if (name.equals("ALIHDAYA")){
            File file = new File("src/Laporan/lap_gaji3.jrxml");
            jasperDesign = JRXmlLoader.load(file);
            parham.put("pass", name);
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport,parham,conn);
            JasperViewer.viewReport(jasperPrint, false);
            }else{
                JOptionPane.showMessageDialog(null, "Password salah, Tidak Akan Dicetak");}
           
            } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data tidak dapat dicetak!"+ "\n" + e.getMessage(), "Cetak Data", JOptionPane.ERROR_MESSAGE);
}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEfect = new pelajaran3.PanelEfect();
        label1 = new sample.Label();
        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        combo_tahun = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelEfect.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sample/myofficelogo.png"))); // NOI18N
        label1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelEfect.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 148, -1));

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/print_empty.png"))); // NOI18N
        jButton1.setText("  CETAK KESELURUHAN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelEfect.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 320, 40));

        jToggleButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exit.png"))); // NOI18N
        jToggleButton1.setText("KELUAR");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        panelEfect.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 220, 160, -1));

        combo_tahun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_tahun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Januari", "Pebruari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "Nopember", "Desember" }));
        panelEfect.add(combo_tahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 160, 40));

        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/print_empty.png"))); // NOI18N
        jButton2.setText("  CETAK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelEfect.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 141, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pilih Bulan ( Periode )");
        panelEfect.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));
        panelEfect.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 320, -1));

        getContentPane().add(panelEfect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 290));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    cetak_laporan2();          // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        new Menu_Utama().show();   this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
cetak_laporan1();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Cetak_Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cetak_Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cetak_Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cetak_Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cetak_Laporan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combo_tahun;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private sample.Label label1;
    private pelajaran3.PanelEfect panelEfect;
    // End of variables declaration//GEN-END:variables
}
