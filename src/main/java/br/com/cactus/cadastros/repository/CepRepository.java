package br.com.cactus.cadastros.repository;

import java.util.List;

import br.com.cactus.cadastros.model.Cep;
import br.com.cactus.cadastros.model.vo.CepVO;

public interface CepRepository extends GenericRepository<Cep> {
	
	public List<Cep> listaCep(Integer iDisplayLength, Integer mxResult, CepVO cepVO, String atributo, String ascDesc);
	
	public int totalCep(CepVO cepVO);

}
