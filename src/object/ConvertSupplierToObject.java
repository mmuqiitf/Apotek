/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import com.Pasien;
import com.Supplier;
import exec.ExecutePasien;
import exec.ExecuteSupplier;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALIK
 */
public class ConvertSupplierToObject {
    public String[][] getSupplier(){
        List<Supplier> myS = new ArrayList<>();
        ExecuteSupplier es = new ExecuteSupplier();
        myS = es.getAllData();
        String[][] dataPasien = new String[myS.size()][4];
        int i=0;
        for(Supplier s : myS){
            dataPasien[i][0]= ""+s.getId_supplier();
            dataPasien[i][1]= s.getNama();
            dataPasien[i][2]= s.getNo_telp();
            dataPasien[i][3]= s.getAlamat();
            i++;
        }
        return dataPasien;
    }
}
