package br.com.cactus.cadastros.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import br.com.cactus.cadastros.repository.GenericRepository;

public class GenericRepositoryImpl<T> implements GenericRepository<T> {
	
	@PersistenceContext
	protected EntityManager entityManager;
	private final Class<T> oClass;
	
	@SuppressWarnings("unchecked")
	public GenericRepositoryImpl() {
		this.oClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getObjectClass() {
		return this.oClass;
	}
	
	
	@Transactional
	public T salvar(T object) {
		entityManager.clear();
		entityManager.persist(object);
		return object;
	}
	
	public T pesquisarPorId(Integer id) {
		return (T) entityManager.find(oClass, id);
	}

	@Transactional
	public T atualizar(T object) {
		return entityManager.merge(object);		
	}

	@Transactional
	public void excluir(T object) {
		object = entityManager.merge(object);
		entityManager.remove(object);
		entityManager.flush();
	}

	@Override
	public List<T> todos() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(oClass);
		Root<T> root = cq.from(oClass);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> listPesqParam(Integer iDisplayLength, Integer mxResult, String query, Map<String, Object> params) {
		Query q = entityManager.createQuery(query);
		
		for (String chave : params.keySet()) {
			q.setParameter(chave, params.get(chave));
		}
		
		q.setFirstResult(iDisplayLength);
        q.setMaxResults(mxResult);
		
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listPesqParam(String query, Map<String, Object> params) {
		Query q = entityManager.createQuery(query);
		
		for (String chave : params.keySet()) {
			q.setParameter(chave, params.get(chave));
		}		
				
		return q.getResultList();
	}

	
	@SuppressWarnings("unchecked")
	public List<T> listPesq(String query) {
		Query q = entityManager.createQuery(query);
		return q.getResultList();
	}

	
	@SuppressWarnings("unchecked")
	public T pesqParam(String query, Map<String, Object> params) {
		Query q = entityManager.createQuery(query);

		for (String chave : params.keySet()) {
			q.setParameter(chave, params.get(chave));
		}

		try {
			return (T) q.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	@Override
	public int total(String query, Map<String, Object> params) {
		
		Query q = entityManager.createQuery(query);
		
		for (String chave : params.keySet()) {
			q.setParameter(chave, params.get(chave));
		}
		
		int count = ((Long) q.getSingleResult()).intValue();
		
		return count;
		
	}	

}
