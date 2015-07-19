package br.com.cactus.cadastros.bo.impl;

import java.util.List;

import javax.persistence.RollbackException;

import br.com.cactus.cadastros.bo.GenericBO;
import br.com.cactus.cadastros.repository.GenericRepository;

public class GenericBOImpl<T> implements GenericBO<T> {
	
	protected GenericRepository<T> crud;

	@Override
	public T salvar(T obj) {
		this.crud.salvar(obj);		
		return obj;
	}

	@Override
	public void atualizar(T obj) {
		this.crud.atualizar(obj);		
	}

	@Override
	public void excluir(T obj) {
		try {
            this.crud.excluir(obj);
        } catch (RollbackException ex) {
            ex.getStackTrace();
        } catch (Exception ex) {
            ex.getStackTrace();
        }		
	}

	@Override
	public T pesquisarPorId(Integer id) {
		return this.crud.pesquisarPorId(id);
	}

	@Override
	public List<T> todos() {
		return this.crud.todos();
	}

}
