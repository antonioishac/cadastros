package br.com.cactus.cadastros.model;

public enum TipoTelefone {
	
	RESIDENCIAL("1 - Residencial"), 
	COMERCIAL(" 2 - Comercial"), 
	CELULAR("3 - Celular"), 
	OUTRO("4 - Outro");
	
	private String descricao;

	TipoTelefone(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
