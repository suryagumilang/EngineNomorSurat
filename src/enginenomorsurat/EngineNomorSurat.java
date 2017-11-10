/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginenomorsurat;

import entitas.Penanggalan;
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

        // TODO code application logic here
        
//        Instansiasi objek kalender
        Penanggalan kalender = new Penanggalan();
        System.out.println("Tanggal sekarang    = " + kalender.curDate());
        System.out.println("Bulan sekarang      = " + kalender.curMonth());
        System.out.println("Tahun sekarang      = " + kalender.curYear());
//        System.out.println(url);

//        ConnectionDB koneksi = new ConnectionDB();
        cls_ConnectionDB koneksi = new cls_ConnectionDB();
        koneksi.get_connection();

//        Unit unit = new Unit();
//        unit.insertdata("PBU", "Panas Bumi", 1);
//        unit.insertdata("KNE", "Konservasi Energi", 1);
//        unit.insertdata("PNE", "Pengusahaan", 1);
//        unit.select_all();
//String id_unit, String new_id_unit, String nama_unit, int is_actived
//        unit.update("PNE", "PNX", "Pengusahaan", 1);
        Type type = new Type();
//        type.insert("UND", "Undangan", 1);
//        type.insert("SPD", "Surat Perjalanan Dinas", 1);
//        type.insert("SPP", "Surat Pemanggilan Pemeriksaan", 1);
//        type.insert("SPR", "Surat Perintah", 1);
type.select_all();
    }

}
