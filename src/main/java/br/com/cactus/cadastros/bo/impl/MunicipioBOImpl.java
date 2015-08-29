package br.com.cactus.cadastros.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cactus.cadastros.bo.MunicipioBO;
import br.com.cactus.cadastros.model.Municipio;
import br.com.cactus.cadastros.model.vo.MunicipioVO;
import br.com.cactus.cadastros.repository.GenericRepository;
import br.com.cactus.cadastros.repository.MunicipioRepository;

@Service
public class MunicipioBOImpl extends GenericBOImpl<Municipio> implements MunicipioBO {
	
	@Autowired
	private MunicipioRepository municipioRepository;
			
	@Autowired
	public MunicipioBOImpl(GenericRepository<Municipio> municipioRepository) {
		this.crud = municipioRepository;
	}

	@Override
	public List<Municipio> listaMunicipio(Integer iDisplayLength, Integer mxResult, MunicipioVO municipioVO, String atributo, String ascDesc) {

		return municipioRepository.listaMunicipio(iDisplayLength, mxResult, municipioVO, atributo, ascDesc);
		
	}

	@Override
	public int totalMunicipio(MunicipioVO municipioVO) {
				
		return municipioRepository.totalMunicipio(municipioVO);
	}
	
}
