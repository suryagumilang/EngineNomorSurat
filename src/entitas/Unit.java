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
public class Unit {

    //Variables:
    String id_unit, nama_unit;
    int is_actived;
    String query;

    //1. Insert
    public void insert(String id_unit, String nama_unit, int is_actived) {
        //Memasukkan ke variable
        id_unit = id_unit;
        nama_unit = nama_unit;
        is_actived = is_actived;

        //Membuat object koneksi ke database
        cls_ConnectionDB obj_ConnectionDB = new cls_ConnectionDB();
        Connection connection = obj_ConnectionDB.get_connection();
        PreparedStatement ps = null;
        try {
            query = "insert into tbl_unit(id_unit,nama_unit,is_actived) values (?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, id_unit);
            ps.setString(2, nama_unit);
            ps.setInt(3, is_actived);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //2. Select One
    public void select_one(String id_unit) {
        //Variable
        id_unit = id_unit;
        //Membuat objek untuk koneksi ke database
        cls_ConnectionDB obj_ConnectionDB = new cls_ConnectionDB();
        Connection connection = obj_ConnectionDB.get_connection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //Perintah query untuk mendapatkan data berdasarkan id unit tertentu
            query = "select * from tbl_unit where id_unit=?";
            ps = connection.prepareStatement(query);
            ps.setString(1, id_unit);
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                /*Tampilkan hal yang anda butuhkan
                    Apabila tidak dibutuhkan dapat di jadikan komentar
                 */
                System.out.println("ID Unit     = " + rs.getString("id_unit")); // Jika ingin menampilkan ID unit
                System.out.println("Nama Unit   = " + rs.getString("nama_unit"));// Jika ingin menampilkan nama unit
                System.out.println("Is Actived  = " + rs.getInt("is_actived"));// Jika ingin menampilkan statusnya
                System.out.println("Nomor Urut  = " + rs.getInt("no_unit"));
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
            query = "select * from tbl_unit";
            ps = connection.prepareStatement(query);
//            ps.setString(1, id_unit);
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                /*Tampilkan hal yang anda butuhkan
                    Apabila tidak dibutuhkan dapat di jadikan komentar
                 */
                System.out.println("ID Unit     = " + rs.getString("id_unit")); // Jika ingin menampilkan ID unit
                System.out.println("Nama Unit   = " + rs.getString("nama_unit"));// Jika ingin menampilkan nama unit
                System.out.println("Is Actived  = " + rs.getInt("is_actived"));// Jika ingin menampilkan statusnya
                System.out.println("Nomor Urut  = " + rs.getInt("no_unit"));
                System.out.println("---------------");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //4. Delete one
    public void delete(String id_unit) {
        //Variable
        id_unit = id_unit;
        //Membuat objek untuk koneksi ke database
        cls_ConnectionDB obj_ConnectionDB = new cls_ConnectionDB();
        Connection connection = obj_ConnectionDB.get_connection();
        PreparedStatement ps = null;
        try {
            query = "delete from tbl_unit where id_unit=?";//Hapus data dengan id_unit tertentu.
            ps = connection.prepareStatement(query);
            ps.setString(1, id_unit);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //5. Update data
    public void update(String id_unit, String new_id_unit, String nama_unit, int is_actived) {
        //Membuat objek untuk koneksi ke database
        cls_ConnectionDB obj_ConnectionDB = new cls_ConnectionDB();
        Connection connection = obj_ConnectionDB.get_connection();
        PreparedStatement ps = null;
        try {
            //Mencari data yang akan diperbarui berdasarkan id_unit
            query = "update tbl_unit set id_unit=?,nama_unit=?,is_actived=? where id_unit=?";
            ps = connection.prepareStatement(query);
            ps.setString(1, new_id_unit);
            ps.setString(2, nama_unit);
            ps.setInt(3, is_actived);
            ps.setString(4, id_unit);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
