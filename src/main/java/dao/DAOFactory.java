package main.java.dao;

import main.java.model.Musteri;

import java.util.List;

public class DAOFactory {

    public static DAOFactory factory;

    private MusteriDAO musteriDAO;


    private  DAOFactory(){
        initFactory();
    }


    public static DAOFactory instance(){
        if(factory == null){
            factory = new DAOFactory();
        }
        return  factory;
    }


    private void initFactory() {

        musteriDAO = new MusteriDAOImpl();

    }

    private MusteriDAO getMusteriDAO(){
        return musteriDAO;
    }

    public String musteriKayit(Musteri musteri){
        return getMusteriDAO().musteriKayit(musteri);
    }

    public Musteri musteriBul(int id){ return getMusteriDAO().musteriBul(id); }

    public List<Musteri> musteriListele(Musteri musteri){ return getMusteriDAO().musteriListele(musteri);}

    public String musteriGuncelle(Musteri musteri){ return getMusteriDAO().musteriGuncelle(musteri);}

    public String musteriSil(int id){ return getMusteriDAO().musteriSil(id);}
}
