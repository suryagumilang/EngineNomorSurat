/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksidb;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.*;
/**
 *
 * @author Surya
 */
public class cls_ConnectionDB {
    
    //    Variable untuk terhubung ke database
    String server = "localhost";//Sesuaikan alamat server database
    String port = "3306";
    String nama_db = "db_nomorsurat_java";//Sesuaikan dengan nama database
//    String url = "jdbc:mysql://localhost:3306/db_nomorsurat";
    String url = "jdbc:mysql://" + server + ":" + port + "/" + nama_db;
    String user_db = "root";
    String password_db = "";

    public static void main(String[] args) {
        cls_ConnectionDB obj_koneksi = new cls_ConnectionDB();
        System.out.println(obj_koneksi.get_connection());
    }

    public Connection get_connection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url, user_db, password_db);
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}
