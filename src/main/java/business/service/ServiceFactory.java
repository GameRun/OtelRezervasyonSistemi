package main.java.business.service;

import main.java.model.Musteri;

import java.util.List;

public class ServiceFactory {


    public static ServiceFactory factory;

    private MusteriBusinessService musteriService = null;

    private ServiceFactory() {
        initFactory();

    }
    public static ServiceFactory instance(){
        if(factory == null){
            factory = new ServiceFactory();
        }
        return factory;
    }

    private  void initFactory(){
        musteriService = new MusteriBusinessServiceImpl() {
        };
    }

    public String musteriKayit(Musteri musteri){
        return getBusinessService().musteriKayit(musteri);
    }

    public List<Musteri> musteriListele(Musteri musteri){
        return getBusinessService().musteriListele(musteri);
    }

    public Musteri musteriBul(int id){
        return getBusinessService().musteriBul(id);
    }

    public String musteriGuncelle(Musteri musteri){
        return getBusinessService().musteriGuncelle(musteri);
    }

    public String musteriSil(int id){
        return getBusinessService().musteriSil(id);
    }

    private MusteriBusinessService getBusinessService(){
        return musteriService;
    }

}
