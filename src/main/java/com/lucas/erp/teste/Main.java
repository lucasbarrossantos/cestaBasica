package com.lucas.erp.teste;


import com.lucas.erp.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        EntityManager em;
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("cestaBasica"); // Here it crashes
        em = fact.createEntityManager();

        List<Produto> produtos = em.createQuery("from Produto ", Produto.class).getResultList();

        em.getTransaction().begin();
        em.createQuery("delete Produto where coleta.id = 1").executeUpdate();
        em.getTransaction().commit();

        em.close();
        fact.close();
    }
}
