package br.com.cactus.cadastros.repository;

import java.util.List;

import br.com.cactus.cadastros.model.Municipio;
import br.com.cactus.cadastros.model.vo.MunicipioVO;

public interface MunicipioRepository extends GenericRepository<Municipio> {
	
	public List<Municipio> listaMunicipio(Integer iDisplayLength, Integer mxResult, MunicipioVO municipioVO, String atributo, String ascDesc);
	
	public int totalMunicipio(MunicipioVO municipioVO);
		
}
