package dao.impl;

import dao.BucketDao;
import domain.Bucket;
import shared.FactoryManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class BucketDaoImpl implements BucketDao {
    private EntityManager em = FactoryManager.getEntityManager();

    @Override
    public Bucket create(Bucket bucket) {
        try {
            em.getTransaction().begin();
            em.persist(bucket);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bucket;
    }

    @Override
    public Bucket read(Integer id) {
        return null;
    }

    @Override
    public Bucket read(String id) {
        Bucket bucket = null;
        try {
            bucket = em.find(Bucket.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bucket;
    }

    @Override
    public Bucket update(Bucket t) {
        throw new IllegalStateException("there is no update for bucket");
    }

    @Override
    public void delete(Integer id) {
        try {
            Bucket bucket = read(id);
            em.getTransaction().begin();
            em.remove(bucket);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Bucket> readAll() {
        Query query = null;
        try {
            query = em.createQuery("SELECT e FROM Bucket e");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return query.getResultList();
    }
}