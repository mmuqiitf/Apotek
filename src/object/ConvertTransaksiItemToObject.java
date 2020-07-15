/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import com.Transaksi;
import com.TransaksiItem;
import exec.ExecuteTransaksi;
import exec.ExecuteTransaksiItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALIK
 */
public class ConvertTransaksiItemToObject {
    public String[][] getTransaksi(int id_transaksi){
        List<TransaksiItem> myS = new ArrayList<>();
        ExecuteTransaksiItem et = new ExecuteTransaksiItem();
        myS = et.getAllDataByTransaksi(id_transaksi);
        String[][] dataTransaksi = new String[myS.size()][7];
        int i=0;
        for(TransaksiItem t : myS){
            dataTransaksi[i][0]= ""+t.getId_transaksi_item();
            dataTransaksi[i][1]= ""+t.getId_transaksi();
            dataTransaksi[i][2]= ""+t.getId_obat();
            dataTransaksi[i][3]= ""+t.getQty();
            dataTransaksi[i][4]= ""+t.getSubtotal();
            dataTransaksi[i][5]= ""+t.getObat().getNama();
            dataTransaksi[i][6]= ""+t.getTransaksi().getInvoice();
            i++;
        }
        return dataTransaksi;
    }
}
