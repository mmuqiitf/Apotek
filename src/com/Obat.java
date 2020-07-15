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
public class Obat {
    private int id_obat, harga, stok, id_golongan, id_supplier;
    private String nama, dosis, keterangan, satuan;
    private Golongan golongan;
    private Supplier supplier;

    public Obat(int id_obat, int harga, int stok, int id_golongan, int id_supplier, String nama, String dosis, String keterangan, String satuan, Golongan golongan, Supplier supplier) {
        this.id_obat = id_obat;
        this.harga = harga;
        this.stok = stok;
        this.id_golongan = id_golongan;
        this.id_supplier = id_supplier;
        this.nama = nama;
        this.dosis = dosis;
        this.keterangan = keterangan;
        this.satuan = satuan;
        this.golongan = golongan;
        this.supplier = supplier;
    }

    public Obat(int id_obat, int harga, int stok, int id_golongan, int id_supplier, String nama, String dosis, String keterangan, String satuan) {
        this.id_obat = id_obat;
        this.harga = harga;
        this.stok = stok;
        this.id_golongan = id_golongan;
        this.id_supplier = id_supplier;
        this.nama = nama;
        this.dosis = dosis;
        this.keterangan = keterangan;
        this.satuan = satuan;
    }

    public Obat(int harga, int stok, int id_golongan, int id_supplier, String nama, String dosis, String keterangan, String satuan) {
        this.harga = harga;
        this.stok = stok;
        this.id_golongan = id_golongan;
        this.id_supplier = id_supplier;
        this.nama = nama;
        this.dosis = dosis;
        this.keterangan = keterangan;
        this.satuan = satuan;
    }

    public Obat() {
        
    }
    
    public Obat(int id_obat, String nama){
        this.id_obat = id_obat;
        this.nama = nama;
        
    }
    public Obat(int id_obat, String nama, int harga){
        this.id_obat = id_obat;
        this.nama = nama;
        this.harga = harga;
    }
    public int getId_obat() {
        return id_obat;
    }

    public void setId_obat(int id_obat) {
        this.id_obat = id_obat;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getId_golongan() {
        return id_golongan;
    }

    public void setId_golongan(int id_golongan) {
        this.id_golongan = id_golongan;
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

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Golongan getGolongan() {
        return golongan;
    }

    public void setGolongan(Golongan golongan) {
        this.golongan = golongan;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return id_obat + ": " + nama;
    }
    
}
