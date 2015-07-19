package br.com.cactus.cadastros.bo;

import java.util.List;

import br.com.cactus.cadastros.model.Uf;
import br.com.cactus.cadastros.model.vo.UfVO;


public interface UfBO extends GenericBO<Uf> {
	
	public List<Uf> listaUf(Integer iDisplayLength, Integer mxResult, UfVO ufVO, String atributo, String ascDesc);
	
	public List<Uf> listaUfParam(String nome);
	
	public int totalUf(UfVO ufVO);

}
