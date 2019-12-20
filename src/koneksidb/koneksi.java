/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksidb;

/**
 *
 * @author Software
 */
import java.sql.*;

public class koneksi {
    private Connection kon;
    public koneksi() {
        try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        kon= DriverManager.getConnection("jdbc:mysql://localhost:3306/gaji_alihdaya","root","");
        System.out.println("koneksi sukses");
    
        } catch (Exception e) {
             System.out.println(e);
        }
    }
    
    public Connection getConnection() {
        return kon;
    }
}
    
    

