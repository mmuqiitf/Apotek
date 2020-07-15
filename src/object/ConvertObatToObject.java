/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import com.Obat;
import com.Pegawai;
import exec.ExecuteObat;
import exec.ExecutePegawai;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALIK
 */
public class ConvertObatToObject {
    public String[][] getObat(){
        List<Obat> myO = new ArrayList<>();
        ExecuteObat executeObat = new ExecuteObat();
        myO = executeObat.getAllDataWithRelation();
        String[][] dataObat = new String[myO.size()][12];
        int i=0;
        for(Obat o : myO){
            dataObat[i][0]= ""+o.getId_obat();
            dataObat[i][1]= o.getNama();
            dataObat[i][2]= ""+o.getHarga();
            dataObat[i][3]= o.getDosis();
            dataObat[i][4]= ""+o.getStok();
            dataObat[i][5]= o.getSatuan();
            dataObat[i][6]= o.getKeterangan();
            dataObat[i][7]= ""+o.getId_golongan();
            dataObat[i][8]= ""+o.getId_supplier();
            dataObat[i][9]= o.getGolongan().getNama_golongan();
            dataObat[i][10]= o.getSupplier().getNama();
            i++;
        }
        return dataObat;
    }
}
