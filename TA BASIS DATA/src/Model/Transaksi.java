/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Transaksi {
   private Integer Id_transaksi;
   private Date Tanggal_transaksi;
   private Parfum parfum;
   private Prosentase_Alkohol prosentase_alkohol;
   private String Total_bayar;
   private String Uang_bayar;
   private String Kembalian;

    public Integer getId_transaksi() {
        return Id_transaksi;
    }

    public void setId_transaksi(Integer Id_transaksi) {
        this.Id_transaksi = Id_transaksi;
    }

    public Date getTanggal_transaksi() {
        return Tanggal_transaksi;
    }

    public void setTanggal_transaksi(Date Tanggal_transaksi) {
        this.Tanggal_transaksi = Tanggal_transaksi;
    }

    public Parfum getParfum() {
        return parfum;
    }

    public void setParfum(Parfum parfum) {
        this.parfum = parfum;
    }

    public Prosentase_Alkohol getProsentase_alkohol() {
        return prosentase_alkohol;
    }

    public void setProsentase_alkohol(Prosentase_Alkohol prosentase_alkohol) {
        this.prosentase_alkohol = prosentase_alkohol;
    }

    public String getTotal_bayar() {
        return Total_bayar;
    }

    public void setTotal_bayar(String Total_bayar) {
        this.Total_bayar = Total_bayar;
    }

    public String getUang_bayar() {
        return Uang_bayar;
    }

    public void setUang_bayar(String Uang_bayar) {
        this.Uang_bayar = Uang_bayar;
    }

    public String getKembalian() {
        return Kembalian;
    }

    public void setKembalian(String Kembalian) {
        this.Kembalian = Kembalian;
    }
}