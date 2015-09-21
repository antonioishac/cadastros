package br.com.cactus.cadastros.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.cactus.cadastros.model.Ncm;
import br.com.cactus.cadastros.model.vo.NcmVO;
import br.com.cactus.cadastros.repository.NcmRepository;

@Repository("ncmRepository")
public class NcmRepositoryImpl extends GenericRepositoryImpl<Ncm> implements NcmRepository {

	@Override
	public List<Ncm> listaNcm(Integer iDisplayLength, Integer mxResult, NcmVO ncmVO, String atributo, String ascDesc) {
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		if(ncmVO.getCodigo() == null) {
			ncmVO.setCodigo("");
		}	
						
		jpql.append("SELECT n FROM Ncm n where n.codigo like :codigo ");
		params.put("codigo", "%" + ncmVO.getCodigo() + "%");
		
		
		if (ncmVO.getDescricao() != null) {
		
			jpql.append(" and n.descricao like :descricao");
			
			params.put("descricao", "%" + ncmVO.getDescricao() + "%");
			
		}
		
		//jpql.append("order by " + atributo + " " + ascDesc);		
		
		return this.listPesqParam(iDisplayLength, mxResult, jpql.toString(), params);
	}

	@Override
	public int totalNcm(NcmVO ncmVO) {
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		if(ncmVO.getCodigo() == null) {
			ncmVO.setCodigo("");
		}	
		
		jpql.append("SELECT count(n) FROM Ncm n where n.codigo like :codigo");
		params.put("codigo", "%" + ncmVO.getCodigo() + "%");
			
				
		if (ncmVO.getDescricao() != null) {
		
			jpql.append(" and n.descricao like :descricao");
			params.put("descricao", "%" + ncmVO.getDescricao() + "%");
			
		}
		
		return this.total(jpql.toString(), params);
	}

	@Override
	public List<Ncm> buscaNcmAntesCadastro(String codigo) {
		
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
				
		jpql.append("SELECT n FROM Ncm n where n.codigo = :codigo ");
		params.put("codigo", codigo);
		
		return this.listPesqParam(jpql.toString(), params);
	}
}