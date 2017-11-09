/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginenomorsurat;

//Library untuk ambil data tanggal, bulan, tahun
import java.util.Calendar;

/**
 *
 * @author Surya
 */
public class CoreEngine {

    int date, month, year;

    
//    BAGIAN TANGGAL UNTUK NOMOR SURAT
//Instansiasi objek calendar
    Calendar kal = Calendar.getInstance();
//Method ambil tanggal sekarang
    public int curDate() {
        date = kal.get(Calendar.DATE);
        return date;
    }
//Method ambil bulan sekarang
    public int curMonth() {
//        month = kal.get(Calendar.MONTH);
        month = (kal.get(Calendar.MONTH))+1;
        return month;
    }
//Method ambil tahun sekarang
    public int curYear() {
        year = kal.get(Calendar.YEAR);
        return year;
    }

}
