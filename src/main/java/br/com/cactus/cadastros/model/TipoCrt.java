package br.com.cactus.cadastros.model;

public enum TipoCrt {
	
	FISICA("Física"), JURIDICA("Jurídica");
	
	private String descricao;

	
	TipoCrt(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
