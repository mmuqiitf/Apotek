/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import com.Jabatan;
import com.Pasien;
import exec.ExecuteJabatan;
import exec.ExecutePasien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALIK
 */
public class ConvertJabatanToObject {
    public String[][] getJabatan(){
        List<Jabatan> myJ = new ArrayList<Jabatan>();
        ExecuteJabatan ej = new ExecuteJabatan();
        myJ = ej.getAllData();
        String[][] dataJabatan = new String[myJ.size()][3];
        int i=0;
        for(Jabatan j : myJ){
            dataJabatan[i][0]= ""+j.getId_jabatan();
            dataJabatan[i][1]= j.getNama();
            dataJabatan[i][2]= j.getKeterangan();
            i++;
        }
        return dataJabatan;
    }
}
