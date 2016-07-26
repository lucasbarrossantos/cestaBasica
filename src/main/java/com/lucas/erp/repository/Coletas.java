package com.lucas.erp.repository;

import com.lucas.erp.model.Coleta;
import com.lucas.erp.model.Produto;
import com.lucas.erp.util.Transacional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class Coletas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Coleta porId(Long id) {
        return manager.find(Coleta.class, id);
    }

    public List<Coleta> todas() {
        return manager.createQuery("from Coleta", Coleta.class).getResultList();
    }

    @Transacional
    public void guardar(Coleta coleta) {
        if (coleta.isPersisted()) {
            manager.merge(coleta);
        } else
            manager.persist(coleta);
    }

    @Transacional
    public void remover(Coleta coleta) {
        coleta = porId(coleta.getId());
        manager.remove(coleta);
    }

    public List<Produto> produtosDaColeta(Coleta coleta) {

        String sql = "from Produto  where id = :id";

        Query query = manager.createQuery(sql).setParameter("id", coleta.getId());

        return (List<Produto>) query.getResultList();
    }
}
