package br.com.cactus.cadastros.repository;

import java.util.List;
import java.util.Map;

public interface GenericRepository<T> {
	
	public Class<T> getObjectClass();

    public T salvar(T object);

    public T pesquisarPorId(Integer id);

    public T atualizar(T object);    
    
    public void excluir(T object);

    public List<T> todos();  
    
    public int total(String query, Map<String, Object> params);
            
    public List<T> listPesqParam(Integer iDisplayLength, Integer mxResult, String query, Map<String, Object> params);
    
    public List<T> listPesqParam(String query, Map<String, Object> params);
    
    public List<T> listPesq(String query);

    public T pesqParam(String query, Map<String, Object> params);

}
