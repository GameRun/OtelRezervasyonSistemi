package main.java.dao;

import main.java.model.Oda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OdaDAOImpl implements  OdaDAO{


    private static final EntityManagerFactory emFactoryObj;
    private static final String PERSISTENCE_UNIT_NAME = "OtelRezervasyon";

    static {
        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }

    @Override
    public String odaKayit(Oda oda) {

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(oda);
        entityManager.getTransaction().commit();

        entityManager.clear();
        entityManager.close();


        return "Basarili";
    }

    @Override
    public List<Oda> odaListele(Oda oda) {

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Oda> criteria = cb.createQuery(Oda.class);
        Root<Oda> root = criteria.from(Oda.class);

        criteria.where();

        List<Oda> musteriList = entityManager.createQuery(criteria).getResultList();

        entityManager.getTransaction().commit();
        entityManager.clear();
        entityManager.close();

        return musteriList;
    }

    @Override
    public Oda odaBul(int id) {

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Oda oda = entityManager.find(Oda.class, id);
        entityManager.getTransaction().commit();
        entityManager.clear();
        entityManager.close();

        return oda;
    }

    @Override
    public String odaSil(int id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(odaBul(id));
        entityManager.getTransaction().commit();
        getEntityManager().clear();
        getEntityManager().close();

        return null;
    }

    @Override
    public String odaGuncelle(Oda odaNewInfo) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Oda oda = entityManager.find(Oda.class, odaNewInfo.getId());
        oda.setOdaDurumu(odaNewInfo.getOdaDurumu());
        oda.setOdaIsmi(odaNewInfo.getOdaIsmi());
        oda.setOdaNumarasi(odaNewInfo.getOdaNumarasi());
        oda.setOtelId(odaNewInfo.getOtelId());

        entityManager.getTransaction().commit();
        entityManager.clear();
        entityManager.close();

        return "Basarili";
    }
}
