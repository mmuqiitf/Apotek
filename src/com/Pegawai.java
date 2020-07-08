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
public class Pegawai {
    private int id_pegawai, id_jabatan;
    private String username, password, nama, no_telp, alamat, level;

    public Pegawai(int id_pegawai, int id_jabatan, String username, String password, String nama, String no_telp, String alamat, String level) {
        this.id_pegawai = id_pegawai;
        this.id_jabatan = id_jabatan;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.no_telp = no_telp;
        this.alamat = alamat;
        this.level = level;
    }

    public Pegawai(int id_jabatan, String username, String password, String nama, String no_telp, String alamat, String level) {
        this.id_jabatan = id_jabatan;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.no_telp = no_telp;
        this.alamat = alamat;
        this.level = level;
    }
    
    public Pegawai(int id_pegawai, String nama){
        this.id_pegawai = id_pegawai;
        this.nama = nama;
    }

    public Pegawai() {
    }

    public int getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(int id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public int getId_jabatan() {
        return id_jabatan;
    }

    public void setId_jabatan(int id_jabatan) {
        this.id_jabatan = id_jabatan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return id_pegawai + ": " + nama;
    }
}
