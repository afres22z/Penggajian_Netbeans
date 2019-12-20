

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Skripsi_Dicky;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class login extends javax.swing.JFrame {
public Connection cn;
public Statement st;
public ResultSet rs;public String sql="";
        String user="root";
        String pass="";
        String Jabatan="";
    String bagian="";
    /**
     * Creates new form login
     */
    public login() throws SQLException {
        initComponents();
        koneksi();
        
    }
    public void koneksi() throws SQLException
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gaji_pegawai","root","");
            //JOptionPane.showMessageDialog(null, "Koneksi Sukses..!!!");
            System.out.println("koneksi Sukses");
            st=cn.createStatement();
            
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(login.class.getName()).log( Level.SEVERE, null,ex);
        } 
    }
 public void clear(){
        password.setText("");
        username.setText("");
    }
public void cariuser() {
    

        if((username.getText().equals(""))||(String.valueOf(password.getPassword()).equals(""))){
                clear();
                JOptionPane.showMessageDialog (null, "Maaf Username atau Password belum diisi..", "Error Message", JOptionPane.ERROR_MESSAGE);
                }
        else{ 
            try {
            cn=DriverManager.getConnection("jdbc:mysql://localhost/gaji_alihdaya","root","");
            st = cn.createStatement();
            sql = "select * from login where username='"+username.getText()+"'";
            rs = st.executeQuery(sql);
            if (rs.next())
            {
                user = rs.getString("username");
                pass = rs.getString("password");
                bagian= rs.getString("jabatan");
                
                
                    if ((username.getText().equals(user)) && (String.valueOf(password.getPassword()).equals(pass))) {
                    clear();
                    JOptionPane.showMessageDialog (null, "Hai , Selamat datang..");
                    if(bagian.equals("Admin")){
                          Menu_Utama admin = new Menu_Utama();
                        admin.setVisible(true);
                        this.dispose();
                    }   
                    else if(bagian.equals("Manager")){
                       Menu_Manager admin2 = new Menu_Manager();
                       admin2.setVisible(true);
                        this.dispose();
                    }   
                }else{
                       JOptionPane.showMessageDialog (null, "Maaf Password tidak cocok..", "Error Message", JOptionPane.ERROR_MESSAGE);
   clear();
                    }
                
            }else{
              clear();
                    JOptionPane.showMessageDialog (null, "Maaf Username atau Password tidak cocok..", "Error Message", JOptionPane.ERROR_MESSAGE);
   
            }
        }
        catch (SQLException e) {
            System.out.println("Error" +e);
        }           
        }                 
        }

      
      
        
        
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        panelEfect = new pelajaran3.PanelEfect();
        username = new sample.TextField();
        password = new sample.Password();
        jLabel2 = new javax.swing.JLabel();
        button1 = new sample.Button();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelEfect.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.setBackground(new java.awt.Color(153, 153, 255));
        username.setForeground(new java.awt.Color(240, 240, 240));
        username.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        panelEfect.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 178, -1));

        password.setBackground(new java.awt.Color(153, 153, 255));
        password.setForeground(new java.awt.Color(240, 240, 240));
        password.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        panelEfect.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 178, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Password");
        panelEfect.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 65, -1));

        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/login.png"))); // NOI18N
        button1.setText("  LOGIN");
        button1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelEfect.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 301, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 204));
        jLabel4.setText("Username");
        panelEfect.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 85, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel6.setText("Selamat Datang ");
        panelEfect.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 313, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 204));
        jLabel8.setText("Silahkan Login terlebih dahulu...");
        panelEfect.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 220, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bpo2_1.png"))); // NOI18N
        panelEfect.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 100));

        getContentPane().add(panelEfect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

                cariuser();
                 

    }//GEN-LAST:event_button1ActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new login().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sample.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private pelajaran3.PanelEfect panelEfect;
    private sample.Password password;
    private sample.TextField username;
    // End of variables declaration//GEN-END:variables
    }
