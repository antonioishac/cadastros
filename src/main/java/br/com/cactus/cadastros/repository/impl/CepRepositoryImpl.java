package br.com.cactus.cadastros.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.cactus.cadastros.model.Cep;
import br.com.cactus.cadastros.model.vo.CepVO;
import br.com.cactus.cadastros.repository.CepRepository;

@Repository("cepRepository")
public class CepRepositoryImpl extends GenericRepositoryImpl<Cep> implements CepRepository {

	@Override
	public List<Cep> listaCep(Integer iDisplayLength, Integer mxResult, CepVO cepVO, String atributo, String ascDesc) {
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		jpql.append("SELECT c FROM Cep c");
		
		if (cepVO.getLogradouro() != null) {
			
			jpql.append(" where c.logradouro like :logradouro");
			params.put("logradouro", "%" + cepVO.getLogradouro() + "%");
			
		}
		
		//jpql.append("order by " + atributo + " " + ascDesc);		
		
		return this.listPesqParam(iDisplayLength, mxResult, jpql.toString(), params);
	}

	@Override
	public int totalCep(CepVO cepVO) {
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		jpql.append("SELECT count(c) FROM Cep c");
		
		if (cepVO.getLogradouro() != null) {
			
			jpql.append(" where c.logradouro like :logradouro");
			params.put("logradouro", "%" + cepVO.getLogradouro() + "%");
			
		}
		
		return this.total(jpql.toString(), params);
	}

}
