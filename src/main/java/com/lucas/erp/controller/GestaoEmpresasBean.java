package com.lucas.erp.controller;

import com.lucas.erp.model.Empresa;
import com.lucas.erp.model.TipoEmpresa;
import com.lucas.erp.repository.Empresas;
import com.lucas.erp.service.CadastroEmpresaService;
import com.lucas.erp.util.FacesMessages;
import org.primefaces.context.RequestContext;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@ViewScoped // javax.faces.view Compatível com CDI
public class GestaoEmpresasBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresas empresas; // Repositorio de Empresas

    @Inject
    private FacesMessages messages;

    private List<Empresa> todasEmpresas;
    private Empresa empresaEdicao;
    private Empresa empresaSelecionada;

    public GestaoEmpresasBean(){
        empresaEdicao = new Empresa();
    }

    public void prepararNovoCadastro() {
        empresaEdicao = new Empresa();
    }

    public void salvar() {
        empresas.guardar(empresaEdicao);
        consultar();

        messages.info("Empresa salva com sucesso!");

        RequestContext.getCurrentInstance().update(
                Arrays.asList("frm:msgs", "frm:empresas-table") // ids dos componentes
        );

    }

    public void excluir() {
        empresas.remover(empresaSelecionada);
        empresaSelecionada = null;
        consultar();

        messages.info("Empresa removida com sucesso!");

        RequestContext.getCurrentInstance().update(
                Arrays.asList("frm:msgs", "frm:empresas-table") // ids dos componentes
        );
    }

    public void consultar() {
        todasEmpresas = empresas.todas();
    }

    public List<Empresa> getTodasEmpresas() {
        return todasEmpresas;
    }

    public TipoEmpresa[] getTiposEmpresas() {
        return TipoEmpresa.values();
    }

    public Empresa getEmpresaEdicao() {
        return empresaEdicao;
    }

    public void setEmpresaEdicao(Empresa empresaEdicao) {
        this.empresaEdicao = empresaEdicao;
    }

    public Empresa getEmpresaSelecionada() {
        return empresaSelecionada;
    }

    public void setEmpresaSelecionada(Empresa empresaSelecionada) {
        this.empresaSelecionada = empresaSelecionada;
    }
}
