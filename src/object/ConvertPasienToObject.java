/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import com.Pasien;
import com.Pegawai;
import exec.ExecutePasien;
import exec.ExecutePegawai;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALIK
 */
public class ConvertPasienToObject {
    public String[][] getPasien(){
        List<Pasien> myP = new ArrayList<Pasien>();
        ExecutePasien executePasien = new ExecutePasien();
        myP = executePasien.getAllData();
        String[][] dataPasien = new String[myP.size()][4];
        int i=0;
        for(Pasien p : myP){
            dataPasien[i][0]= ""+p.getId_pasien();
            dataPasien[i][1]= p.getNama();
            dataPasien[i][2]= p.getAlamat();
            dataPasien[i][3]= p.getNo_telp();
            i++;
        }
        return dataPasien;
    }
}
