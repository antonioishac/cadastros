package br.com.cactus.cadastros.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.cactus.cadastros.model.Municipio;
import br.com.cactus.cadastros.model.vo.MunicipioVO;
import br.com.cactus.cadastros.repository.MunicipioRepository;

@Repository("municipioRepository")
public class MunicipioRepositoryImpl extends GenericRepositoryImpl<Municipio> implements MunicipioRepository {

	@Override
	public List<Municipio> listaMunicipio(Integer iDisplayLength, Integer mxResult, MunicipioVO municipioVO, String atributo, String ascDesc) {
		
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		if(municipioVO.getNome() == null) {
			municipioVO.setNome("");
		}	
						
		jpql.append("SELECT m FROM Municipio m where m.nome like :nome ");
		params.put("nome", "%" + municipioVO.getNome() + "%");
		
		
		if (municipioVO.getUf() != null) {
		
			jpql.append(" and m.uf.nome like :uf");
			
			params.put("uf", "%" + municipioVO.getUf().getNome() + "%");
			
		}
		
		//jpql.append("order by " + atributo + " " + ascDesc);		
		
		return this.listPesqParam(iDisplayLength, mxResult, jpql.toString(), params);
		
	}

	@Override
	public int totalMunicipio(MunicipioVO municipioVO) {
		
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		if(municipioVO.getNome() == null) {
			municipioVO.setNome("");
		}	
		
		jpql.append("SELECT count(m) FROM Municipio m where m.nome like :nome");
		params.put("nome", "%" + municipioVO.getNome() + "%");
			
				
		if (municipioVO.getUf() != null) {
		
			jpql.append(" and m.uf.nome like :uf");
			params.put("uf", "%" + municipioVO.getUf().getNome() + "%");
			
		}
		
		return this.total(jpql.toString(), params);
		
	}
	
}
