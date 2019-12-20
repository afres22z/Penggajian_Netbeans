/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Skripsi_Dicky;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ubah_data_karyawan extends javax.swing.JFrame {
    Connection c;
    ResultSet r;
    Statement s;    
    String tgl = "";
    
    public ubah_data_karyawan() {
        initComponents();
        bukakoneksi();
        tampil_no_urut();
        tampil_pangkat();
    
        tampil_jab_fungsional ();
        tampil_status ();
        tampil_pendidikan ();
        
    }
    
    
    
       private void bukakoneksi(){
    try {
        Class.forName("com.mysql.jdbc.Driver");
        c= DriverManager.getConnection("jdbc:mysql://localhost:3306/gaji_alihdaya","root","");
        System.out.println("koneksi sukses");
    } catch (ClassNotFoundException | SQLException e) {
        System.out.println(e);
    }
   }
    
          private void tampil_no_urut (){
         combo_cari.addItem("-- pilih / ketik disini --");
          try {
            bukakoneksi();
            String sql = "select nip from data_pegawai";
            Statement stat = c.createStatement();
            ResultSet res=stat.executeQuery(sql);
            while (res.next()) {
                combo_cari.addItem(res.getString(1));
            }

        } catch (Exception e) {
        }
     }
      
            private void tampil_pangkat (){
         jComboBox1.addItem("-- pilih pangkat/Gol. --");
          try {
            bukakoneksi();
            String sql = "select golongan from pangkat_gol";
            Statement stat = c.createStatement();
            ResultSet res=stat.executeQuery(sql);
            while (res.next()) {
                jComboBox1.addItem(res.getString(1));
            }

        } catch (Exception e) {
        }
     }
      
    
    
     
    
     private void tampil_jab_fungsional (){
         jComboBox3.addItem("--pilih jabatan fungsional--");
          try {
            bukakoneksi();
            String sql = "select nama_jabatan from jab_fungsional";
            Statement stat = c.createStatement();
            ResultSet res=stat.executeQuery(sql);
            while (res.next()) {
                jComboBox3.addItem(res.getString(1));
            }

        } catch (Exception e) {
        }
     }
     
      private void tampil_pendidikan (){
         jComboBox4.addItem("--pilih pendidikan terakhir--");
          try {
            bukakoneksi();
            String sql = "select jenjang_pend from pendidikan";
            Statement stat = c.createStatement();
            ResultSet res=stat.executeQuery(sql);
            while (res.next()) {
                jComboBox4.addItem(res.getString(1));
            }

        } catch (Exception e) {
        }
     }
      
     private void tampil_status (){
         jComboBox5.addItem("--pilih status perkawinan--");
          try {
            bukakoneksi();
            String sql = "select status from status_kawin";
            Statement stat = c.createStatement();
            ResultSet res=stat.executeQuery(sql);
            while (res.next()) {
                jComboBox5.addItem(res.getString(1));
            }

        } catch (Exception e) {
        }
     }
     
         
          
          
     private void rubah(){ 
         
         
         
         
         if(r_tahun.getDate() != null){
        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        tgl = Format.format(r_tahun.getDate());
        }
       try {
           String sql="update data_pegawai set nip='"+r_nip.getText()+"',nama='"+r_peg.getText()+"',tempat_lahir='"+r_tempat.getText()+"',tgl_lahir='"+tgl+"',alamat='"+r_alamat.getText()+"',golongan='"+jComboBox1.getSelectedItem()+"',jab_fungsional='"+jComboBox3.getSelectedItem()+"',pend_akhir='"+jComboBox4.getSelectedItem()+"',status_kawin='"+jComboBox5.getSelectedItem()+"' where nip='"+r_nip.getText()+"'";
           s.executeUpdate(sql);
           s.close();
           JOptionPane.showMessageDialog(null,"Data telah dirubah");
           bersih_layar();
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Pastikan Koneksi Aktif dan Data terisi semua");
       }
   }   
     
     
    public void aktif() {
        //jTextField1.setEnabled(true);
        r_nip.setEnabled(true);
        r_peg.setEnabled(true);
        r_tempat.setEnabled(true);
        r_tahun.setEnabled(true);
        r_alamat.setEnabled(true);
        jComboBox1.setEnabled(true);
        jComboBox3.setEnabled(true);
        jComboBox4.setEnabled(true);
        jComboBox5.setEnabled(true);
        r_batal.setEnabled(true);
        r_simpan.setEnabled(true);
        jButton1.setEnabled(true);   
        r_tahun.setEnabled(true);
   }
    
          
    public void nonaktif() {
        //jTextField1.setEnabled(false);
        r_nip.setEnabled(false);
        r_peg.setEnabled(false);
        r_tempat.setEnabled(false);
        r_tahun.setEnabled(false);
        r_alamat.setEnabled(false);
        
        jComboBox1.setEnabled(false);
        jComboBox3.setEnabled(false);
        jComboBox4.setEnabled(false);
        jComboBox5.setEnabled(false);
        r_batal.setEnabled(false);
        r_simpan.setEnabled(false);
        jButton1.setEnabled(false);   
        r_tahun.setEnabled(false);
        
        
    }
    
       private void hapus() {
       try {
           String sql="delete from data_pegawai where nip='"+r_nip.getText()+"'";
           s.executeUpdate(sql);
           s.close();
           JOptionPane.showMessageDialog(null,"Data telah terhapus");
           bersih_layar();
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,e);
       }
   }   
         
    
    
    public void bersih_layar() {
    combo_cari.setSelectedIndex(0);
    
    r_nip.setText("");
    r_peg.setText("");
    r_tempat.setText("");
    r_tahun.setDate(null);
    r_alamat.setText("");
    jComboBox1.setSelectedIndex(0);
    jComboBox3.setSelectedIndex(0);
    jComboBox4.setSelectedIndex(0);
    jComboBox5.setSelectedIndex(0);
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        r_simpan = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        panelEfect = new pelajaran3.PanelEfect();
        jLabel26 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        r_tempat = new javax.swing.JTextField();
        r_nip = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        r_peg = new javax.swing.JTextField();
        r_alamat = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        r_tahun = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        combo_cari = new javax.swing.JComboBox();
        jButton6 = new javax.swing.JButton();
        r_batal = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), null)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("Keluar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, 90, -1));

        jButton4.setText("Lihat Master Data");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 170, -1));

        r_simpan.setText("Simpan");
        r_simpan.setEnabled(false);
        r_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_simpanActionPerformed(evt);
            }
        });
        jPanel1.add(r_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 120, -1));

        jButton1.setText("Hapus");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, 120, -1));

        panelEfect.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), new java.awt.Color(255, 255, 0), new java.awt.Color(51, 255, 51), new java.awt.Color(255, 153, 102)));

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel26.setText("UBAH DATA KARYAWAN");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setText("Status Perkawinan");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setText("Pendidikan Terakhir");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setText("Jabatan Fungsional");

        jComboBox5.setEnabled(false);

        jComboBox4.setEnabled(false);

        jComboBox3.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setText("Pangkat/ Golongan");

        r_tempat.setEnabled(false);

        r_nip.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel11.setText("Alamat Lengkap");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Nama Pegawai");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("N  I  P");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setText("Tempat, Tanggal Lahir");

        r_peg.setEnabled(false);

        r_alamat.setEnabled(false);

        jComboBox1.setEnabled(false);

        r_tahun.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setText("Cari NIP KARYAWANdi bawah yang akan diubah.....");

        combo_cari.setEditable(true);
        combo_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_cariActionPerformed(evt);
            }
        });

        jButton6.setText("Aktifkan Mode Edit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        r_batal.setText("Batal");
        r_batal.setEnabled(false);
        r_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_batalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEfectLayout = new javax.swing.GroupLayout(panelEfect);
        panelEfect.setLayout(panelEfectLayout);
        panelEfectLayout.setHorizontalGroup(
            panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEfectLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelEfectLayout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(r_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(combo_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEfectLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelEfectLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(45, 45, 45)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelEfectLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(47, 47, 47)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelEfectLayout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(52, 52, 52)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(129, 129, 129)
                        .addComponent(r_nip, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(69, 69, 69)
                        .addComponent(r_peg, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(31, 31, 31)
                        .addComponent(r_tempat, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(r_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(62, 62, 62)
                        .addComponent(r_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEfectLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(44, 44, 44)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(111, 111, 111))
        );
        panelEfectLayout.setVerticalGroup(
            panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEfectLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_nip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(r_peg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_tempat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelEfectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        jPanel1.add(panelEfect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        hapus();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combo_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_cariActionPerformed
         
        
       String tgl1 ;
        
         try {
            s=c.createStatement();
            String sql="select * from data_pegawai where nip='"+combo_cari.getSelectedItem()+"'";
            r=s.executeQuery(sql);
            while(r.next()){
                
                 SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                Date dateValue = null;
                dateValue = date.parse((String) r.getString("tgl_lahir"));
                
              
              
                r_nip.setText(r.getString("nip"));
                r_peg.setText(r.getString("nama"));
                r_tempat.setText(r.getString("tempat_lahir"));
                 r_tahun.setDate(dateValue);
                r_alamat.setText(r.getString("alamat"));
                jComboBox1.setSelectedItem(r.getString("golongan"));
               
                jComboBox3.setSelectedItem(r.getString("jab_fungsional"));
                jComboBox4.setSelectedItem(r.getString("pend_akhir"));
                jComboBox5.setSelectedItem(r.getString("status_kawin"));

            }

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);

        } catch (ParseException ex) {
            Logger.getLogger(ubah_data_karyawan.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_combo_cariActionPerformed

    private void r_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_batalActionPerformed

        nonaktif();
        jButton6.setEnabled(true);// TODO add your handling code here:
    }//GEN-LAST:event_r_batalActionPerformed

    private void r_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_simpanActionPerformed

        rubah();
       
    }//GEN-LAST:event_r_simpanActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new master_data_peg().show();
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
new Menu_Utama().show();          this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        aktif();
        jButton6.setEnabled(false);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(ubah_data_karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ubah_data_karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ubah_data_karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ubah_data_karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ubah_data_karyawan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combo_cari;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private pelajaran3.PanelEfect panelEfect;
    private javax.swing.JTextField r_alamat;
    private javax.swing.JButton r_batal;
    private javax.swing.JTextField r_nip;
    private javax.swing.JTextField r_peg;
    private javax.swing.JButton r_simpan;
    private com.toedter.calendar.JDateChooser r_tahun;
    private javax.swing.JTextField r_tempat;
    // End of variables declaration//GEN-END:variables
}
