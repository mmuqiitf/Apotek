/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;

import com.Obat;
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
public class ExecuteSupplier {
    public List<Supplier> getAllData(){
        String query = "select * from supplier";
        ConnectionManager conMan = new ConnectionManager();
        List<Supplier> lsSupplier = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Supplier s = new Supplier();
                s.setId_supplier(rs.getInt("id_supplier"));
                s.setNama(rs.getString("nama"));
                s.setNo_telp(rs.getString("no_telp"));
                s.setAlamat(rs.getString("alamat"));
                lsSupplier.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsSupplier;
    }
    
    public int insertData(Supplier s){
        int hasil = 0;
        String query ="insert into supplier(nama, no_telp, alamat) values"
                + "('"+ s.getNama() + "', '" + s.getNo_telp()+ "', '"+ s.getAlamat() +"')";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteSupplier.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(query);
        }
        conMan.logOff();
        return hasil;
    }
    public int hapusData(int id_supplier){
        String query = "delete from supplier where id_supplier="+ id_supplier;
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
    public int ubahData(Supplier s){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        String query = "Update supplier set nama='"+s.getNama()+"', no_telp='"+s.getNo_telp()+
                "', alamat='"+s.getAlamat() +"' where id_supplier="+ s.getId_supplier();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            System.err.println(query);
            Logger.getLogger(ExecuteSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}
