package br.com.cactus.cadastros.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cactus.cadastros.bo.PaisBO;
import br.com.cactus.cadastros.model.Pais;
import br.com.cactus.cadastros.model.vo.PaisVO;
import br.com.cactus.cadastros.repository.GenericRepository;
import br.com.cactus.cadastros.repository.PaisRepository;

@Service
public class PaisBOImpl extends GenericBOImpl<Pais> implements PaisBO {
	
	@Autowired
	private PaisRepository paisRepository;
			
	@Autowired
	public PaisBOImpl(GenericRepository<Pais> paisRepository) {
		this.crud = paisRepository;
	}

	@Override
	public List<Pais> listaPais(Integer iDisplayLength, Integer mxResult, PaisVO paisVO, String atributo, String ascDesc) {

		return paisRepository.listaPais(iDisplayLength, mxResult, paisVO, atributo, ascDesc);
		
	}

	@Override
	public int totalPais(PaisVO paisVO) {
				
		return paisRepository.totalPais(paisVO);
	}
	
}
