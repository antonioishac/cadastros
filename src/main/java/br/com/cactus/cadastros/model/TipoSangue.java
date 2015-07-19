package br.com.cactus.cadastros.model;

public enum TipoSangue {
	
	O_POSITIVO("O Positivo"), O_NEGATIVO("O Negativo");
	
	private String descricao;

	TipoSangue(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
