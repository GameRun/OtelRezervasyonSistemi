package main.java.dao;

import main.java.model.Rezervasyon;

import java.util.List;

public interface RezervasyonDAO {

    public String musteriKayit (Rezervasyon rezervasyon);

    public List<Rezervasyon> musteriListele(Rezervasyon rezervasyon);

    public Rezervasyon rezervasyonBul(int id);

    public String rezervasyonSil(int id);

    public String rezervasyonGuncelle(Rezervasyon rezervasyon);



}
