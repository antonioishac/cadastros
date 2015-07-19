package br.com.cactus.cadastros.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cactus.cadastros.bo.UfBO;
import br.com.cactus.cadastros.model.Uf;
import br.com.cactus.cadastros.model.vo.UfVO;
import br.com.cactus.cadastros.repository.GenericRepository;
import br.com.cactus.cadastros.repository.UfRepository;

@Service
public class UfBOImpl extends GenericBOImpl<Uf> implements UfBO {
	
	@Autowired
	private UfRepository ufRepository;
			
	@Autowired
	public UfBOImpl(GenericRepository<Uf> ufRepository) {
		this.crud = ufRepository;
	}

	@Override
	public List<Uf> listaUf(Integer iDisplayLength, Integer mxResult, UfVO ufVO, String atributo, String ascDesc) {

		return ufRepository.listaUf(iDisplayLength, mxResult, ufVO, atributo, ascDesc);
		
	}

	@Override
	public int totalUf(UfVO ufVO) {
				
		return ufRepository.totalUf(ufVO);
	}

	@Override
	public List<Uf> listaUfParam(String nome) {
		
		return ufRepository.listaUfParam(nome);
		
	}
	
}
