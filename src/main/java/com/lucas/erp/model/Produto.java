package com.lucas.erp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Produto extends BaseEntity{
    private static final long serialVersionUID = 1L;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String descricao;


    private String marca;

    @Column(length = 400)
    private String memo;

    @NotNull
    @Min(value = 0)
    @Column(nullable = false)
    private Double preco;

    private String tipo;

    @ManyToOne
    private Coleta coleta;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Coleta getColeta() {
        return coleta;
    }

    public void setColeta(Coleta coleta) {
        this.coleta = coleta;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                ", memo='" + memo + '\'' +
                ", preco=" + preco +
                ", tipo='" + tipo + '\'' +
                ", coleta=" + coleta +
                '}';
    }
}
