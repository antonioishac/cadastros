package br.com.cactus.cadastros.repository;

import java.util.List;

import br.com.cactus.cadastros.model.Marca;
import br.com.cactus.cadastros.model.vo.MarcaVO;

public interface MarcaRepository extends GenericRepository<Marca> {
	
	public List<Marca> listaMarca(Integer iDisplayLength, Integer mxResult, MarcaVO marcaVO, String atributo, String ascDesc);
	
	public int totalMarca(MarcaVO marcaVO);

}
