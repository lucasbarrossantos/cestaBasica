package com.lucas.erp.controller;

import com.lucas.erp.model.Coleta;
import com.lucas.erp.model.Produto;
import com.lucas.erp.repository.Coletas;
import com.lucas.erp.repository.Produtos;
import com.lucas.erp.util.FacesMessages;
import org.primefaces.context.RequestContext;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named
@ViewScoped
public class ColetasBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Coletas coletasRepositorio;
    @Inject
    private FacesMessages messages;


    @Inject
    private Coleta coleta;
    @Inject
    private Produtos produtos;

    private List<Coleta> todasColetas;
    private Coleta coletaSelecionada;

    public void consultar() {
        todasColetas = coletasRepositorio.todas();
    }


    public void abrirDialogo() {
        Map<String, Object> opcoes = new HashMap<>();
        opcoes.put("modal", true);
        opcoes.put("resizable", false);
        opcoes.put("contentHeight", 530);

        RequestContext.getCurrentInstance().openDialog("Produtos", opcoes, null);
    }

    public void salvar() {
        List<Produto> p = new ArrayList<>();
        for (Produto produto : produtos.produtosParaColeta()) {
            produto.setColeta(coleta);
            p.add(produto);
        }

        coleta.setProdutos(p);
        coleta.setQtdColetada(p.size());
        coletasRepositorio.guardar(coleta);
        produtos.guardar(p);
        coleta = new Coleta();
        consultar();
        RequestContext.getCurrentInstance().closeDialog(coleta);
    }

    public void updateColeta() {
        messages.info("Coleta Salva!");
        consultar();
        RequestContext.getCurrentInstance().update(
                Arrays.asList("fmain:msgs", "fmain:coletas-table")
        );
    }

    public ColetasBean() {
        coleta = new Coleta();
        //todosOsProtudos = coletasRepositorio.produtosDaColeta();
    }
 
    public Coleta getColeta() {
        return coleta;
    }

    public void setColeta(Coleta coleta) {
        this.coleta = coleta;
    }

    public List<Coleta> getTodasColetas() {
        return todasColetas;
    }

    public void setTodasColetas(List<Coleta> todasColetas) {
        this.todasColetas = todasColetas;
    }


    public void remover(){
        coletasRepositorio.remover(coletaSelecionada);
        coletaSelecionada = null;
        consultar();
        messages.info("Coleta removida!");
        RequestContext.getCurrentInstance().update(
                Arrays.asList("fmain:msgs", "fmain:coletas-table", "fmain:toolbar")
        );
    }

    public Coleta getColetaSelecionada() {
        return coletaSelecionada;
    }

    public void setColetaSelecionada(Coleta coletaSelecionada) {
        this.coletaSelecionada = coletaSelecionada;
    }

    public List<Produto> todosOsProtudos(Coleta coleta) {
        return coletasRepositorio.produtosDaColeta(coleta);
    }

}