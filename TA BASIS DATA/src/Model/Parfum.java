/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
public class Parfum {
    private Integer Id_Parfum;
    private String Nama_Parfum;
    private Integer Harga_Parfum;
    private Integer Volume_Parfum;

    public Integer getId_Parfum() {
        return Id_Parfum;
    }

    public void setId_Parfum(Integer Id_Parfum) {
        this.Id_Parfum = Id_Parfum;
    }

    public String getNama_Parfum() {
        return Nama_Parfum;
    }

    public void setNama_Parfum(String Nama_Parfum) {
        this.Nama_Parfum = Nama_Parfum;
    }

    public Integer getHarga_Parfum() {
        return Harga_Parfum;
    }

    public void setHarga_Parfum(Integer Harga_Parfum) {
        this.Harga_Parfum = Harga_Parfum;
    }

    public Integer getVolume_Parfum() {
        return Volume_Parfum;
    }

    public void setVolume_Parfum(Integer Volume_Parfum) {
        this.Volume_Parfum = Volume_Parfum;
    }
}
