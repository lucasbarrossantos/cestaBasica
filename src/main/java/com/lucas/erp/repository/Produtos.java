package com.lucas.erp.repository;

import com.lucas.erp.model.Produto;
import com.lucas.erp.util.Transacional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;


    public Produto porId(Long id) {
        return manager.find(Produto.class, id);
    }

    public List<Produto> todas() {
        return manager.createQuery("from Produto ", Produto.class).getResultList();
    }

    @Transacional
    public void guardar(Produto produto) {
        if (produto.isPersisted()) {
            manager.merge(produto);
        } else
            manager.persist(produto);
    }

    @Transacional
    public void remover(Produto produto) {
        produto = porId(produto.getId());
        manager.remove(produto);
    }

    @Transacional
    public void guardar(List<Produto> produtos) {
        for (Produto p : produtos) {
            if (p.isPersisted())
                manager.merge(p);
            else
                manager.persist(p);
        }
    }

    public List<Produto> produtosParaColeta() {

        String sql = "from Produto where coleta.id is null ";

        Query query = manager.createQuery(sql);

        return (List<Produto>) query.getResultList();
    }
}
