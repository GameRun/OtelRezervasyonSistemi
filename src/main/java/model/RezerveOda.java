package main.java.model;

import javax.persistence.*;


@Entity
@Table(name = "otel_rezervasyon.rezerve_oda")
public class RezerveOda {


    public RezerveOda() {
    }

    public RezerveOda(int id, int odaId, int rezervasyonId, int rezervasyonDurumu) {
        this.id = id;
        this.odaId = odaId;
        this.rezervasyonId = rezervasyonId;
        this.rezervasyonDurumu = rezervasyonDurumu;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="oda_id" )
    private int odaId;

    @Column(name = "rezervasyon_id")
    private int rezervasyonId;

    @Column(name = "rezervasyon_durumu")
    private int rezervasyonDurumu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOdaId() {
        return odaId;
    }

    public void setOdaId(int odaId) {
        this.odaId = odaId;
    }

    public int getRezervasyonId() {
        return rezervasyonId;
    }

    public void setRezervasyonId(int rezervasyonId) {
        this.rezervasyonId = rezervasyonId;
    }

    public int getRezervasyonDurumu() {
        return rezervasyonDurumu;
    }

    public void setRezervasyonDurumu(int rezervasyonDurumu) {
        this.rezervasyonDurumu = rezervasyonDurumu;
    }

    @Override
    public String toString() {
        return "RezerveOda{" +
                "id=" + id +
                ", odaId=" + odaId +
                ", rezervasyonId=" + rezervasyonId +
                ", rezervasyonDurumu=" + rezervasyonDurumu +
                '}';
    }
}
