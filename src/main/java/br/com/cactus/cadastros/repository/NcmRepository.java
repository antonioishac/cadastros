package br.com.cactus.cadastros.repository;

import java.util.List;

import br.com.cactus.cadastros.model.Ncm;
import br.com.cactus.cadastros.model.vo.NcmVO;

public interface NcmRepository extends GenericRepository<Ncm> {
	
	public List<Ncm> listaNcm(Integer iDisplayLength, Integer mxResult, NcmVO ncmVO, String atributo, String ascDesc);
	
	public int totalNcm(NcmVO ncmVO);
	
	public List<Ncm> buscaNcmAntesCadastro(String codigo);

}
