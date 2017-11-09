/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksidb;

//Import library
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.*;

/**
 *
 * @author Surya
 */
public class ConnectionDB {

    private static Connection koneksi;
    public String conection_result;
    public static Connection con;
    public static Statement stm;
    String sql;

//    Variable untuk terhubung ke database
    String server = "localhost";
    String port = "3306";
    String nama_db = "db_nomorsurat";
//    String url = "jdbc:mysql://localhost:3306/db_nomorsurat";
    String url = "jdbc:mysql://" + server + ":" + port + "/" + nama_db;
    String user_db = "root";
    String password_db = "";

    //Method untuk koneksi ke database
    public void GetConnection() {
        try {
            //Driver untuk mysql: com.mysql.jdbc.Driver
            Class.forName("com.mysql.jdbc.Driver");
            //parameter untuk terhubung ke database adalah url db, username, dan password
            con = (Connection) DriverManager.getConnection(url, user_db, password_db);
            stm = con.createStatement();
            System.out.println("koneksi berhasil");
        } catch (Exception e) {
            System.err.println("koneksi gagal" + e.getMessage());
        }
    }
    //End of Method untuk koneksi ke database

    //Method INSERT data unit
    public void InsertUnit() throws SQLException {
        //Dummy data
        String id_unit = "PBU";
        String nama_unit = "Panas Bumi";
        int is_actived = 1;

        //Query insertnya
        //Exmp:
        //String sql_stmt = "INSERT INTO contacts (name,email,contact_number) VALUES ('" + name + "','" + email + "','" + contact_number + "')";
//        sql = "INSERT INTO tbl_unit (id_unit, nama_unit, is_actived) VALUES ('" + id_unit + "','" + nama_unit + "','" + is_actived + "')" ;
        sql = "insert into employees (id_unit, nama_unit, is_actived) values (?, ?, ?)";
        stm = con.prepareStatement(sql);
        
    }
    //End of Method INSERT data unit

    //Method INSERT data type surat
    public void InsertType() {

    }
    //End of Method INSERT data type surat

}
