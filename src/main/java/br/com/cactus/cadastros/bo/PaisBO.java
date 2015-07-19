package br.com.cactus.cadastros.bo;

import java.util.List;

import br.com.cactus.cadastros.model.Pais;
import br.com.cactus.cadastros.model.vo.PaisVO;

public interface PaisBO extends GenericBO<Pais> {
	
	public List<Pais> listaPais(Integer iDisplayLength, Integer mxResult, PaisVO paisVO, String atributo, String ascDesc);
	
	public int totalPais(PaisVO paisVO);

}
