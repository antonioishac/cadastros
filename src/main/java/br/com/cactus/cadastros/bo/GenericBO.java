package br.com.cactus.cadastros.bo;

import java.util.List;

//INTERFACE BO GENERICA

public interface GenericBO<T> {
	
	T salvar(T obj);

    void atualizar(T obj);

    void excluir(T obj);
    
    public T pesquisarPorId(Integer id);
    
    public List<T> todos();    

}
