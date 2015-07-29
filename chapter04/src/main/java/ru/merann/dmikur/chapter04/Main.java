package ru.merann.dmikur.chapter04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by manya on 28.07.2015.
 */
public class Main {
    public static void main(String[] args) {
        Book book = new Book("H2G2", "Автостопом по галактике", 12.5F, "1-84023-742-2", 354, false);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(book);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
