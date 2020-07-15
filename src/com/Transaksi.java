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
    private int id_transaksi;
    private String invoice, tanggal;
    private int id_pasien, id_pegawai, total;
    private Pasien pasien;
    private Pegawai pegawai;

    public Transaksi(int id_transaksi, String invoice, String tanggal, int id_pasien, int id_pegawai, int total, Pasien pasien, Pegawai pegawai) {
        this.id_transaksi = id_transaksi;
        this.invoice = invoice;
        this.tanggal = tanggal;
        this.id_pasien = id_pasien;
        this.id_pegawai = id_pegawai;
        this.total = total;
        this.pasien = pasien;
        this.pegawai = pegawai;
    }

    public Transaksi(String invoice, String tanggal, int id_pasien, int id_pegawai, int total) {
        this.invoice = invoice;
        this.tanggal = tanggal;
        this.id_pasien = id_pasien;
        this.id_pegawai = id_pegawai;
        this.total = total;
    }

    public Transaksi(int id_transaksi, String invoice, String tanggal, int id_pasien, int id_pegawai, int total) {
        this.id_transaksi = id_transaksi;
        this.invoice = invoice;
        this.tanggal = tanggal;
        this.id_pasien = id_pasien;
        this.id_pegawai = id_pegawai;
        this.total = total;
    }

    public Transaksi(String invoice, String tanggal, int id_pasien, int id_pegawai) {
        this.invoice = invoice;
        this.tanggal = tanggal;
        this.id_pasien = id_pasien;
        this.id_pegawai = id_pegawai;
    }

    public Transaksi() {
    }
    
    public Transaksi(int id_transaksi, String invoice) {
        this.id_transaksi = id_transaksi;
        this.invoice = invoice;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public String toString() {
        return id_transaksi + ": " + invoice;
    }
    
    
    
    
    
}
