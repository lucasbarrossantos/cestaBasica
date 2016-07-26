package com.lucas.erp.teste;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManager em;
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("cestaBasica"); // Here it crashes
        em = fact.createEntityManager();
    }
}
