package com.lucas.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.lucas.erp.model.Empresa;
import com.lucas.erp.repository.Empresas;
import com.lucas.erp.util.Transacional;

public class CadastroEmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;

	//@Transacional
	//public void salvar(Empresa empresa) {
	//	empresas.guardar(empresa);
	//}

	@Transacional
	public void excluir(Empresa empresa) {
		if (empresa.getId() != null)
		empresas.remover(empresa);
	}

}