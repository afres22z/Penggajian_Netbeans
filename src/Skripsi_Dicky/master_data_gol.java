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
public class master_data_gol extends javax.swing.JFrame {

    /**
     * Creates new form master_data_gol
     */
    
   JasperReport jasperReport; 
JasperDesign jasperDesign;
JasperPrint jasperPrint;

Map <String,Object> parham = new HashMap<String,Object>();
Connection conn = new koneksidb.koneksi().getConnection();
    ResultSet r;
    Statement s;
    private Object [][] data_golongan=null;
    private String[] label={"Kode Golongan","Pangkat","Golongan/ Ruang","Gaji Pokok (Rp)"};
    
    public master_data_gol() {
        initComponents();      
        bacatabel();
        autonumber();   
    }

  void autonumber(){
        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gaji_alihdaya","root","");
        Statement state = con.createStatement();
        String sql = "select max(kd_pangkat) from pangkat_gol";
        ResultSet rs = state.executeQuery(sql);
         while(rs.next()){
             int a = rs.getInt(1);
            jTextField1.setText("00"+Integer.toString(a+1));
        rs.close();
        con.close();
        }}
        catch (Exception ex){
        
        }
        }
     
      private  void bacatabel(){
       try {
           s=conn.createStatement();
           String sql="select *from pangkat_gol";
           r=s.executeQuery(sql);
           ResultSetMetaData m= r.getMetaData();
           int kolom=m.getColumnCount();
           int baris=0;
           while(r.next()){
               baris=r.getRow();
           }
           data_golongan=new Object[baris][kolom];
           int x=0;
           r.beforeFirst();
           while(r.next()){
                data_golongan[x][0]=r.getString("kd_pangkat");
                data_golongan[x][1]=r.getString("nama_pangkat");
                data_golongan[x][2]=r.getString("golongan");
                data_golongan[x][3]=r.getString("jml_gapok");
               
          
               x++;
           }
           jTable1.setModel(new DefaultTableModel(data_golongan,label));
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,e);
       }
   }
      
      
      
           private void simpan(){
            if(jTextField1.getText().equals("")||
           jTextField2.getText().equals("")||
           jTextField3.getText().equals("")||
           jTextField4.getText().equals(""))
           
         
      {
         JOptionPane.showMessageDialog(null,"Harap Mengisi Semua Data");
   }else{
       try {
           String sql="insert into pangkat_gol values('"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField3.getText()+"','"+jTextField4.getText()+"')";
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
       try {
           String sql="update pangkat_gol set kd_pangkat='"+jTextField1.getText()+"',nama_pangkat='"+jTextField2.getText()+"',golongan='"+jTextField3.getText()+"',jml_gapok='"+jTextField4.getText()+"' where kd_pangkat='"+jTextField1.getText()+"'";
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
       try {
           String sql="delete from pangkat_gol where kd_pangkat='"+jTextField1.getText()+"'";
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
        jTextField1.requestFocus();
       }
       
       private void settabel(){
       int kolom=jTable1.getSelectedRow();
       jTextField1.setText((String)jTable1.getValueAt(kolom,0));
       jTextField2.setText((String)jTable1.getValueAt(kolom,1));
       jTextField3.setText((String)jTable1.getValueAt(kolom,2));
       jTextField4.setText((String)jTable1.getValueAt(kolom,3));
       
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kode  Golongan");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nama Pangkat");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Golongan");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jum. Gaji Pokok");

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

        jLabel5.setFont(new java.awt.Font("Bauhaus Md BT", 1, 36)); // NOI18N
        jLabel5.setText("MASTER DATA GOLONGAN");

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

        javax.swing.GroupLayout panelEfectLayout = new javax.swing.GroupLayout(panelEfect);
        panelEfect.setLayout(panelEfectLayout);
        panelEfectLayout.setHorizontalGroup(
            panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEfectLayout.createSequentialGroup()
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelEfectLayout.createSequentialGroup()
                            .addGap(567, 567, 567)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEfectLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel5)
                            .addGap(77, 77, 77))))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEfectLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEfectLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelEfectLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelEfectLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(133, 133, 133))
        );
        panelEfectLayout.setVerticalGroup(
            panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEfectLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addGap(56, 56, 56)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(7, 7, 7)
                        .addComponent(jButton9)
                        .addGap(7, 7, 7)
                        .addComponent(jButton6)))
                .addGap(7, 7, 7)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(panelEfect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
new Menu_Utama().show();      this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    simpan();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
 if(jTextField1.getText().equals("")||
           jTextField2.getText().equals("")||
           jTextField3.getText().equals("")||
           jTextField4.getText().equals(""))
           
         
      {
         JOptionPane.showMessageDialog(null,"Harap Pilih Data");
   }else{    rubah();   }     // TODO add your handling code ahere:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
 if(jTextField1.getText().equals("")||
           jTextField2.getText().equals("")||
           jTextField3.getText().equals("")||
           jTextField4.getText().equals(""))
           
         
      {
         JOptionPane.showMessageDialog(null,"Harap Pilih Data");
   }else{    hapus();  }      // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    settabel();        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(master_data_gol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(master_data_gol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(master_data_gol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(master_data_gol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new master_data_gol().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private pelajaran3.PanelEfect panelEfect;
    // End of variables declaration//GEN-END:variables
}
