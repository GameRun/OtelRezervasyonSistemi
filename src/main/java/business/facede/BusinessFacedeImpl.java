package main.java.business.facede;

import main.java.business.service.ServiceFactory;
import main.java.model.Musteri;

import java.util.List;

public class BusinessFacedeImpl implements  BusinessFacede{
    @Override
    public String musteriKayit(Musteri musteri) {

        return  ServiceFactory.instance().musteriKayit(musteri);

    }

    @Override
    public List<Musteri> musteriListele(Musteri musteriKriter) {

        return ServiceFactory.instance().musteriListele(musteriKriter);
    }

    @Override
    public String musteriGuncelle(Musteri musteri) {

        return ServiceFactory.instance().musteriGuncelle(musteri);

    }

    @Override
    public Musteri musteriBul(int ID) {

        return ServiceFactory.instance().musteriBul(ID);

    }

    @Override
    public String musteriSil(int ID) {

        return ServiceFactory.instance().musteriSil(ID);
    }
}
