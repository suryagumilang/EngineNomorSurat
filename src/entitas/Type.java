/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitas;

//Import
import java.sql.*;
import koneksidb.*;
/**
 *
 * @author Surya
 */
public class Type {
    //Variables:
    String id_type, nama_type;
    int is_actived;
    String query;

    //1. Insert
    public void insert(String id_type, String nama_type, int is_actived) {
        //Memasukkan ke variable
        id_type = id_type;
        nama_type = nama_type;
        is_actived = is_actived;

        //Membuat object koneksi ke database
        cls_ConnectionDB obj_ConnectionDB = new cls_ConnectionDB();
        Connection connection = obj_ConnectionDB.get_connection();
        PreparedStatement ps = null;
        try {
            query = "insert into tbl_type(id_type,nama_type,is_actived) values (?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, id_type);//Memasukkan id atau kode dari type
            ps.setString(2, nama_type);//Memasukkan nama type
            ps.setInt(3, is_actived);//Memasukkan status type saat ini
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //2. Select One
    public void select_one(String id_type) {
        //Variable
        id_type = id_type;
        //Membuat objek untuk koneksi ke database
        cls_ConnectionDB obj_ConnectionDB = new cls_ConnectionDB();
        Connection connection = obj_ConnectionDB.get_connection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //Perintah query untuk mendapatkan data berdasarkan id type tertentu
            query = "select * from tbl_type where id_type=?";
            ps = connection.prepareStatement(query);
            ps.setString(1, id_type);
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                /*Tampilkan hal yang anda butuhkan
                    Apabila tidak dibutuhkan dapat di jadikan komentar
                 */
                System.out.println("ID Type     = " + rs.getString("id_type")); // Jika ingin menampilkan ID type
                System.out.println("Nama Type   = " + rs.getString("nama_type"));// Jika ingin menampilkan nama type
                System.out.println("Is Actived  = " + rs.getInt("is_actived"));// Jika ingin menampilkan statusnya
                System.out.println("Nomor Urut  = " + rs.getInt("no_type"));
                System.out.println("---------------");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //3. Select All - Menampilkan semua data pada database
    public void select_all() {
        //Membuat objek untuk koneksi ke database
        cls_ConnectionDB obj_ConnectionDB = new cls_ConnectionDB();
        Connection connection = obj_ConnectionDB.get_connection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //Perintah query untuk mendapatkan data
            query = "select * from tbl_type";
            ps = connection.prepareStatement(query);
//            ps.setString(1, id_type);
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                /*Tampilkan hal yang anda butuhkan
                    Apabila tidak dibutuhkan dapat di jadikan komentar
                 */
                System.out.println("ID Type     = " + rs.getString("id_type")); // Jika ingin menampilkan ID type
                System.out.println("Nama Type   = " + rs.getString("nama_type"));// Jika ingin menampilkan nama type
                System.out.println("Is Actived  = " + rs.getInt("is_actived"));// Jika ingin menampilkan statusnya
                System.out.println("Nomor Urut  = " + rs.getInt("no_type"));
                System.out.println("---------------");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //4. Delete one
    public void delete(String id_type) {
        //Variable
        id_type = id_type;
        //Membuat objek untuk koneksi ke database
        cls_ConnectionDB obj_ConnectionDB = new cls_ConnectionDB();
        Connection connection = obj_ConnectionDB.get_connection();
        PreparedStatement ps = null;
        try {
            query = "delete from tbl_type where id_type=?";//Hapus data dengan id_type tertentu.
            ps = connection.prepareStatement(query);
            ps.setString(1, id_type);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //5. Update data
    public void update(String id_type, String new_id_type, String nama_type, int is_actived) {
        //Membuat objek untuk koneksi ke database
        cls_ConnectionDB obj_ConnectionDB = new cls_ConnectionDB();
        Connection connection = obj_ConnectionDB.get_connection();
        PreparedStatement ps = null;
        try {
            //Mencari data yang akan diperbarui berdasarkan id_type
            query = "update tbl_type set id_type=?,nama_type=?,is_actived=? where id_type=?";
            ps = connection.prepareStatement(query);
            ps.setString(1, new_id_type);
            ps.setString(2, nama_type);
            ps.setInt(3, is_actived);
            ps.setString(4, id_type);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
