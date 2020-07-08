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
public class Jabatan {
    public int id_jabatan;
    public String nama, keterangan;

    public Jabatan(int id_jabatan, String nama, String keterangan) {
        this.id_jabatan = id_jabatan;
        this.nama = nama;
        this.keterangan = keterangan;
    }

    public Jabatan(String nama, String keterangan) {
        this.nama = nama;
        this.keterangan = keterangan;
    }
    
    public Jabatan() {
    }

    public int getId_jabatan() {
        return id_jabatan;
    }

    public void setId_jabatan(int id_jabatan) {
        this.id_jabatan = id_jabatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    

    @Override
    public String toString() {
        return id_jabatan + ": " + nama;
    }
     
}
