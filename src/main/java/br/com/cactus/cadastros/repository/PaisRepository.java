package br.com.cactus.cadastros.repository;

import java.util.List;

import br.com.cactus.cadastros.model.Pais;
import br.com.cactus.cadastros.model.vo.PaisVO;

public interface PaisRepository extends GenericRepository<Pais> {
	
	public List<Pais> listaPais(Integer iDisplayLength, Integer mxResult, PaisVO paisVO, String atributo, String ascDesc);
	
	public int totalPais(PaisVO paisVO);
		
}
