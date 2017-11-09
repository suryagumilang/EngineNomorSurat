/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginenomorsurat;

import koneksidb.ConnectionDB;
import koneksidb.cls_ConnectionDB;
import entitas.*;
/**
 *
 * @author Surya
 */
public class EngineNomorSurat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String server = "localhost";
        String port = "3306";
        String nama_db = "db_nomorsurat";
//    String url = "jdbc:mysql://localhost:3306/db_nomorsurat";
        String url = "jdbc:mysql://" + server + ":" + port + "/" + nama_db;
        // TODO code application logic here

//        Instansiasi objek kalender
        CoreEngine kalender = new CoreEngine();
        System.out.println("Tanggal sekarang    = " + kalender.curDate());
        System.out.println("Bulan sekarang      = " + kalender.curMonth());
        System.out.println("Tahun sekarang      = " + kalender.curYear());
        System.out.println(url);
        
//        ConnectionDB koneksi = new ConnectionDB();
        cls_ConnectionDB koneksi = new cls_ConnectionDB();
        koneksi.get_connection();
        
        Unit unit = new Unit();
//        unit.insertdata("PBU", "Panas Bumi", 1);
//        unit.insertdata("KNE", "Konservasi Energi", 1);
//        unit.insertdata("PNE", "Pengusahaan", 1);
        unit.select_all();
    }

}
