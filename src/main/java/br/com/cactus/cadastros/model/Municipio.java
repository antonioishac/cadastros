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
@Table(name = "MUNICIPIO")
public class Municipio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@Column(name = "CODIGO_IBGE", nullable = false, length = 10)
	private Integer codigoIbge;

	@Column(name = "CODIGO_RECEITA_FEDERAL", nullable = false, length = 10)
	private Integer codigoReceitaFederal;
	
	@Column(name = "CODIGO_ESTADUAL", nullable = false, length = 10)
	private Integer codigoEstadual;
	
	@ManyToOne
	@JoinColumn(name = "ID_UF", referencedColumnName = "ID")
	private Uf uf;
				
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "NOME", nullable = false, length = 100)
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
		Municipio other = (Municipio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Municipio [id=" + id + "]";
	}
}
