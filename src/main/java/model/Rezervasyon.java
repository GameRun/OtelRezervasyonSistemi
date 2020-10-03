package main.java.model;


import javax.persistence.*;

@Entity
@Table(name = "otel_rezervasyon.rezervasyon")
public class Rezervasyon {


    public Rezervasyon() {
    }


    public Rezervasyon(int id, String baslangicTarihi, String bitisTarihi, String musteriId, String odemeYapildi) {
        this.id = id;
        this.baslangicTarihi = baslangicTarihi;
        this.bitisTarihi = bitisTarihi;
        this.musteriId = musteriId;
        this.odemeYapildi = odemeYapildi;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "baslangic_tarihi")
    private String baslangicTarihi;

    @Column(name = "bitis_tarihi")
    private String bitisTarihi;

    @Column(name = "musteri_id")
    private String musteriId;

    @Column(name = "odeme_yapildi")
    private String odemeYapildi;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(String baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public String getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(String bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }

    public String getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(String musteriId) {
        this.musteriId = musteriId;
    }

    public String getOdemeYapildi() {
        return odemeYapildi;
    }

    public void setOdemeYapildi(String odemeYapildi) {
        this.odemeYapildi = odemeYapildi;
    }

    @Override
    public String toString() {
        return "Rezervasyon{" +
                "id=" + id +
                ", baslangicTarihi='" + baslangicTarihi + '\'' +
                ", bitisTarihi='" + bitisTarihi + '\'' +
                ", musteriId='" + musteriId + '\'' +
                ", odemeYapildi='" + odemeYapildi + '\'' +
                '}';
    }
}
