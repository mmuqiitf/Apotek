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
        myS = et.getAllData();
        String[][] dataTransaksi = new String[myS.size()][5];
        int i=0;
        for(Transaksi t : myS){
            dataTransaksi[i][0]= ""+t.getId_transaksi();
            dataTransaksi[i][1]= ""+t.getId_obat();
            dataTransaksi[i][2]= ""+t.getId_pasien();
            dataTransaksi[i][3]= ""+t.getId_pegawai();
            dataTransaksi[i][4]= ""+t.getQty();
            i++;
        }
        return dataTransaksi;
    }
}
