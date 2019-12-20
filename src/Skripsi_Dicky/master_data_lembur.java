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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class master_data_lembur extends javax.swing.JFrame {

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
    private String[] label={"NO Surat","NIP","NAMA","Tanggal","Jumlah Lembur","Rentang Waktu","KETERANGAN"};
    
    public master_data_lembur() {
        initComponents();      
        bacatabel();
        autonumber();  
        tampilNIP ();
    }

 void autonumber(){
        try{
        s  = conn.createStatement();
         String sql = "select max(No) from lembur";
        ResultSet rs = s.executeQuery(sql);
         while(rs.next()){
             int a = rs.getInt(1);
            jTextField1.setText("00"+Integer.toString(a+1));
       
        }}
        catch (Exception ex){
        
        }
        }
     
      private  void bacatabel(){
       try {
           s=conn.createStatement();
           String sql="select * from lembur";
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
                data_golongan[x][0]=r.getString("No");
                data_golongan[x][1]=r.getString("nip");
                data_golongan[x][2]=r.getString("nama");
                data_golongan[x][3]=r.getString("tanggal");
                data_golongan[x][4]=r.getString("jumlah");
                data_golongan[x][5]=r.getString("rentang");
                data_golongan[x][6]=r.getString("Ket");
               x++;
           }
           jTable1.setModel(new DefaultTableModel(data_golongan,label));
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,e);
       }
   }
      
      private void tampilnama (){
         
          try {
             String sql = "select nama from data_pegawai where nip='"+jTextField2.getSelectedItem()+"'";
            Statement stat = conn.createStatement();
            ResultSet res=stat.executeQuery(sql);
            while (res.next()) {
                jTextField3.setText(res.getString("nama"));
            }

        } catch (Exception e) {
        }
     }
      private void tampilNIP (){
         jTextField2.addItem("--pilih NIP--");
          try {
             String sql = "select nip from data_pegawai";
            Statement stat = conn.createStatement();
            ResultSet res=stat.executeQuery(sql);
            while (res.next()) {
                jTextField2.addItem(res.getString(1));
            }

        } catch (Exception e) {
        }
     }
           private void simpan(){
   String absen_tanggal1 = "";
   String absen_tanggal2 = "";
   if(jTextField1.getText().equals("")||
        jTextField2.getSelectedIndex()==0||
        jTextField3.getText().equals("")||
         jTextArea1.getText().equals("")||
       txtAbsen_tanggal.getDate()==null||
      jTextField4.getText().equals("")||
      jTextField5.getText().equals("")){
         JOptionPane.showMessageDialog(null,"Harap Mengisi Semua Data");
   }else{
        
   
   
        if(txtAbsen_tanggal.getDate() != null){
        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        absen_tanggal1 = Format.format(txtAbsen_tanggal.getDate());
        }
       
       try {
           String sql="insert into lembur values('"+jTextField1.getText()+"','"+jTextField2.getSelectedItem()+"','"+jTextField3.getText()+"','"+absen_tanggal1+"','"+jTextField4.getText()+"','"+jTextField5.getText()+"','"+jTextArea1.getText()+"')";
           s.executeUpdate(sql);
           s.close();
           
           JOptionPane.showMessageDialog(null,"Data telah disimpan");
            bersih();
           bacatabel();
           autonumber();
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,e);
       }
   }
           }
          private void rubah(){    
              String absen_tanggal1 = "";
   String absen_tanggal2 = "";
        if(txtAbsen_tanggal.getDate() != null){
        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        absen_tanggal1 = Format.format(txtAbsen_tanggal.getDate());
        }
        
       try {
           String sql="update lembur set nip='"+jTextField2.getSelectedItem()+"',nama='"+jTextField3.getText()+"',tanggal='"+absen_tanggal1+"',jumlah='"+jTextField4.getText()+"',rentang='"+jTextField5.getText()+"',Ket='"+jTextArea1.getText()+"' where No='"+jTextField1.getText()+"'";
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
           String sql="delete from lembur where No='"+jTextField1.getText()+"'";
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
        jTextField2.setSelectedIndex(0);
        jTextField3.setText("");
         jTextArea1.setText("");
       txtAbsen_tanggal.setDate(null);
      jTextField4.setText("");
      jTextField5.setText("");
        jTextField1.requestFocus();
        buttonGroup1.clearSelection();
       }
       
       private void settabel(){
      
       int i = jTable1.getSelectedRow();
        if(i== -1){
            //tidak melakukan apa-apa
            return;
        }
       jTextField1.setText((String)jTable1.getValueAt(i,0));
       jTextField2.setSelectedItem((String)jTable1.getValueAt(i,1));
       jTextField3.setText((String)jTable1.getValueAt(i,2));
        jTextField4.setText((String)jTable1.getValueAt(i,4));
         jTextField5.setText((String)jTable1.getValueAt(i,5));
        jTextArea1.setText((String)jTable1.getValueAt(i,6));
        
        
       
       SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Date dateValue = null;
        Date dateValue2 = null;
        try {
            dateValue = date.parse((String) jTable1.getValueAt(i, 3));
            txtAbsen_tanggal.setDate(dateValue);
          
           
        } catch (ParseException ex) {
            Logger.getLogger(master_data_lembur.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelEfect = new pelajaran3.PanelEfect();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtAbsen_tanggal = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField2 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("No. Surat Lembur");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("N.I.P");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nama Pegawai");

        jTextField3.setEnabled(false);

        jTextField1.setEnabled(false);

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
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MASTER DATA LEMBUR PEGAWAI");

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

        jButton7.setText("Cetak Data");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tanggal");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Keterangan");

        txtAbsen_tanggal.setBackground(new java.awt.Color(249, 249, 249));
        txtAbsen_tanggal.setToolTipText("");
        txtAbsen_tanggal.setDateFormatString("yyyy-MM-dd");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Jumlah Jam Lembur");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Rentang Waktu");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEfectLayout = new javax.swing.GroupLayout(panelEfect);
        panelEfect.setLayout(panelEfectLayout);
        panelEfectLayout.setHorizontalGroup(
            panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEfectLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEfectLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelEfectLayout.createSequentialGroup()
                                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(jTextField2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEfectLayout.createSequentialGroup()
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEfectLayout.createSequentialGroup()
                            .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addGroup(panelEfectLayout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(4, 4, 4)))
                            .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAbsen_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelEfectLayout.createSequentialGroup()
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jTextField5))))
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEfectLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(78, 78, 78))
        );
        panelEfectLayout.setVerticalGroup(
            panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEfectLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtAbsen_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton9)
                            .addComponent(jButton6)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        getContentPane().add(panelEfect, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -20, 800, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
new Menu_Utama().show();      this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

       
        
        simpan();        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
if(jTextField1.getText().equals("")||
        jTextField2.getSelectedIndex()==0||
        jTextField3.getText().equals("")||
         jTextArea1.getText().equals("")||
       txtAbsen_tanggal.getDate()==null||
      jTextField4.getText().equals("")||
      jTextField5.getText().equals("")){
         JOptionPane.showMessageDialog(null,"Harap Pilih Data");
   }else{    rubah(); }       // TODO add your handling code ahere:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
if(jTextField1.getText().equals("")||
        jTextField2.getSelectedIndex()==0||
        jTextField3.getText().equals("")||
         jTextArea1.getText().equals("")||
       txtAbsen_tanggal.getDate()==null||
      jTextField4.getText().equals("")||
      jTextField5.getText().equals("")){
         JOptionPane.showMessageDialog(null,"Harap Pilih Data");
   }else{    hapus();}        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    settabel();        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    try { 
         
            File file = new File("src/Laporan/lap_lembur.jrxml");
            jasperDesign = JRXmlLoader.load(file);
            parham.clear();
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport,parham,conn);
            JasperViewer.viewReport(jasperPrint, false);
            } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data tidak dapat dicetak!"+ "\n" + e.getMessage(), "Cetak Data", JOptionPane.ERROR_MESSAGE);
}        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        tampilnama();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

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
            java.util.logging.Logger.getLogger(master_data_lembur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(master_data_lembur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(master_data_lembur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(master_data_lembur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new master_data_lembur().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private pelajaran3.PanelEfect panelEfect;
    private com.toedter.calendar.JDateChooser txtAbsen_tanggal;
    // End of variables declaration//GEN-END:variables
}
