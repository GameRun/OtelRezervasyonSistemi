package main.java.dao;

import main.java.model.Musteri;

import java.util.List;

public interface MusteriDAO {

    public String musteriKayit (Musteri musteri);

    public List<Musteri> musteriListele(Musteri musteri);

    public Musteri musteriBul(int id);

    public String musteriSil(int id);

    public String musteriGuncelle(Musteri musteri);

}
