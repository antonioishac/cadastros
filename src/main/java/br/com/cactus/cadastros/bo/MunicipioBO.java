package br.com.cactus.cadastros.bo;

import java.util.List;

import br.com.cactus.cadastros.model.Municipio;
import br.com.cactus.cadastros.model.vo.MunicipioVO;

public interface MunicipioBO extends GenericBO<Municipio> {
	
	public List<Municipio> listaMunicipio(Integer iDisplayLength, Integer mxResult, MunicipioVO municipioVO, String atributo, String ascDesc);
	
	public int totalMunicipio(MunicipioVO municipioVO);

}
