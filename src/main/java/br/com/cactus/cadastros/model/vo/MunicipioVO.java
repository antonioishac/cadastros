package br.com.cactus.cadastros.model.vo;

import br.com.cactus.cadastros.model.Uf;

public class MunicipioVO {
	
	private String nome;
	private Integer codigoIbge;
	private Integer codigoReceitaFederal;
	private Integer codigoEstadual;
	private Uf uf;
	
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
	public Integer getCodigoReceitaFederal() {
		return codigoReceitaFederal;
	}
	public void setCodigoReceitaFederal(Integer codigoReceitaFederal) {
		this.codigoReceitaFederal = codigoReceitaFederal;
	}
	public Integer getCodigoEstadual() {
		return codigoEstadual;
	}
	public void setCodigoEstadual(Integer codigoEstadual) {
		this.codigoEstadual = codigoEstadual;
	}
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
}