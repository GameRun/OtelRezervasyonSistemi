package main.java.model;


import javax.persistence.*;

@Entity
@Table(name = "otel_rezervasyon.musteri")
public class Musteri {

    public Musteri() {
    }

    public Musteri(int ID, String adi, String soyadi, String dogumtarihi, String cinsiyet, String evlilikDurumu) {
        this.ID = ID;
        this.adi = adi;
        this.soyadi = soyadi;
        this.dogumtarihi = dogumtarihi;
        this.cinsiyet = cinsiyet;
        this.evlilikDurumu = evlilikDurumu;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String adi;

    private String soyadi;

    private String dogumtarihi;

    private String cinsiyet;

    @Column(name = "evlilik_durumu")
    private String evlilikDurumu;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }



    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getDogumtarihi() {
        return dogumtarihi;
    }

    public void setDogumtarihi(String dogumtarihi) {
        this.dogumtarihi = dogumtarihi;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getEvlilikDurumu() {
        return evlilikDurumu;
    }

    public void setEvlilikDurumu(String evlilikDurumu) {
        this.evlilikDurumu = evlilikDurumu;
    }


    @Override
    public String toString() {
        return "Musteri{" +
                "ID=" + ID +
                ", adi='" + adi + '\'' +
                ", soyadi='" + soyadi + '\'' +
                ", dogumtarihi='" + dogumtarihi + '\'' +
                ", cinsiyet='" + cinsiyet + '\'' +
                ", evlilikDurumu='" + evlilikDurumu + '\'' +
                '}';
    }
}
