package main.java.dao;

import main.java.model.Musteri;
import main.java.model.Oda;

import java.util.List;

public interface OdaDAO {


    public String odaKayit (Oda oda);

    public List<Oda> odaListele(Oda oda);

    public Oda odaBul(int id);

    public String odaSil(int id);

    public String odaGuncelle(Oda oda);

}
