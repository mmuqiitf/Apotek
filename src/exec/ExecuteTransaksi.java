/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;

import com.Jabatan;
import com.Obat;
import com.Pasien;
import com.Pegawai;
import com.Transaksi;
import com.Transaksi;
import db.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public List<Transaksi> getAllDataWithRelation(){
        String query = "select transaksi.*, pasien.*, pegawai.* from transaksi join pasien on transaksi.id_pasien = pasien.id_pasien "
                + "join pegawai on transaksi.id_pegawai = pegawai.id_pegawai";
        ConnectionManager conMan = new ConnectionManager();
        List<Transaksi> lsTransaksi = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Transaksi t = new Transaksi();
                t.setId_transaksi(rs.getInt("transaksi.id_transaksi"));
                t.setInvoice(rs.getString("transaksi.invoice"));
                t.setId_pasien(rs.getInt("transaksi.id_pasien"));
                t.setId_pegawai(rs.getInt("transaksi.id_pegawai"));
                t.setTanggal(rs.getString("transaksi.tanggal"));
                t.setTotal(rs.getInt("transaksi.total"));
                Pasien p = new Pasien();
                p.setNama(rs.getString("pasien.nama"));
                Pegawai pg = new Pegawai();
                pg.setNama(rs.getString("pegawai.nama"));
                t.setPasien(p);
                t.setPegawai(pg);
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
        String query ="insert into transaksi(invoice, id_pasien, id_pegawai, tanggal, total) values"
                + "('"+ t.getInvoice()+ "', " + t.getId_pasien()+ ", " + t.getId_pegawai()+ ", '" + t.getTanggal()
                + "', " + t.getTotal()+")";
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
    
    public int insertTransaksi(Transaksi ts){
        String query ="insert into transaksi(invoice, id_pasien, id_pegawai, tanggal)"
                + " values(?, ?, ?, ?)";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        int id_transaksi = 0;
        try {
            Statement stm = conn.createStatement();
            PreparedStatement statement = conn.prepareStatement(query,
                                      Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, ts.getInvoice());
            statement.setInt(2, ts.getId_pasien());
            statement.setInt(3, ts.getId_pegawai());
            statement.setString(4, ts.getTanggal());
             
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating transaksi failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    System.out.println(generatedKeys.getInt(1));
                    id_transaksi = generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Creating transaksi failed, no ID obtained.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTransaksi.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(query);
        }
        conMan.logOff();
        return id_transaksi;
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
        String query = "Update transaksi set invoice='"+ t.getInvoice() +"', id_pasien="+t.getId_pasien() 
                +", id_pegawai="+t.getId_pegawai() +", tanggal='"+t.getTanggal()+"', total=" + t.getTotal()+
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
    public int ubahDataTotal(int id_transaksi, int total){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        String query = "Update transaksi set total="+ total +
                " where id_transaksi="+ id_transaksi;
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
