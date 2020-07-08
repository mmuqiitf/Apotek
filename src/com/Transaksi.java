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
public class Transaksi {
    public int id_transaksi, id_obat, id_pasien, id_pegawai, qty;

    public Transaksi(int id_transaksi, int id_obat, int id_pasien, int id_pegawai, int qty) {
        this.id_transaksi = id_transaksi;
        this.id_obat = id_obat;
        this.id_pasien = id_pasien;
        this.id_pegawai = id_pegawai;
        this.qty = qty;
    }

    public Transaksi(int id_obat, int id_pasien, int id_pegawai, int qty) {
        this.id_obat = id_obat;
        this.id_pasien = id_pasien;
        this.id_pegawai = id_pegawai;
        this.qty = qty;
    }

    public Transaksi() {
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_obat() {
        return id_obat;
    }

    public void setId_obat(int id_obat) {
        this.id_obat = id_obat;
    }

    public int getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(int id_pasien) {
        this.id_pasien = id_pasien;
    }

    public int getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(int id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Transaksi{" + "id_transaksi=" + id_transaksi + ", id_obat=" + id_obat + ", id_pasien=" + id_pasien + ", id_pegawai=" + id_pegawai + ", qty=" + qty + '}';
    }
    
}
