package br.com.cactus.cadastros.model;

public enum TipoRegime {
	
	NORMAL("Normal");
	
	private String descricao;

	TipoRegime(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
