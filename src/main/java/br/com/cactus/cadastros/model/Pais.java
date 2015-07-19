package br.com.cactus.cadastros.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAIS")
public class Pais implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	private Integer id;
	private Integer codigo;
	private String nomeEn;
	private String nomePtBr;
	private String sigla2;
	private String sigla3;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	@Column(name = "NOME_EN", length = 100)
	public String getNomeEn() {
		return nomeEn;
	}
	public void setNomeEn(String nomeEn) {
		this.nomeEn = nomeEn;
	}
	
	@Column(name = "NOME_PTBR", length = 100)
	public String getNomePtBr() {
		return nomePtBr;
	}
	
	public void setNomePtBr(String nomePtBr) {
		this.nomePtBr = nomePtBr;
	}
	
	@Column(name = "SIGLA2", length = 2)
	public String getSigla2() {
		return sigla2;
	}
	
	public void setSigla2(String sigla2) {
		this.sigla2 = sigla2;
	}
	
	@Column(name = "SIGLA3", length = 2)
	public String getSigla3() {
		return sigla3;
	}
	
	public void setSigla3(String sigla3) {
		this.sigla3 = sigla3;
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
		Pais other = (Pais) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}