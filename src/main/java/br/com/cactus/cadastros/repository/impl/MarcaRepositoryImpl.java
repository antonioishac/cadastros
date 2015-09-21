package br.com.cactus.cadastros.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.cactus.cadastros.model.Marca;
import br.com.cactus.cadastros.model.vo.MarcaVO;
import br.com.cactus.cadastros.repository.MarcaRepository;

@Repository("marcaRepository")
public class MarcaRepositoryImpl extends GenericRepositoryImpl<Marca> implements MarcaRepository {

	@Override
	public List<Marca> listaMarca(Integer iDisplayLength, Integer mxResult, MarcaVO marcaVO, String atributo, String ascDesc) {
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		if(marcaVO.getNome() == null) {
			marcaVO.setNome("");
		}
		
		if (marcaVO.getNome() != null) {
		
			jpql.append("SELECT m FROM Marca m where m.nome like :nome ");
			params.put("nome", "%" + marcaVO.getNome() + "%");
		}
		
		if (marcaVO.getDescricao() != null) {
		
			jpql.append(" and n.descricao like :descricao");
			
			params.put("descricao", "%" + marcaVO.getDescricao() + "%");
			
		}
		
		//jpql.append("order by " + atributo + " " + ascDesc);		
		
		return this.listPesqParam(iDisplayLength, mxResult, jpql.toString(), params);
	}

	@Override
	public int totalMarca(MarcaVO marcaVO) {
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		if(marcaVO.getNome() == null) {
			marcaVO.setNome("");
		}
		
		if (marcaVO.getNome() != null) {
		
			jpql.append("SELECT m FROM Marca m where m.nome like :nome ");
			params.put("nome", "%" + marcaVO.getNome() + "%");
		}
		
		if (marcaVO.getDescricao() != null) {
		
			jpql.append(" and n.descricao like :descricao");
			
			params.put("descricao", "%" + marcaVO.getDescricao() + "%");
			
		}
		
		return this.total(jpql.toString(), params);
	}

}