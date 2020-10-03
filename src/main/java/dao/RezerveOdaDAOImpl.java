package main.java.dao;

import main.java.model.RezerveOda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RezerveOdaDAOImpl implements  RezerveOdaDAO{

    private static final EntityManagerFactory emFactoryObj;
    private static final String PERSISTENCE_UNIT_NAME = "OtelRezervasyon";

    static {
        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }

    @Override
    public String rezerveOdaKayit(RezerveOda rezerveOda) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(rezerveOda);
        entityManager.getTransaction().commit();

        entityManager.clear();
        entityManager.close();
        return "Basarili";
    }

    @Override
    public List<RezerveOda> rezerveOdaListele(RezerveOda rezervasyon) {

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RezerveOda> criteria = cb.createQuery(RezerveOda.class);
        Root<RezerveOda> root = criteria.from(RezerveOda.class);

        criteria.where(

        );

        List<RezerveOda> rezerveOdaList = entityManager.createQuery(criteria).getResultList();
        entityManager.clear();
        entityManager.close();
        return rezerveOdaList;
    }

    @Override
    public RezerveOda rezerveOdaBul(int id) {

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        RezerveOda rezerveOda = entityManager.find(RezerveOda.class, id);
        entityManager.getTransaction().commit();

        entityManager.clear();
        entityManager.close();

        return rezerveOda;

    }

    @Override
    public String rezerveOdaSil(int id) {

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(rezerveOdaBul(id));
        entityManager.getTransaction().commit();
        entityManager.clear();
        entityManager.close();

        return "Basarili";


    }

    @Override
    public String rezerveOdaGuncelle(RezerveOda rezerveOdaNewInfo) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        RezerveOda rezerveOda = entityManager.find(RezerveOda.class, rezerveOdaNewInfo.getId());
        rezerveOda.setOdaId(rezerveOdaNewInfo.getOdaId());
        rezerveOda.setRezervasyonDurumu(rezerveOdaNewInfo.getRezervasyonDurumu());
        rezerveOdaNewInfo.setRezervasyonId(rezerveOdaNewInfo.getRezervasyonId());

        entityManager.clear();
        entityManager.close();
        return "Basarili";
    }
}
