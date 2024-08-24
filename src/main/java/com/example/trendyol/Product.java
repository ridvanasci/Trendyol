package com.example.trendyol;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double UrunID;

    private String KategoriAdi;
    private Double KategoriID;
    private String MarkaAdi;
    private String MarkaID;
    private String ResimURL;
    private String Stok;
    private String UrunAciklamasi;
    private String UrunAdi;
    private Float UrunFiyati;
    private String UrunURL;

    public Double getUrunID() {
        return UrunID;
    }

    public void setUrunID(Double UrunID) {
        this.UrunID = UrunID;
    }

    public String getUrunAdi() {
        return UrunAdi;
    }

    public void setUrunAdi(String UrunAdi) {
        this.UrunAdi = UrunAdi;
    }

    public String getUrunAciklamasi() {
        return UrunAciklamasi;
    }

    public void setUrunAciklamasi(String UrunAciklamasi) {
        this.UrunAciklamasi = UrunAciklamasi;
    }

    public Float  getUrunFiyati() {
        return UrunFiyati;
    }

    public void setUrunFiyati(Float UrunFiyati) {
        this.UrunFiyati = UrunFiyati;
    }

    public String getStok() {
        return Stok;
    }

    public void setStok(String Stok) {
        this.Stok = Stok;
    }

    public Double getKategoriID() {
        return KategoriID;
    }

    public void setKategoriID(Double KategoriID) {
        this.KategoriID = KategoriID;
    }

    public String getKategoriAdi() {
        return KategoriAdi;
    }

    public void setKategoriAdi(String KategoriAdi) {
        this.KategoriAdi = KategoriAdi;
    }

    public String getMarkaID() {
        return MarkaID;
    }

    public void setMarkaID(String MarkaID) {
        this.MarkaID = MarkaID;
    }

    public String getMarkaAdi() {
        return MarkaAdi;
    }

    public void setMarkaAdi(String MarkaAdi) {
        this.MarkaAdi = MarkaAdi;
    }

    public String getResimURL() {
        return ResimURL;
    }

    public void setResimURL(String ResimURL) {
        this.ResimURL = ResimURL;
    }

    public String getUrunURL() {
        return UrunURL;
    }

    public void setUrunURL(String UrunURL) {
        this.UrunURL = UrunURL;
    }
}