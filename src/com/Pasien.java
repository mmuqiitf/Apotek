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
public class Pasien {
    public int id_pasien;
    public String nama, alamat, no_telp;

    public Pasien(int id_pasien, String nama, String alamat, String no_telp) {
        this.id_pasien = id_pasien;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telp = no_telp;
    }

    public Pasien(String nama, String alamat, String no_telp) {
        this.nama = nama;
        this.alamat = alamat;
        this.no_telp = no_telp;
    }
    
    public Pasien(int id_pasien, String nama) {
        this.id_pasien = id_pasien;
        this.nama = nama;
    }
    
    public Pasien() {
    }

    public int getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(int id_pasien) {
        this.id_pasien = id_pasien;
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
        return id_pasien + ": " + nama;
    }
    
    
}
