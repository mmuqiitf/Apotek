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
public class TransaksiItem {
    private int id_transaksi_item, id_transaksi, id_obat, qty, subtotal;
    private Transaksi transaksi;
    private Obat obat;

    public TransaksiItem(int id_transaksi_item, int id_transaksi, int id_obat, int qty, int subtotal) {
        this.id_transaksi_item = id_transaksi_item;
        this.id_transaksi = id_transaksi;
        this.id_obat = id_obat;
        this.qty = qty;
        this.subtotal = subtotal;
    }

    public TransaksiItem(int id_transaksi, int id_obat, int qty, int subtotal) {
        this.id_transaksi = id_transaksi;
        this.id_obat = id_obat;
        this.qty = qty;
        this.subtotal = subtotal;
    }

    public TransaksiItem(int id_transaksi_item, int id_transaksi, int id_obat, int qty, int subtotal, Transaksi transaksi, Obat obat) {
        this.id_transaksi_item = id_transaksi_item;
        this.id_transaksi = id_transaksi;
        this.id_obat = id_obat;
        this.qty = qty;
        this.subtotal = subtotal;
        this.transaksi = transaksi;
        this.obat = obat;
    }

    public TransaksiItem() {
    }
    

    public int getId_transaksi_item() {
        return id_transaksi_item;
    }

    public void setId_transaksi_item(int id_transaksi_item) {
        this.id_transaksi_item = id_transaksi_item;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Obat getObat() {
        return obat;
    }

    public void setObat(Obat obat) {
        this.obat = obat;
    }

    @Override
    public String toString() {
        return id_transaksi + ": " + id_transaksi_item;
    }
    
}
