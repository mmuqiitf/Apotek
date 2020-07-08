/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;

import com.Pasien;
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
public class ExecutePasien {
    public List<Pasien> getAllData(){
        String query = "select * from pasien";
        ConnectionManager conMan = new ConnectionManager();
        List<Pasien> lsPasien = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Pasien p = new Pasien();
                p.setId_pasien(rs.getInt("id_pasien"));
                p.setNama(rs.getString("nama"));
                p.setNo_telp(rs.getString("no_telp"));
                p.setAlamat(rs.getString("alamat"));
                lsPasien.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsPasien;
    }
    
    public int insertData(Pasien p ){
        int hasil = 0;
        String query ="insert into pasien(nama, no_telp, alamat) values"
                + "('"+ p.getNama() + "', '" + p.getNo_telp()+ "', '"+ p.getAlamat() +"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePasien.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(query);
        }
        conMan.logOff();
        return hasil;
    }
    public int hapusData(int id_pasien){
        String query = "delete from pasien where id_pasien="+ id_pasien;
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    public int ubahData(Pasien p){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        String query = "Update pasien set nama='"+p.getNama()+"', no_telp='"+p.getNo_telp()+
                "', alamat='"+p.getAlamat() +"' where id_pasien="+ p.getId_pasien();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            System.err.println(query);
            Logger.getLogger(ExecutePegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}
