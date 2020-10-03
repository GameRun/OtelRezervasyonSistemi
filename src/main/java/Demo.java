package main.java;

import main.java.business.facede.BusinessFacede;
import main.java.business.facede.BusinessFacedeImpl;
import main.java.model.Musteri;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class Demo {

    private static final EntityManagerFactory emFactoryObj;
    private static final String PERSISTENCE_UNIT_NAME = "OtelRezervasyon";

    static {
        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    // This Method Is Used To Retrieve The 'EntityManager' Object
    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }

    public static void main(String[] args) {


        BusinessFacede businessFacede = new BusinessFacedeImpl();
        System.out.println(businessFacede.musteriBul(1).toString());



    }

    private static void copBilgi() {
        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();

        CriteriaBuilder cb =  entityMgr.getCriteriaBuilder();

        CriteriaQuery<Musteri> criteria =  cb.createQuery(Musteri.class);
        Root<Musteri> root = criteria.from(Musteri.class);


        Predicate name = cb.equal(root.get("adi"), "ttt");
        criteria.where(name);

//        criteria.where(
//                cb.equal(root.get("adi"), "ttt"),
//                cb.equal(root.get("soyadi"), "eeee")
//        );


        List<Musteri> musteriList = entityMgr.createQuery(criteria).getResultList();

        Musteri musteri = musteriList.get(0);

        musteri.setEvlilikDurumu("E");


        System.out.println("1");
        entityMgr.getTransaction().commit();
    }

    private static void insert() {
        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();

        Musteri musteri = new Musteri();
        musteri.setAdi("ttt");
        musteri.setSoyadi("güeengüt");
        musteri.setCinsiyet("E");
        musteri.setDogumtarihi("07062020");
        musteri.setEvlilikDurumu("B");

        entityMgr.persist(musteri);


        entityMgr.getTransaction().commit();


        entityMgr.clear();
        System.out.println("Record Successfully Inserted In The Database");
    }

}

