/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;

import com.Jabatan;
import com.Supplier;
import db.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALIK
 */
public class ExecuteJabatan {
    public List<Jabatan> getAllData(){
        String query = "select * from jabatan";
        ConnectionManager conMan = new ConnectionManager();
        List<Jabatan> lsJabatan = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Jabatan j = new Jabatan();
                j.setId_jabatan(rs.getInt("id_supplier"));
                j.setNama(rs.getString("nama"));
                j.setKeterangan(rs.getString("keterangan"));
                lsJabatan.add(j);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteJabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsJabatan;
    }
    
    public int insertData(Jabatan j){
        int hasil = 0;
        String query ="insert into jabatan(nama, keterangan) values"
                + "('"+ j.getNama()+ "', '" + j.getKeterangan() +"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteJabatan.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(query);
        }
        conMan.logOff();
        return hasil;
    }
    public int hapusData(int id_jabatan){
        String query = "delete from jabatan where id_jabatan="+ id_jabatan;
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteJabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    public int ubahData(Jabatan j){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        String query = "Update jabatan set nama='"+j.getNama()+"', no_telp='"+j.getKeterangan() + 
                "' where id_jabatan="+ j.getId_jabatan();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            System.err.println(query);
            Logger.getLogger(ExecuteJabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}
