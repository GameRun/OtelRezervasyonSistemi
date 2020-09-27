package main.java.dao;

import main.java.model.Musteri;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MusteriDAOImpl implements  MusteriDAO{

    private static final EntityManagerFactory emFactoryObj;
    private static final String PERSISTENCE_UNIT_NAME = "OtelRezervasyon";

    static {
        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }

    @Override
    public String musteriKayit(Musteri musteri) {

        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();


        entityMgr.persist(musteri);
        entityMgr.getTransaction().commit();

        entityMgr.clear();
        System.out.println("Record Successfully Inserted In The Database");

        return "Basarili";

    }

    @Override
    public List<Musteri> musteriListele(Musteri musteri) {

        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();

        CriteriaBuilder cb =  entityMgr.getCriteriaBuilder();
        CriteriaQuery<Musteri> criteria =  cb.createQuery(Musteri.class);
        Root<Musteri> root = criteria.from(Musteri.class);

        criteria.where(

        );


        List<Musteri> musteriList = entityMgr.createQuery(criteria).getResultList();

        entityMgr.getTransaction().commit();
        entityMgr.clear();
        entityMgr.close();
        return musteriList;
    }

    @Override
    public Musteri musteriBul(int id) {

        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();

        Musteri musteri = entityMgr.find(Musteri.class, id);
        entityMgr.getTransaction().commit();
        entityMgr.clear();
        entityMgr.close();

        return musteri;

    }

    @Override
    public String musteriSil(int id) {

        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();

        entityMgr.remove(musteriBul(id));
        entityMgr.getTransaction().begin();
        entityMgr.clear();
        entityMgr.close();

        return "Successful";
    }

    @Override
    public String musteriGuncelle(Musteri musteriNewInfo) {
        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();

        Musteri musteri = entityMgr.find(Musteri.class, musteriNewInfo.getID());
        musteri.setEvlilikDurumu(musteriNewInfo.getEvlilikDurumu());
        musteri.setSoyadi(musteriNewInfo.getSoyadi());
        musteri.setAdi(musteriNewInfo.getAdi());

        entityMgr.getTransaction().commit();
        entityMgr.clear();
        entityMgr.close();

        return "Succesfull";
    }
}
