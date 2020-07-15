/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import com.Supplier;
import com.Transaksi;
import exec.ExecuteSupplier;
import exec.ExecuteTransaksi;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALIK
 */
public class ConvertTransaksiToObject {
    public String[][] getTransaksi(){
        List<Transaksi> myS = new ArrayList<>();
        ExecuteTransaksi et = new ExecuteTransaksi();
        myS = et.getAllDataWithRelation();
        String[][] dataTransaksi = new String[myS.size()][8];
        int i=0;
        for(Transaksi t : myS){
            dataTransaksi[i][0]= ""+t.getId_transaksi();
            dataTransaksi[i][1]= ""+t.getInvoice();
            dataTransaksi[i][2]= ""+t.getId_pasien();
            dataTransaksi[i][3]= ""+t.getId_pegawai();
            dataTransaksi[i][4]= ""+t.getTanggal();
            dataTransaksi[i][5]= ""+t.getTotal();
            dataTransaksi[i][6]= ""+t.getPasien().getNama();
            dataTransaksi[i][7]= ""+t.getPegawai().getNama();
            i++;
        }
        return dataTransaksi;
    }
}
