package com.lucas.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.lucas.erp.model.Empresa;
import com.lucas.erp.util.Transacional;

public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;


    public Empresa porId(Long id) {
        return manager.find(Empresa.class, id);
    }

    public List<Empresa> todas() {
        return manager.createQuery("from Empresa", Empresa.class).getResultList();
    }

    @Transacional
    public void guardar(Empresa empresa) {
        if (empresa.isPersisted()) {
            manager.merge(empresa);
        } else
            manager.persist(empresa);
    }

    @Transacional
    public void remover(Empresa empresa) {
        empresa = porId(empresa.getId());
        manager.remove(empresa);
    }

}