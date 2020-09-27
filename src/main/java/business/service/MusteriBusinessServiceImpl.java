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
        List<Musteri> musteriList = null;
        musteriList = DAOFactory.instance().musteriListele(musteriKriter);

        return musteriList;
    }

    @Override
    public String musteriGuncelle(Musteri musteri) {
        String result = null;
        result = DAOFactory.instance().musteriGuncelle(musteri);
        return result;
    }

    @Override
    public Musteri musteriBul(int id) {
        Musteri musteri = null;
        musteri = DAOFactory.instance().musteriBul(id);
        return musteri;
    }

    @Override
    public String musteriSil(int id) {

        String result = null;
        result = DAOFactory.instance().musteriSil(id);
        return result;
    }
}
