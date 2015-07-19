package br.com.cactus.cadastros.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLANO_CONTA_REF_SPED")
public class PlanoContaRefSped implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String codCtaRef;
	private String descricao;
	private String orientacoes;
	private Date inicioValidade;
	private Date fimValidade;
	private String tipo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "COD_CTA_REF", nullable = false, length = 30)
	public String getCodCtaRef() {
		return codCtaRef;
	}
	
	public void setCodCtaRef(String codCtaRef) {
		this.codCtaRef = codCtaRef;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getOrientacoes() {
		return orientacoes;
	}
	
	public void setOrientacoes(String orientacoes) {
		this.orientacoes = orientacoes;
	}
	
	@Column(name = "INICIO_VALIDADE")
	public Date getInicioValidade() {
		return inicioValidade;
	}
	
	public void setInicioValidade(Date inicioValidade) {
		this.inicioValidade = inicioValidade;
	}
	
	@Column(name = "FIM_VALIDADE")
	public Date getFimValidade() {
		return fimValidade;
	}
	
	public void setFimValidade(Date fimValidade) {
		this.fimValidade = fimValidade;
	}
	
	@Column(nullable = false, length = 1)
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		PlanoContaRefSped other = (PlanoContaRefSped) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
