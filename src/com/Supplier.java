/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author ALIK
 */
public class Supplier {
    public int id_supplier;
    public String nama, alamat, no_telp;

    public Supplier(int id_supplier, String nama, String alamat, String no_telp) {
        this.id_supplier = id_supplier;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telp = no_telp;
    }

    public Supplier(String nama, String alamat, String no_telp) {
        this.nama = nama;
        this.alamat = alamat;
        this.no_telp = no_telp;
    }

    public Supplier() {
    }
    
    public int getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    @Override
    public String toString() {
        return id_supplier + ": " + nama;
    }
    
}
