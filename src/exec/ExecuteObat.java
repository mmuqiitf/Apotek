/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;

import com.Golongan;
import com.Obat;
import com.Pegawai;
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
public class ExecuteObat {
    public List<Obat> getAllData(){
        String query = "select * from obat";
        ConnectionManager conMan = new ConnectionManager();
        List<Obat> lsObat = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Obat o = new Obat();
                o.setId_obat(rs.getInt("id_obat"));
                o.setNama(rs.getString("nama"));
                o.setHarga(rs.getInt("harga"));
                o.setDosis(rs.getString("dosis"));
                o.setStok(rs.getInt("stok"));
                o.setSatuan(rs.getString("satuan"));
                o.setKeterangan(rs.getString("keterangan"));
                o.setId_golongan(rs.getInt("id_golongan"));
                o.setId_supplier(rs.getInt("id_supplier"));
                lsObat.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsObat;
    }
    
    public List<Obat> getAllDataWithRelation(){
        String query = "select obat.*, golongan.*, supplier.* from obat "
                + "join golongan on obat.id_golongan = golongan.id_golongan "
                + "join supplier on obat.id_supplier = supplier.id_supplier";
        ConnectionManager conMan = new ConnectionManager();
        List<Obat> lsObat = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Obat o = new Obat();
                o.setId_obat(rs.getInt("obat.id_obat"));
                o.setNama(rs.getString("obat.nama"));
                o.setHarga(rs.getInt("obat.harga"));
                o.setDosis(rs.getString("obat.dosis"));
                o.setStok(rs.getInt("obat.stok"));
                o.setSatuan(rs.getString("obat.satuan"));
                o.setKeterangan(rs.getString("obat.keterangan"));
                o.setId_golongan(rs.getInt("obat.id_golongan"));
                o.setId_supplier(rs.getInt("obat.id_supplier"));
                Golongan g = new Golongan();
                g.setNama_golongan(rs.getString("golongan.nama_golongan"));
                g.setWarna(rs.getString("golongan.warna"));
                Supplier s = new Supplier();
                s.setNama(rs.getString("supplier.nama"));
                o.setGolongan(g);
                o.setSupplier(s);
                lsObat.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsObat;
    }
    
    public int insertData(Obat o){
        int hasil = 0;
        String query ="insert into obat(nama, harga, dosis, stok, satuan, keterangan, id_golongan, id_supplier) values"
                + "('"+ o.getNama() + "', " + o.getHarga()+ ", '"+ o.getDosis() + "', " +
                o.getStok() + ", '" + o.getSatuan() + "', '" + o.getKeterangan() + "', "+ o.getId_golongan() + 
                ", "+ o.getId_supplier() + ")";
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
    public int hapusData(int id_obat){
        String query = "delete from obat where id_obat="+ id_obat;
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
    public int ubahData(Obat o){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        String query = "Update obat set nama='"+o.getNama()+"', harga="+o.getHarga()+
                ", dosis='"+o.getDosis()+ "', stok="+ o.getStok()+  
                ", satuan='" + o.getSatuan() + "', keterangan='" + o.getKeterangan()
                +"', id_golongan="+ o.getId_golongan() +", id_supplier="+ o.getId_supplier() +" where id_obat="+o.getId_obat();
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
