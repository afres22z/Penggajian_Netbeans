/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Skripsi_Dicky;
import java.io.File;
import java.text.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
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
public final class Hitung_Gaji extends javax.swing.JFrame {
JasperReport jasperReport; 
JasperDesign jasperDesign;
JasperPrint jasperPrint;

Map <String,Object> parham = new HashMap<String,Object>();
    private static void customFormat(String string, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 Connection conn = new koneksidb.koneksi().getConnection();
  ResultSet r;
    Statement s;    

    public Hitung_Gaji() {
        initComponents();
         this.setLocationRelativeTo(null);
         autonumber();
     
        tampil_nip();
        curentdate(); 
        
    }
    private void hitung(){  
    n1 = Integer.parseInt(jTextField7.getText());           
    n3 = Integer.parseInt(jTextField9.getText());     
    n4 = Integer.parseInt(jTextField16.getText());        
    n5 = Integer.parseInt(jTextField18.getText());     
    gaji_tot = n1+n2+n3+n4+n5;
    jTextField17.setText(String.valueOf(gaji_tot));
    
    pph = gaji_tot*0.025;
    jTextField15.setText(String.valueOf(pph));
    }
   public void curentdate(){  
        Calendar cal = new GregorianCalendar();  
        int month=cal.get(Calendar.MONTH);  
        int day=cal.get(Calendar.DAY_OF_MONTH);  
        int year=cal.get(Calendar.YEAR);  
        txt_tgl.setText(day+"/"+(month+1)+"/"+year);  
    }  
    
     
    
    void autonumber(){
        try{
       Statement state = conn.createStatement();
        String sql = "select max(nomor_slip) from hitung_gaji";
        ResultSet rs = state.executeQuery(sql);
         while(rs.next()){
             int a = rs.getInt(1);
            jTextField1.setText("00"+Integer.toString(a+1));
   
        }}
        catch (Exception ex){
        }
        }
       
       private void tampil_nip (){
         jComboBox1.addItem("-- pilih atau ketik disini --");
          try {
            String sql = "select nip from data_pegawai";
            Statement stat = conn.createStatement();
            ResultSet res=stat.executeQuery(sql);
            while (res.next()) {
                jComboBox1.addItem(res.getString(1));
            }

        } catch (Exception e) {
        }
     }
          
          public void hitung_gaji() {
        int iuran_wajib = Integer.valueOf(jTextField13.getText());
        int pinj = Integer.valueOf(jTextField14.getText());
        gaji_bersih = gaji_tot-(iuran_wajib+pinj+pph);        
        jT_Total.setText(String.valueOf(gaji_bersih));
          }
          
             
private void simpan(){
    
    if (jT_Total.getText().equals("")||jTextField17.getText().equals("")){
         JOptionPane.showMessageDialog(null,"Harap menghitung dan mengambil data terlebh dahulu");
    }else{
               try {
           s=conn.createStatement();
           String sql="insert into hitung_gaji values('"+txt_tgl.getText()+"',"
                   + "'"+combo_tahun.getSelectedItem()+"',"
                   + "'"+jTextField1.getText()+"',"
                   + "'"+jComboBox1.getSelectedItem()+"',"
                   + "'"+jTextField3.getText()+"',"
                   + "'"+jTextField11.getText()+"',"
                    + "'"+jTextField10.getText()+"',"
                   + "'"+jTextField19.getText()+"',"
                   + "'"+jTextField12.getText()+"',"
                   + "AES_ENCRYPT('"+jTextField7.getText()+"', 'ALIHDAYA'),"
                   + "AES_ENCRYPT('"+jTextField9.getText()+"', 'ALIHDAYA'),"
                   + "AES_ENCRYPT('"+jTextField16.getText()+"', 'ALIHDAYA'),"
                   + "AES_ENCRYPT('"+jTextField18.getText()+"', 'ALIHDAYA'),"
                   + "AES_ENCRYPT('"+jTextField17.getText()+"', 'ALIHDAYA'),"
                   + "AES_ENCRYPT('"+jTextField15.getText()+"', 'ALIHDAYA'),"
                   + "AES_ENCRYPT('"+jTextField14.getText()+"', 'ALIHDAYA'),"
                   + "AES_ENCRYPT('"+jTextField13.getText()+"', 'ALIHDAYA'),"
                  + "AES_ENCRYPT('"+jT_Total.getText()+"', 'ALIHDAYA')    )";
           s.executeUpdate(sql);
           s.close();
                     JOptionPane.showMessageDialog(null,"Data berhasil disimpan","SUKSES",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Icons/save.png"));
 button3.setEnabled(false);
    button4.setEnabled(true);
          } 
       catch (SQLException e) {
           JOptionPane.showMessageDialog(null,e);
       }
        
   }
}
private void bersih_teks() {
jComboBox1.setSelectedIndex(0);
jT_Total.setText("");
jTextField12.setText("");
jTextField3.setText("");


jTextField17.setText("0");
jTextField7.setText("0");
jTextField9.setText("0");
jTextField10.setText("");

jTextField19.setText("");
jTextField11.setText("");
jTextField16.setText("0");
jTextField18.setText("0");
jTextField13.setText("0");
jTextField14.setText("0");
jTextField15.setText("0");

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
        jLabel18 = new javax.swing.JLabel();
        button2 = new sample.Button();
        button3 = new sample.Button();
        button4 = new sample.Button();
        jLabel25 = new javax.swing.JLabel();
        txt_tgl = new javax.swing.JTextField();
        combo_tahun = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        button6 = new sample.Button();
        jT_Total = new sample.TextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelEfect1 = new pelajaran3.PanelEfect();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        panelEfect2 = new pelajaran3.PanelEfect();
        jLabel24 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panelEfect3 = new pelajaran3.PanelEfect();
        jLabel26 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        button1 = new sample.Button();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelEfect.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 51));
        jLabel18.setText("Total Gaji Bersih :");
        panelEfect.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 160, -1));

        button2.setText("HITUNG GAJI KESELURUHAN");
        button2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panelEfect.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, 370, 36));

        button3.setText("SIMPAN ");
        button3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        panelEfect.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 590, 150, 36));

        button4.setText("CETAK SLIP GAJI");
        button4.setEnabled(false);
        button4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        panelEfect.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 630, 150, 36));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("TANGGAL PEMBAYARAN  :");
        panelEfect.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, 20));
        panelEfect.add(txt_tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 170, -1));

        combo_tahun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "januari", "februari", "maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "Nopember", "Desember" }));
        combo_tahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tahunActionPerformed(evt);
            }
        });
        panelEfect.add(combo_tahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Untuk Gaji Bulan   :");
        panelEfect.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("TOTAL GAJI +TUNJANGAN");
        panelEfect.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        jTextField17.setEditable(false);
        jTextField17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(102, 102, 102));
        jTextField17.setText("0");
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });
        panelEfect.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 180, 30));

        button6.setText("BARU");
        button6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        panelEfect.add(button6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 590, 136, 36));

        jT_Total.setEditable(false);
        jT_Total.setBackground(new java.awt.Color(0, 102, 204));
        jT_Total.setForeground(new java.awt.Color(0, 255, 0));
        jT_Total.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        panelEfect.add(jT_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 540, 220, 40));

        jLabel6.setFont(new java.awt.Font("Vani", 1, 24)); // NOI18N
        jLabel6.setText("PENGGAJIAN KARYAWAN");
        panelEfect.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, 30));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);

        panelEfect1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nomor Slip");
        panelEfect1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 100, -1));

        jLabel2.setText("NIP");
        panelEfect1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 100, -1));

        jLabel4.setText("Nama Pegawai");
        panelEfect1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 126, -1));

        jLabel7.setText("Jabatan");
        panelEfect1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 126, -1));

        jLabel11.setText("Total Masuk Kerja");
        panelEfect1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 121, -1));

        jLabel12.setText("Total Lembur");
        panelEfect1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 121, -1));

        jTextField11.setEditable(false);
        jTextField11.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        panelEfect1.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 140, -1));

        jTextField10.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        panelEfect1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 70, -1));

        jTextField3.setEditable(false);
        jTextField3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        panelEfect1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 190, -1));

        jComboBox1.setEditable(true);
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        panelEfect1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 190, -1));

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        panelEfect1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 190, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setText("A. Informasi Karyawan");
        panelEfect1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTextField19.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });
        panelEfect1.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 70, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEfect1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEfect1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
        );

        panelEfect.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 770, 130));
        jPanel1.getAccessibleContext().setAccessibleParent(this);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        panelEfect.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);

        panelEfect2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel24.setText("B. Detail Gaji");
        panelEfect2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel5.setText("Golongan");
        panelEfect2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 134, -1));

        jTextField12.setEditable(false);
        jTextField12.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        panelEfect2.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 170, -1));

        jLabel8.setText("Gaji Pokok (Rp.)");
        panelEfect2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 121, -1));

        jTextField7.setEditable(false);
        jTextField7.setText("0");
        jTextField7.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        panelEfect2.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 170, -1));

        jLabel10.setText("Tunjangan Fungsional  (Rp)");
        panelEfect2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 170, -1));

        jTextField9.setEditable(false);
        jTextField9.setText("0");
        panelEfect2.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 170, -1));

        jLabel27.setText("Tunjangan Masuk kerjal  (Rp)");
        panelEfect2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 170, -1));

        jTextField16.setEditable(false);
        jTextField16.setText("0");
        panelEfect2.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 170, -1));

        jTextField18.setEditable(false);
        jTextField18.setText("0");
        panelEfect2.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 170, -1));

        jLabel28.setText("Lembur  (Rp)");
        panelEfect2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 140, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEfect2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEfect2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );

        panelEfect.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 380, 190));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);

        panelEfect3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel26.setText("C. Potongan");
        panelEfect3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel20.setText("Kas Bon/ Pinjaman");
        panelEfect3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 120, -1));

        jTextField13.setText("0");
        jTextField13.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField13FocusGained(evt);
            }
        });
        panelEfect3.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 190, -1));

        jLabel17.setText("Iuran Kas");
        panelEfect3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 130, -1));

        jTextField14.setEditable(false);
        jTextField14.setText("0");
        panelEfect3.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 190, -1));

        jLabel19.setText("PPh (0,83%)");
        panelEfect3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, -1));

        jTextField15.setEditable(false);
        jTextField15.setText("0");
        panelEfect3.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 190, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEfect3, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEfect3, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );

        panelEfect.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 380, 190));

        button1.setText("OK");
        button1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelEfect.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 90, 30));

        jButton3.setText("Keluar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelEfect.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 80, 40));

        getContentPane().add(panelEfect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public int gaji_tot=0;
    public double gaji_bersih=0;
    public double pph;
    public int n1,n2,n3,n4,n5;
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        
        
        try {
           s=conn.createStatement();
           String sql="select * from data_pegawai where nip='"+jComboBox1.getSelectedItem()+"'";
           r=s.executeQuery(sql);       
           while(r.next()){ 
              jTextField3.setText(r.getString("nama"));                                         
              jTextField11.setText(r.getString("jab_fungsional"));
           }
           
         
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,e);
       }           // TODO add your handling code here:
     
 
        jTextField10.requestFocus();       
     
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField13FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField13FocusGained
   
    }//GEN-LAST:event_jTextField13FocusGained

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

   
        int had=Integer.parseInt(jTextField10.getText());  
        int lem=Integer.parseInt(jTextField19.getText());  
        
        try {
          s=conn.createStatement();
          String sql2="select pangkat_gol.jml_gapok from pangkat_gol,data_pegawai where (pangkat_gol.golongan=data_pegawai.golongan) and data_pegawai.nip='"+jComboBox1.getSelectedItem()+"'";
          r=s.executeQuery(sql2);       
          while(r.next()){ 
               jTextField7.setText(r.getString("jml_gapok"));
           }
           String sql="select * from data_pegawai where nip='"+jComboBox1.getSelectedItem()+"'";
           r=s.executeQuery(sql);       
           while(r.next()){ 
              jTextField12.setText(r.getString("golongan"));                                         
              }
           
           String sql4="select jab_fungsional.tunj_jabatan from jab_fungsional,data_pegawai where (jab_fungsional.nama_jabatan=data_pegawai.jab_fungsional) and data_pegawai.nip='"+jComboBox1.getSelectedItem()+"'";
          r=s.executeQuery(sql4);       
          while(r.next()){ 
               
               
              
               jTextField9.setText(r.getString("tunj_jabatan"));
           }
          String sql5="select jab_fungsional.hadir from jab_fungsional,data_pegawai where (jab_fungsional.nama_jabatan=data_pegawai.jab_fungsional) and data_pegawai.nip='"+jComboBox1.getSelectedItem()+"'";
          r=s.executeQuery(sql5);       
          while(r.next()){ 
               
               
              
                 int a=Integer.parseInt(r.getString("hadir"));
                 int total1=a*had;
                  jTextField16.setText(String.valueOf(total1));
              
           }
           String sql6="select jab_fungsional.lembur from jab_fungsional,data_pegawai where (jab_fungsional.nama_jabatan=data_pegawai.jab_fungsional) and data_pegawai.nip='"+jComboBox1.getSelectedItem()+"'";
          r=s.executeQuery(sql6);       
          while(r.next()){ 
               
               
              
                 int a=Integer.parseInt(r.getString("lembur"));
                 int total2=a*lem;
                  jTextField18.setText(String.valueOf(total2));
              
           }
           String sql7="select jab_fungsional.iuran from jab_fungsional,data_pegawai where (jab_fungsional.nama_jabatan=data_pegawai.jab_fungsional) and data_pegawai.nip='"+jComboBox1.getSelectedItem()+"'";
          r=s.executeQuery(sql7);       
          while(r.next()){ 
               
               
              
                 int a=Integer.parseInt(r.getString("iuran"));
                
                  jTextField14.setText(String.valueOf(a));
              
           }
           
         
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,e);
       }           // TODO add your handling code here:
     
    hitung();
        jTextField13.requestFocus();  
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
      hitung_gaji();    // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
   
        simpan();        // TODO add your handling code here:
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
     String name = "";
            name = JOptionPane.showInputDialog("Please enter your name : ");
           
            
           
            String msg = name;
        
        try { 
           s=conn.createStatement();
          
           
          
            File file = new File("src/Laporan/rep_gaji.jrxml");
            jasperDesign = JRXmlLoader.load(file);
            parham.put("param_slip", jTextField1.getText());
             parham.put("pass", msg);
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport,parham,conn);
            JasperViewer.viewReport(jasperPrint, false);
            } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data tidak dapat dicetak!"+ "\n" + e.getMessage(), "Cetak Data", JOptionPane.ERROR_MESSAGE);

            } 
         
    button4.setEnabled(false);// TODO add your handling code here:
    }//GEN-LAST:event_button4ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        // TODO add your handling code here:
        autonumber();
         bersih_teks();
          button3.setEnabled(true);
    button4.setEnabled(false);
    }//GEN-LAST:event_button6ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void combo_tahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_tahunActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
         jTextField10.setText("");
        jTextField11.setText("");
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Menu_Utama().show();      this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Hitung_Gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hitung_Gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hitung_Gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hitung_Gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hitung_Gaji().setVisible(true);
                
            }
        });
            
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sample.Button button1;
    private sample.Button button2;
    private sample.Button button3;
    private sample.Button button4;
    private sample.Button button6;
    private javax.swing.JComboBox combo_tahun;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private sample.TextField jT_Total;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private pelajaran3.PanelEfect panelEfect;
    private pelajaran3.PanelEfect panelEfect1;
    private pelajaran3.PanelEfect panelEfect2;
    private pelajaran3.PanelEfect panelEfect3;
    private javax.swing.JTextField txt_tgl;
    // End of variables declaration//GEN-END:variables
}
/*SELECT *, `tgl_bayar`, `gaji_bln`, `nomor_slip`, `nip`, `nama_peg`, `jabatan`, `tot_masuk`, `tot_lembur`, `gol`,  CAST(AES_DECRYPT(gapok, 'ALIHDAYA') AS CHAR(30)) gapok_decrypt , CAST(AES_DECRYPT(tunjab_fung, 'ALIHDAYA') AS CHAR(30)) tunjab_fung_decrypt , CAST(AES_DECRYPT(tunj_masuk, 'ALIHDAYA') AS CHAR(30)) tunj_masuk_decrypt , CAST(AES_DECRYPT(tunj_lembur, 'ALIHDAYA') AS CHAR(30)) tunj_lembur_decrypt , CAST(AES_DECRYPT(total_ab, 'ALIHDAYA') AS CHAR(30)) total_ab_decrypt ,CAST(AES_DECRYPT(pph, 'ALIHDAYA') AS CHAR(30)) pph_decrypt , CAST(AES_DECRYPT(iuran, 'ALIHDAYA') AS CHAR(30)) iuran_decrypt , CAST(AES_DECRYPT(pinjaman, 'ALIHDAYA') AS CHAR(30))pinjaman_decrypt , CAST(AES_DECRYPT(gaji_bersih, 'ALIHDAYA') AS CHAR(30)) gaji_bersih_decrypt 
      
FROM   hitung_gaji*/