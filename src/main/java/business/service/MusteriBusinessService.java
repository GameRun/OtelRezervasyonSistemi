package main.java.business.service;

import main.java.model.Musteri;

import java.util.List;

public interface MusteriBusinessService {

    public String musteriKayit(Musteri musteri);

    public List<Musteri> musteriListele(Musteri musteriKriter);

    public String musteriGuncelle(Musteri musteri);

    public Musteri musteriBul(int ID);

    public String musteriSil(int ID);
}
