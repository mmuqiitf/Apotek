/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;

import com.Pegawai;
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
public class ExecutePegawai {
    public List<Pegawai> getAllData(){
        String query = "select * from pegawai";
        ConnectionManager conMan = new ConnectionManager();
        List<Pegawai> lsPegawai = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Pegawai p = new Pegawai();
                p.setId_pegawai(rs.getInt("id_pegawai"));
                p.setId_jabatan(rs.getInt("id_jabatan"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
                p.setNama(rs.getString("nama"));
                p.setNo_telp(rs.getString("no_telp"));
                p.setAlamat(rs.getString("alamat"));
                p.setLevel(rs.getString("level"));
                lsPegawai.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsPegawai;
    }
    
    public int insertData(Pegawai p){
        int hasil = 0;
        String query ="insert into pegawai(username, password, nama, no_telp, alamat, id_jabatan) values"
                + "('"+ p.getNama() + "', '" + p.getPassword()+ "', '"+ p.getNama() + "', '" +
                p.getNo_telp() + "', '" + p.getAlamat() + "', " + p.getId_jabatan() + ")";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePegawai.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(query);
        }
        conMan.logOff();
        return hasil;
    }
    public int hapusData(int id_pegawai){
        String query = "delete from pegawai where id_pegawai="+ id_pegawai;
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    public int ubahData(Pegawai p){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        String query = "Update pegawai set username='"+p.getUsername()+"', password='"+p.getPassword()+
                "', nama='"+p.getNama()+ "', no_telp='"+ p.getNo_telp()+  
                "', alamat='" + p.getAlamat() + "', id_jabatan=" + p.getId_jabatan()
                +" where id_pegawai="+p.getId_pegawai();
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
