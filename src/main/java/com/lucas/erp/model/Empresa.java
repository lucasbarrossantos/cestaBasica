package com.lucas.erp.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
public class Empresa extends BaseEntity{

	@NotEmpty
	@Column(name = "nome_fantasia", nullable = false, length = 80)
	private String nomeFantasia;

	@NotEmpty
	@Column(name = "razao_social", nullable = false, length = 120)
	private String razaoSocial;

	@NotEmpty
	@CNPJ
	@Column(nullable = false, length = 18)
	private String cnpj;

	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name = "data_fundacao")
	private Date dataFundacao;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoEmpresa tipo;

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public TipoEmpresa getTipo() {
		return tipo;
	}

	public void setTipo(TipoEmpresa tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Empresa{" +
				"nomeFantasia='" + nomeFantasia + '\'' +
				", razaoSocial='" + razaoSocial + '\'' +
				", cnpj='" + cnpj + '\'' +
				", dataFundacao=" + dataFundacao +
				", tipo=" + tipo +
				'}';
	}
}