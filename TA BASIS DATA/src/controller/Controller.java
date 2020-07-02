/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Database.koneksi;
import Model.Parfum;
import Model.Prosentase_Alkohol;
import Model.Transaksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Controller {
    koneksi kon;
    ArrayList<Parfum> arrParfum;
    ArrayList<Prosentase_Alkohol> arrProsentase_Alkohol;
    ArrayList<Transaksi> arrTransaksi;
    
    
    
     public Controller() throws SQLException {

        this.kon = new koneksi();
        this.arrParfum = new ArrayList<>();
        this.arrProsentase_Alkohol = new ArrayList<>();
        this.arrTransaksi = new ArrayList<>();
     }
     
     public ArrayList<Parfum> getDataParfum() throws SQLException {
        this.arrParfum.clear();
        ResultSet rs = this.kon.getData("select * from parfum");
        while (rs.next()) {
            Parfum parfum = new Parfum();
            parfum.setId_Parfum(rs.getInt("Id_Parfum"));
            parfum.setNama_Parfum(rs.getNString("Nama_parfum"));
            parfum.setHarga_Parfum(rs.getInt("Harga_Parfum"));
            parfum.setVolume_Parfum(rs.getInt("Volume_Parfum"));
            this.arrParfum.add(parfum);
        }

        return this.arrParfum;
    }
     public ArrayList<Prosentase_Alkohol> getDataProsentase_Alkohol() throws SQLException {
         this.arrProsentase_Alkohol.clear();
        ResultSet rs = this.kon.getData("select * from Prosentase_Alkohol");
        while (rs.next()) {
            Prosentase_Alkohol prosen = new Prosentase_Alkohol();
            prosen.setId_prosentase_alkohol(rs.getInt("Id_prosentase_alkohol"));
            prosen.setVolume_alkohol(rs.getInt("Volume_alkohol"));
            prosen.setHarga_vol_alkohol(rs.getInt("Harga_vol_alkohol"));
            this.arrProsentase_Alkohol.add(prosen);

        }

        return this.arrProsentase_Alkohol;
     }
     
     public ArrayList<Transaksi> getDataTransaksi() throws SQLException {
         this.arrTransaksi.clear();
        ResultSet rs = this.kon.getData("select * FROM PARFUM JOIN TRANSAKSI ON PARFUM.ID_PARFUM = TRANSAKSI.ID_TRANSAKSI JOIN PROSENTASE_ALKOHOL ON TRANSAKSI.ID_PROSENTASE_ALKOHOL = PROSENTASE_ALKOHOL.ID_PROSENTASE_ALKOHOL");
        while (rs.next()) {
            
            Parfum parfum = new Parfum();
            parfum.setId_Parfum(rs.getInt("Id_parfum")); 
            parfum.setNama_Parfum(rs.getNString("Nama_Parfum"));
            parfum.setHarga_Parfum(rs.getInt("Harga_Parfum"));
            parfum.setVolume_Parfum(rs.getInt("Volume_Parfum"));
            
            Prosentase_Alkohol prosen = new Prosentase_Alkohol();
            prosen.setId_prosentase_alkohol(rs.getInt("Id_prosentase_alkohol"));
            prosen.setVolume_alkohol(rs.getInt("Volume_alkohol"));
            prosen.setHarga_vol_alkohol(rs.getInt("Harga_vol_alkohol"));
            
            Transaksi trans = new Transaksi();
            trans.setParfum(parfum);
            trans.setProsentase_alkohol(prosen);
            trans.setId_transaksi(rs.getInt("Id_Transaksi"));
            trans.setTanggal_transaksi(rs.getDate("tgl_transaksi"));
            trans.setUang_bayar(rs.getNString("uang_bayar"));
            trans.setKembalian(rs.getNString("kembalian"));
            trans.setTotal_bayar(rs.getNString("total_harga"));
            
            
            this.arrTransaksi.add(trans);

        }

        return this.arrTransaksi;
     }
     public void insertTransaksi(Transaksi transaksi) {
       try{                                                                                                                                                                                                                                                                                                                                                                                                           
            String datetransaksi = new SimpleDateFormat("dd/MM/yyyy").format(transaksi.getTanggal_transaksi());
            
            kon.ManipulasiData("INSERT INTO TRANSAKSI VALUES (ID_TRANSAKSI.NEXTVAL, "
                    +" , TO_DATE('" +datetransaksi+ "','DD/MM/YYYY'),"
                    + transaksi.getParfum().getId_Parfum()+","
                    + transaksi.getUang_bayar().toString()
                    + transaksi.getKembalian().toString()
                    + transaksi.getProsentase_alkohol().getId_prosentase_alkohol().toString()
                    + transaksi.getTotal_bayar());
            ResultSet rs = kon.getData("SELECT ID_TRANSAKSI.CURRVAL FROM DUAL");
            
            System.out.println(rs);
            rs.next();
            int id_transaksi = rs.getInt("CURRVAL");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}