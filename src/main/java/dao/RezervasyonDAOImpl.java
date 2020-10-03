package main.java.dao;

import main.java.model.Rezervasyon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class RezervasyonDAOImpl implements  RezervasyonDAO{

    private static final EntityManagerFactory emFactoryObj;
    private static final String PERSISTENCE_UNIT_NAME = "OtelRezervasyon";

    static {
        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }

    @Override
    public String musteriKayit(Rezervasyon rezervasyon) {

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(rezervasyon);
        entityManager.getTransaction().commit();

        entityManager.clear();
        entityManager.close();

        return "Basarili";
    }

    @Override
    public List<Rezervasyon> musteriListele(Rezervasyon rezervasyon) {

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Rezervasyon> criteria = cb.createQuery(Rezervasyon.class);

        criteria.where(

        );

        List<Rezervasyon> rezervasyonList = entityManager.createQuery(criteria).getResultList();

        entityManager.getTransaction().commit();
        entityManager.clear();
        entityManager.close();

        return rezervasyonList;
    }

    @Override
    public Rezervasyon rezervasyonBul(int id) {

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Rezervasyon rezervasyon = entityManager.find(Rezervasyon.class, id);
        entityManager.getTransaction().commit();
        entityManager.clear();
        entityManager.close();

        return rezervasyon;
    }

    @Override
    public String rezervasyonSil(int id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(rezervasyonBul(id));
        entityManager.getTransaction().commit();
        entityManager.clear();

        return "Basarili";
    }

    @Override
    public String rezervasyonGuncelle(Rezervasyon rezervasyonNewInfo) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Rezervasyon rezervasyon = entityManager.find(Rezervasyon.class,rezervasyonNewInfo.getId());
        rezervasyon.setBaslangicTarihi(rezervasyonNewInfo.getBaslangicTarihi());
        rezervasyon.setBitisTarihi(rezervasyonNewInfo.getBitisTarihi());
        rezervasyon.setMusteriId(rezervasyonNewInfo.getMusteriId());
        rezervasyon.setOdemeYapildi(rezervasyonNewInfo.getOdemeYapildi());

        entityManager.getTransaction().commit();
        entityManager.clear();
        entityManager.close();

        return "Basarili";
    }
}
