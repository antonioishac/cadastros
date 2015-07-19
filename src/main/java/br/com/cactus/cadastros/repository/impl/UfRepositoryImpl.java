package br.com.cactus.cadastros.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cactus.cadastros.model.Uf;
import br.com.cactus.cadastros.model.vo.UfVO;
import br.com.cactus.cadastros.repository.UfRepository;

@Repository("UfRepository")
public class UfRepositoryImpl extends GenericRepositoryImpl<Uf> implements UfRepository {

	@Override
	public List<Uf> listaUf(Integer iDisplayLength, Integer mxResult, UfVO ufVO, String atributo, String ascDesc) {
		
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		jpql.append("SELECT u FROM Uf u");
		
		if (ufVO.getNome() != null) {
			
			jpql.append(" where u.nome like :nome");
			params.put("nome", "%" + ufVO.getNome() + "%");
			
		}
		
		if (ufVO.getSigla() != null) {
		
			jpql.append(" and u.sigla like :sigla");
			params.put("sigla", "%" + ufVO.getSigla() + "%");
			
		}
		
		//jpql.append("order by " + atributo + " " + ascDesc);		
		
		return this.listPesqParam(iDisplayLength, mxResult, jpql.toString(), params);
		
	}
	
	@Override
	public List<Uf> listaUfParam(String nome) {
		
		List<Uf> listaUf = new ArrayList<Uf>();
		
		Query query = this.entityManager.createQuery("Select u FROM Uf u where u.nome like :nome");
		query.setParameter("nome", "%" + nome + "%");
		
		listaUf = query.getResultList();
		
		return listaUf;
		
	}

	@Override
	public int totalUf(UfVO ufVO) {
		
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		jpql.append("SELECT count(u) FROM Uf u");
		
		if (ufVO.getNome() != null) {
			
			jpql.append(" where u.nome like :nome");
			params.put("nome", "%" + ufVO.getNome() + "%");
			
		}
		
		if (ufVO.getSigla() != null) {
		
			jpql.append(" and u.sigla like :sigla");
			params.put("sigla", "%" + ufVO.getSigla() + "%");
			
		}
		
		return this.total(jpql.toString(), params);
		
	}
	
}
