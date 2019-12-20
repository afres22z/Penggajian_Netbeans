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
public class mater_data_tunjangan extends javax.swing.JFrame {
JasperReport jasperReport; 
JasperDesign jasperDesign;
JasperPrint jasperPrint;

Map <String,Object> parham = new HashMap<String,Object>();
Connection conn = new koneksidb.koneksi().getConnection();
   /**
     * Creates new form mater_data_jab
     */
    
   
    ResultSet r;
    Statement s;
    private Object [][] datajab_fungsional=null;
    private String[] label={"Kode Jabatan","Nama Jabatan","Tunjangan (Rp.)","Tunjangan Kehadiran/hr", "Tunangan Lemburan/jam", "Jumlah Iuran"};
          
    public mater_data_tunjangan() {
        initComponents();
         
         bacatabel();
         autonumber();
      
    }
    
    
     void autonumber(){
        try{
       s  = conn.createStatement();
        String sql = "select max(kd_jabatan) from jab_fungsional";
        r = s.executeQuery(sql);
         while(r.next()){
             int a = r.getInt(1);
            jTextField1.setText("00"+Integer.toString(a+1));
         
        }}
        catch (Exception ex){
        
        }
        } 
     
     
      private  void bacatabel(){
       try {
           s=conn.createStatement();
           String sql="select * from jab_fungsional";
           r=s.executeQuery(sql);
           ResultSetMetaData m= r.getMetaData();
           int kolom=m.getColumnCount();
           int baris=0;
           while(r.next()){
               baris=r.getRow();
           }
           datajab_fungsional=new Object[baris][kolom];
           int x=0;
           r.beforeFirst();
           while(r.next()){
               datajab_fungsional[x][0]=r.getString("kd_jabatan");
               datajab_fungsional[x][1]=r.getString("nama_jabatan");
               datajab_fungsional[x][2]=r.getString("tunj_jabatan");
                datajab_fungsional[x][3]=r.getString("hadir");
               datajab_fungsional[x][4]=r.getString("lembur");
               datajab_fungsional[x][5]=r.getString("iuran");
               x++;
           }
           jTable1.setModel(new DefaultTableModel(datajab_fungsional,label));
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,e);
       }
   }

    
    
       private void simpan(){
        if(jTextField1.getText().equals("")||
           jTextField2.getText().equals("")||
           jTextField3.getText().equals("")||
           jTextField4.getText().equals("")||
           jTextField5.getText().equals("")||
           jTextField6.getText().equals(""))
         
      {
         JOptionPane.showMessageDialog(null,"Harap Mengisi Semua Data");
   }else{
       try {
           String sql="insert into jab_fungsional values('"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField3.getText()+"','"+jTextField4.getText()+"','"+jTextField5.getText()+"','"+jTextField6.getText()+"')";
           s.executeUpdate(sql);
           s.close();
           
           JOptionPane.showMessageDialog(null,"Data telah disimpan");
            bersih();
           bacatabel();
           autonumber();
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,e);
       }
   }}
       
          private void rubah(){
        //  JOptionPane.showConfirmDialog(null,"Rubah Data?");
       try {
           String sql="update jab_fungsional set kd_jabatan='"+jTextField1.getText()+"',nama_jabatan='"+jTextField2.getText()+"',tunj_jabatan='"+jTextField3.getText()+"',hadir='"+jTextField4.getText()+"',lembur='"+jTextField5.getText()+"',iuran='"+jTextField6.getText()+"'where kd_jabatan='"+jTextField1.getText()+"'";
           s.executeUpdate(sql);
           s.close();
           JOptionPane.showMessageDialog(null,"Data telah dirubah");
            bersih();
           bacatabel();
                      autonumber();
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,e);
       }
   }   
       
                 private void hapus() {
         // JOptionPane.showConfirmDialog(null,"Hapus Data ?");
       try {
           String sql="delete from jab_fungsional where kd_jabatan='"+jTextField1.getText()+"'";
           s.executeUpdate(sql);
           s.close();
           JOptionPane.showMessageDialog(null,"Data telah terhapus");
            bersih();
           bacatabel();
           autonumber();
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,e);
       }
   }   
       
       private void bersih() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
         jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField1.requestFocus();
       }
       
       private void settabel(){
       int kolom=jTable1.getSelectedRow();
       jTextField1.setText((String)jTable1.getValueAt(kolom,0));
       jTextField2.setText((String)jTable1.getValueAt(kolom,1));
       jTextField3.setText((String)jTable1.getValueAt(kolom,2));
       jTextField4.setText((String)jTable1.getValueAt(kolom,3));
       jTextField5.setText((String)jTable1.getValueAt(kolom,4));
       jTextField6.setText((String)jTable1.getValueAt(kolom,5));
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
        jButton8 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jButton8.setText("Keluar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Bauhaus Md BT", 1, 24)); // NOI18N
        jLabel5.setText("MASTER DATA TUNJANGAN JABATAN");

        jLabel7.setText("Kode Jabatan");

        jLabel8.setText("Nama Jabatan");

        jLabel6.setText("Tunjangan Jabatan");

        jButton5.setText("TAMBAH");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton9.setText("UBAH");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton6.setText("HAPUS");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel9.setText(" Tunjangan Hadir");

        jLabel10.setText("Jumlah lembur");

        jLabel11.setText("Jumlah Iuran");

        javax.swing.GroupLayout panelEfectLayout = new javax.swing.GroupLayout(panelEfect);
        panelEfect.setLayout(panelEfectLayout);
        panelEfectLayout.setHorizontalGroup(
            panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEfectLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
            .addGroup(panelEfectLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(panelEfectLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel5)
                .addContainerGap(152, Short.MAX_VALUE))
            .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEfectLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39)))
        );
        panelEfectLayout.setVerticalGroup(
            panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEfectLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(33, 33, 33))
            .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEfectLayout.createSequentialGroup()
                    .addContainerGap(310, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(126, Short.MAX_VALUE)))
        );

        getContentPane().add(panelEfect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    simpan();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    settabel();        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
if(jTextField1.getText().equals("")||
           jTextField2.getText().equals("")||
           jTextField3.getText().equals("")||
           jTextField4.getText().equals("")||
           jTextField5.getText().equals("")||
           jTextField6.getText().equals(""))
         
      {
         JOptionPane.showMessageDialog(null,"Harap Pilih Data");
   }else{    rubah();    }    // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
if(jTextField1.getText().equals("")||
           jTextField2.getText().equals("")||
           jTextField3.getText().equals("")||
           jTextField4.getText().equals("")||
           jTextField5.getText().equals("")||
           jTextField6.getText().equals(""))
         
      {
         JOptionPane.showMessageDialog(null,"Harap Mengisi Semua Data");
   }else{    hapus() ;}       // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
new Menu_Utama().show();      this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(mater_data_tunjangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mater_data_tunjangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mater_data_tunjangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mater_data_tunjangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mater_data_tunjangan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private pelajaran3.PanelEfect panelEfect;
    // End of variables declaration//GEN-END:variables
}
