/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;

import com.Jabatan;
import com.Transaksi;
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
public class ExecuteTransaksi {
    public List<Transaksi> getAllData(){
        String query = "select * from transaksi";
        ConnectionManager conMan = new ConnectionManager();
        List<Transaksi> lsTransaksi = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Transaksi t = new Transaksi();
                t.setId_transaksi(rs.getInt("id_transaksi"));
                t.setId_obat(rs.getInt("id_obat"));
                t.setId_pasien(rs.getInt("id_pasien"));
                t.setId_pegawai(rs.getInt("id_pegawai"));
                t.setQty(rs.getInt("qty"));
                lsTransaksi.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsTransaksi;
    }
    
    public int insertData(Transaksi t){
        int hasil = 0;
        String query ="insert into transaksi(id_obat, id_pasien, id_pegawai, qty) values"
                + "("+ t.getId_obat()+ ", " + t.getId_pasien() + ", " + t.getId_pegawai()
                + ", " + t.getQty()+")";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTransaksi.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(query);
        }
        conMan.logOff();
        return hasil;
    }
    public int hapusData(int id_transaksi){
        String query = "delete from transaksi where id_transaksi="+ id_transaksi;
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    public int ubahData(Transaksi t){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        String query = "Update transaksi set id_obat="+t.getId_obat()+", id_pasien="+t.getId_pasien() 
                +", id_pegawai="+t.getId_pegawai() +", qty="+t.getQty()+ 
                " where id_transaksi="+ t.getId_transaksi();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            System.err.println(query);
            Logger.getLogger(ExecuteTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}
