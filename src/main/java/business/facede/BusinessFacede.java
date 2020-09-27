package main.java.business.facede;

import main.java.model.Musteri;

import java.util.List;

public interface BusinessFacede {

    public String musteriKayit(Musteri musteri);

    public List<Musteri> musteriListele(Musteri musteriKriter);

    public String musteriGuncelle(Musteri musteri);

    public Musteri musteriBul(int ID);

    public String musteriSil(int ID);


}
