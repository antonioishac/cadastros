package br.com.cactus.cadastros.model;

public enum TipoRaca {
	
	BRANCO("Branco"), PARDO("Pardo"), AFRO_DESCENDENTE("Afro Descendente");
	
	private String descricao;

	TipoRaca(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
