package main.java.dao;

import main.java.model.Musteri;

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

}
