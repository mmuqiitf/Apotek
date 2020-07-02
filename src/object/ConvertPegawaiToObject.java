/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import com.Pegawai;
import exec.ExecutePegawai;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALIK
 */
public class ConvertPegawaiToObject {
    public String[][] getPegawai(){
        List<Pegawai> myP = new ArrayList<Pegawai>();
        ExecutePegawai executePegawai = new ExecutePegawai();
        myP = executePegawai.getAllData();
        String[][] dataPegawai = new String[myP.size()][8];
        int i=0;
        for(Pegawai p : myP){
            dataPegawai[i][0]= ""+p.getId_jabatan();
            dataPegawai[i][1]= p.getUsername();
            dataPegawai[i][2]= p.getPassword();
            dataPegawai[i][3]= p.getNama();
            dataPegawai[i][4]= p.getNo_telp();
            dataPegawai[i][5]= p.getAlamat();
            dataPegawai[i][6]= ""+p.getId_jabatan();
            dataPegawai[i][7]= p.getLevel();
            i++;
        }
        return dataPegawai;
    }
}
