package com.lucas.erp.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
public class Coleta extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(nullable = false)
    private String coletadoEm;

    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDaColeta;

    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaDaColeta;

    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date duracaoDaColeta;

    private Integer qtdColetada;

    @NotNull
    @Column(nullable = false)
    private String responsavel;

    @OneToMany(mappedBy = "coleta")
    private List<Produto> produtos;

    public String getColetadoEm() {
        return coletadoEm;
    }

    public void setColetadoEm(String coletadoEm) {
        this.coletadoEm = coletadoEm;
    }


    public Integer getQtdColetada() {
        return qtdColetada;
    }

    public void setQtdColetada(Integer qtdColetada) {
        this.qtdColetada = qtdColetada;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Date getDataDaColeta() {
        return dataDaColeta;
    }

    public void setDataDaColeta(Date dataDaColeta) {
        this.dataDaColeta = dataDaColeta;
    }

    public Date getHoraDaColeta() {
        return horaDaColeta;
    }

    public void setHoraDaColeta(Date horaDaColeta) {
        this.horaDaColeta = horaDaColeta;
    }

    public Date getDuracaoDaColeta() {
        return duracaoDaColeta;
    }

    public void setDuracaoDaColeta(Date duracaoDaColeta) {
        this.duracaoDaColeta = duracaoDaColeta;
    }

    @Override
    public String toString() {
        return "Coleta{" +
                "coletadoEm='" + coletadoEm + '\'' +
                ", dataDaColeta=" + dataDaColeta +
                ", horaDaColeta=" + horaDaColeta +
                ", duracaoDaColeta=" + duracaoDaColeta +
                ", qtdColetada=" + qtdColetada +
                ", responsavel='" + responsavel + '\'' +
                '}';
    }
}
