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
public class Golongan {
    public int id_golongan;
    public String nama_golongan, warna, keterangan;

    public Golongan(int id_golongan, String nama_golongan, String warna, String keterangan) {
        this.id_golongan = id_golongan;
        this.nama_golongan = nama_golongan;
        this.warna = warna;
        this.keterangan = keterangan;
    }

    public Golongan(String nama_golongan, String warna, String keterangan) {
        this.nama_golongan = nama_golongan;
        this.warna = warna;
        this.keterangan = keterangan;
    }

    public Golongan() {
    }

    public int getId_golongan() {
        return id_golongan;
    }

    public void setId_golongan(int id_golongan) {
        this.id_golongan = id_golongan;
    }

    public String getNama_golongan() {
        return nama_golongan;
    }

    public void setNama_golongan(String nama_golongan) {
        this.nama_golongan = nama_golongan;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return id_golongan + ": " + nama_golongan;
    }
    
    
}
