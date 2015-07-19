package br.com.cactus.cadastros.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRIBUT_OPERACAO_FISCAL")
public class OperacaoFiscal implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	private String descricaoNaNf;
	private Integer cfop;
	private String observacao;	
	private Empresa empresa;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "DESCRICAO_NA_NF")
	public String getDescricaoNaNf() {
		return descricaoNaNf;
	}

	public void setDescricaoNaNf(String descricaoNaNf) {
		this.descricaoNaNf = descricaoNaNf;
	}

	@Column(nullable = false, length = 10)
	public Integer getCfop() {
		return cfop;
	}

	public void setCfop(Integer cfop) {
		this.cfop = cfop;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID")
    @ManyToOne
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperacaoFiscal other = (OperacaoFiscal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
