package main.java.model;


import javax.persistence.*;

@Entity
@Table(name = "otel_rezervasyon.oda")
public class Oda {

    public Oda() {
    }

    public Oda(int id, int odaNumarasi, String odaIsmi, String odaDurumu, String otelId) {
        this.id = id;
        this.odaNumarasi = odaNumarasi;
        this.odaIsmi = odaIsmi;
        this.odaDurumu = odaDurumu;
        this.otelId = otelId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "oda_numarasi")
    private int odaNumarasi;

    @Column(name = "oda_ismi")
    private String odaIsmi;

    @Column(name = "oda_durumu")
    private String odaDurumu;

    @Column(name = "oda_id")
    private String otelId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOdaNumarasi() {
        return odaNumarasi;
    }

    public void setOdaNumarasi(int odaNumarasi) {
        this.odaNumarasi = odaNumarasi;
    }

    public String getOdaIsmi() {
        return odaIsmi;
    }

    public void setOdaIsmi(String odaIsmi) {
        this.odaIsmi = odaIsmi;
    }

    public String getOdaDurumu() {
        return odaDurumu;
    }

    public void setOdaDurumu(String odaDurumu) {
        this.odaDurumu = odaDurumu;
    }

    public String getOtelId() {
        return otelId;
    }

    public void setOtelId(String otelId) {
        this.otelId = otelId;
    }


    @Override
    public String toString() {
        return "Oda{" +
                "id=" + id +
                ", odaNumarasi=" + odaNumarasi +
                ", odaIsmi='" + odaIsmi + '\'' +
                ", odaDurumu='" + odaDurumu + '\'' +
                ", otelId='" + otelId + '\'' +
                '}';
    }
}
