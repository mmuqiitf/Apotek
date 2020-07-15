/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;

import com.Obat;
import com.Transaksi;
import com.Transaksi;
import com.TransaksiItem;
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
public class ExecuteTransaksiItem {
    public int insertData(TransaksiItem t){
        int hasil = 0;
        String query ="insert into transaksi_item(id_transaksi, id_obat, qty, subtotal) values"
                + "("+ t.getId_transaksi()+ ", " + t.getId_obat()+ ", " + t.getQty()+ ", " + t.getSubtotal()+")";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTransaksiItem.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(query);
        }
        conMan.logOff();
        return hasil;
    }
    
    public List<TransaksiItem> getAllDataByTransaksi(int id_transaksi){
        String query = "select transaksi_item.*, obat.*, transaksi.* from transaksi_item join obat on transaksi_item.id_obat = obat.id_obat "
                + "join transaksi on transaksi_item.id_transaksi = transaksi.id_transaksi "
                + "where transaksi_item.id_transaksi=" + id_transaksi;
        ConnectionManager conMan = new ConnectionManager();
        List<TransaksiItem> lsTransaksi = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                TransaksiItem t = new TransaksiItem();
                t.setId_transaksi_item(rs.getInt("transaksi_item.id_transaksi_item"));
                t.setId_transaksi(rs.getInt("transaksi_item.id_transaksi"));
                t.setId_obat(rs.getInt("transaksi_item.id_obat"));
                t.setQty(rs.getInt("transaksi_item.qty"));
                t.setSubtotal(rs.getInt("transaksi_item.subtotal"));
                Obat obat = new Obat();
                obat.setNama(rs.getString("obat.nama"));
                obat.setHarga(rs.getInt("obat.harga"));
                t.setObat(obat);
                Transaksi tr = new Transaksi();
                tr.setInvoice(rs.getString("transaksi.invoice"));
                t.setTransaksi(tr);
                lsTransaksi.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsTransaksi;
    }
    
    public int ubahData(TransaksiItem t){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        String query = "Update transaksi_item set id_obat="+ t.getId_obat()+", qty="+t.getQty()
                +", subtotal="+t.getSubtotal()+
                " where id_transaksi_item="+ t.getId_transaksi_item();
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
    
    public int hapusData(int id_transaksi_item){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        String query = "delete from transaksi_item where id_transaksi_item="+ id_transaksi_item;
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
