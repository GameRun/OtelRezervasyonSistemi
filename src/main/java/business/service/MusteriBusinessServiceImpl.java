package main.java.business.service;

import main.java.dao.DAOFactory;
import main.java.model.Musteri;

import java.util.List;

public class MusteriBusinessServiceImpl implements MusteriBusinessService {
    @Override
    public String musteriKayit(Musteri musteri) {
        String result = null;
        result = DAOFactory.instance().musteriKayit(musteri);
        return result;
    }

    @Override
    public List<Musteri> musteriListele(Musteri musteriKriter) {
        return null;
    }

    @Override
    public String musteriGuncelle(Musteri musteri) {
        return null;
    }

    @Override
    public Musteri musteriBul(int ID) {
        return null;
    }

    @Override
    public String musteriSil(int ID) {
        return null;
    }
}
