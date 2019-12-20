/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Skripsi_Dicky;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
public class Cetak_Slip extends javax.swing.JFrame {
JasperReport jasperReport; 
JasperDesign jasperDesign;
JasperPrint jasperPrint;

Map <String,Object> parham = new HashMap<String,Object>();
Connection conn = new koneksidb.koneksi().getConnection();
    ResultSet r;
    Statement s;
    
    private Object [][] datapegawai=null;
    private String[] label={"tgl_bayar","Gaji /","No_Slip","NIP","Nama","Gaji Pokok","Gaji Kotor","Pinjaman","Iuran","PPh (10%)","Total Gaji Bersih"};

   
   public Cetak_Slip() {
        initComponents();
        bacatabelhitung();
   
    }

      private void settabel(){
       int kolom=jTable1.getSelectedRow();
       jTextField1.setText((String)jTable1.getValueAt(kolom,2));
           }  

       private void cetak_gaji () {
        try { 
            String name = "";
            name = JOptionPane.showInputDialog("Please enter the password: ");
            if (name.equals("ALIHDAYA")){
            File file = new File("src/Laporan/rep_gaji.jrxml");
            jasperDesign = JRXmlLoader.load(file);
            parham.put("param_slip", jTextField1.getText());
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
    
     private  void bacatabelhitung(){
       try {
           s=conn.createStatement();
           String sql="select * from hitung_gaji";
           r=s.executeQuery(sql);
           ResultSetMetaData m= r.getMetaData();
           int kolom=m.getColumnCount();
           int baris=0;
           while(r.next()){
               baris=r.getRow();
           }
           datapegawai=new Object[baris][kolom];
           int x=0;
           r.beforeFirst();
           while(r.next()){
               datapegawai[x][0]=r.getString("tgl_bayar");
               datapegawai[x][1]=r.getString("gaji_bln");
               datapegawai[x][2]=r.getString("nomor_slip");
               datapegawai[x][3]=r.getString("nip");
               datapegawai[x][4]=r.getString("nama_peg");
               datapegawai[x][5]=r.getString("gapok");
               datapegawai[x][6]=r.getString("total_ab");
               datapegawai[x][7]=r.getString("pinjaman");
               datapegawai[x][8]=r.getString("iuran");
               datapegawai[x][9]=r.getString("pph");
               datapegawai[x][10]=r.getString("gaji_bersih");
               x++;
           }
           jTable1.setModel(new DefaultTableModel(datapegawai,label));
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,e);
       }
   }
     private  void deskripsi(){
       try {
           s=conn.createStatement();
           String sql="SELECT *, `tgl_bayar`, `gaji_bln`, `nomor_slip`, `nip`, "
                   + "`nama_peg`, `jabatan`, `tot_masuk`, `tot_lembur`, `gol`, "
                   + " CAST(AES_DECRYPT(gapok, 'ALIHDAYA') AS CHAR(30)) gapok_decrypt"
                   + " , CAST(AES_DECRYPT(tunjab_fung, 'ALIHDAYA') AS CHAR(30)) "
                   + "tunjab_fung_decrypt , CAST(AES_DECRYPT(tunj_masuk, 'ALIHDAYA')"
                   + " AS CHAR(30)) tunj_masuk_decrypt , CAST(AES_DECRYPT(tunj_lembur, 'ALIHDAYA')"
                   + " AS CHAR(30)) tunj_lembur_decrypt , CAST(AES_DECRYPT(total_ab, 'ALIHDAYA')"
                   + " AS CHAR(30)) total_ab_decrypt ,CAST(AES_DECRYPT(pph, 'ALIHDAYA') "
                   + "AS CHAR(30)) pph_decrypt , CAST(AES_DECRYPT(iuran, 'ALIHDAYA') "
                   + "AS CHAR(30)) iuran_decrypt , CAST(AES_DECRYPT(pinjaman, 'ALIHDAYA')"
                   + " AS CHAR(30))pinjaman_decrypt , CAST(AES_DECRYPT(gaji_bersih, 'ALIHDAYA') "
                   + "AS CHAR(30)) gaji_bersih_decrypt FROM   hitung_gaji";
           r=s.executeQuery(sql);
           ResultSetMetaData m= r.getMetaData();
           int kolom=m.getColumnCount();
           int baris=0;
           while(r.next()){
               baris=r.getRow();
           }
           datapegawai=new Object[baris][kolom];
           int x=0;
           r.beforeFirst();
           while(r.next()){
               datapegawai[x][0]=r.getString("tgl_bayar");
               datapegawai[x][1]=r.getString("gaji_bln");
               datapegawai[x][2]=r.getString("nomor_slip");
               datapegawai[x][3]=r.getString("nip");
               datapegawai[x][4]=r.getString("nama_peg");
               datapegawai[x][5]=r.getString("gapok_decrypt");
               datapegawai[x][6]=r.getString("total_ab_decrypt");
               datapegawai[x][7]=r.getString("pinjaman_decrypt");
               datapegawai[x][8]=r.getString("iuran_decrypt");
               datapegawai[x][9]=r.getString("pph_decrypt");
               datapegawai[x][10]=r.getString("gaji_bersih_decrypt");
               x++;
           }
           jTable1.setModel(new DefaultTableModel(datapegawai,label));
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,e);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelEfect.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(0, 204, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        panelEfect.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 71, 770, 330));

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exit.png"))); // NOI18N
        jToggleButton1.setText("KELUAR");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        panelEfect.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 180, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/print_empty.png"))); // NOI18N
        jButton1.setText("  CETAK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelEfect.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, 170, 40));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        panelEfect.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 157, 40));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel2.setText("MASTER TABEL GAJI PEGAWAI");
        panelEfect.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 528, 37));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMOR SLIP :");
        panelEfect.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 150, 21));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/data64x64.png"))); // NOI18N
        jButton2.setText("DESKRIPSI");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelEfect.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 140, -1));

        getContentPane().add(panelEfect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    settabel();        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
 new Menu_Utama().show();   this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        cetak_gaji();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         String name = "";
           name = JOptionPane.showInputDialog("Please enter the password: ");                              
          
           
            if (name.equals("ALIHDAYA")){
                 jButton2.setEnabled(true);
                deskripsi();
            }else{
                JOptionPane.showMessageDialog(null, "Password salah, Data Deskripsi Tidak Akan Di Tampilkan");}
           
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
            java.util.logging.Logger.getLogger(Cetak_Slip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cetak_Slip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cetak_Slip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cetak_Slip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cetak_Slip().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private pelajaran3.PanelEfect panelEfect;
    // End of variables declaration//GEN-END:variables
}
