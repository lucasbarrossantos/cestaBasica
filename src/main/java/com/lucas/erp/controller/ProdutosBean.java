package com.lucas.erp.controller;

import com.lucas.erp.model.Produto;
import com.lucas.erp.repository.Produtos;
import com.lucas.erp.util.FacesMessages;
import org.primefaces.context.RequestContext;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@ViewScoped
public class ProdutosBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Produtos produtosRepositorio; // Repositório de Produtos
    @Inject
    private FacesMessages messages;
    @Inject
    private Produto prepararProduto;

    private List<Produto> todosProdutos;
    private Produto produtoSelecionado;
    private List<Produto> produtosDaColeta;

    public void consultarProdutos() {
        todosProdutos = produtosRepositorio.produtosParaColeta();
    }

    public void adicionarProdutos() {
        produtosRepositorio.guardar(prepararProduto);
        messages.info("Produto " + prepararProduto.getDescricao() + " Adicionado!");
        prepararProduto = new Produto();
        consultarProdutos();
        RequestContext.getCurrentInstance().update(
                Arrays.asList("frm:itemPanel")
        );
    }

    public List<Produto> getProdutosDaColeta() {
        return produtosRepositorio.produtosParaColeta();
    }


    public Produto getPrepararProduto() {
        return prepararProduto;
    }

    public void setPrepararProduto(Produto prepararProduto) {
        this.prepararProduto = prepararProduto;
    }

    public List<Produto> getTodosProdutos() {
        return todosProdutos;
    }

    public void setTodosProdutos(List<Produto> todosProdutos) {
        this.todosProdutos = todosProdutos;
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public void removerProdutoSelecionado() {
        produtosRepositorio.remover(produtoSelecionado);
        produtoSelecionado = null;
        consultarProdutos();

        messages.info("Produto removido!");
        RequestContext.getCurrentInstance().update(
                Arrays.asList("frm:itensTable", "frm:novoItemToolbar", "fmr:msgs")
        );
    }

}