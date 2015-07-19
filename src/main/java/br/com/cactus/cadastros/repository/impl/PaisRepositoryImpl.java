package br.com.cactus.cadastros.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.cactus.cadastros.model.Pais;
import br.com.cactus.cadastros.model.vo.PaisVO;
import br.com.cactus.cadastros.repository.PaisRepository;

@Repository("paisRepository")
public class PaisRepositoryImpl extends GenericRepositoryImpl<Pais> implements PaisRepository {

	@Override
	public List<Pais> listaPais(Integer iDisplayLength, Integer mxResult, PaisVO paisVO, String atributo, String ascDesc) {
		
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		jpql.append("SELECT p FROM Pais p");
		
		if (paisVO.getNome() != null) {
			
			jpql.append(" where p.nomePtBr like :nomePtBr");
			params.put("nomePtBr", "%" + paisVO.getNome() + "%");
			
		}
		
		if (paisVO.getCodigo() != null) {
		
			jpql.append(" and p.codigo = :codigo");
			params.put("codigo", paisVO.getCodigo());
			
		}
		
		//jpql.append("order by " + atributo + " " + ascDesc);		
		
		return this.listPesqParam(iDisplayLength, mxResult, jpql.toString(), params);
		
	}

	@Override
	public int totalPais(PaisVO paisVO) {
		
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		jpql.append("SELECT count(p) FROM Pais p");
		
		if (paisVO.getNome() != null) {
			
			jpql.append(" where p.nomePtBr like :nomePtBr");
			params.put("nomePtBr", "%" + paisVO.getNome() + "%");
			
		}
		
		if (paisVO.getCodigo() != null) {
		
			jpql.append(" and p.codigo = :codigo");
			params.put("codigo", paisVO.getCodigo());
			
		}
		
		return this.total(jpql.toString(), params);
		
	}
	
}
