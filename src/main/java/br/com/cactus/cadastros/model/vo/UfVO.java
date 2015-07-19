package br.com.cactus.cadastros.model.vo;

import br.com.cactus.cadastros.model.Pais;

public class UfVO {
	
	private Pais pais;
	private String sigla;
	private String nome;
	private Integer codigoIbge;
	
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCodigoIbge() {
		return codigoIbge;
	}
	public void setCodigoIbge(Integer codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

}
