package br.com.cactus.cadastros.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "pessoa_contato")
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String email;
	private String foneComercial;
	private String foneResidencial;
	private String foneCelular;	
	private Pessoa pessoa;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@NotBlank
	@Column(nullable = false, length = 100)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	@Column(nullable = false, length = 250)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
		
	@Column(name = "FONE_COMERCIAL" ,nullable = false, length = 14)
	public String getFoneComercial() {
		return foneComercial;
	}
	
	public void setFoneComercial(String foneComercial) {
		this.foneComercial = foneComercial;
	}
		
	@Column(name = "FONE_RESIDENCIAL", nullable = false, length = 14)
	public String getFoneResidencial() {
		return foneResidencial;
	}
	
	public void setFoneResidencial(String foneResidencial) {
		this.foneResidencial = foneResidencial;
	}
		
	@Column(name = "FONE_CELULAR", nullable = false, length = 14)
	public String getFoneCelular() {
		return foneCelular;
	}
	
	public void setFoneCelular(String foneCelular) {
		this.foneCelular = foneCelular;
	}	
	
	@JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
    @OneToOne
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
