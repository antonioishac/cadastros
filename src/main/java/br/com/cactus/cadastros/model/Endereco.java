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
@Table(name = "pessoa_endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String cep;
	private Integer municipioIbge;	
	private String uf;	
	private String principal;
	private String entrega;
	private String cobranca;
	private String correspondencia;	
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
	@Column(nullable = false, length = 60)
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	@NotBlank
	@Column(nullable = false, length = 10)
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Column(nullable = false, length = 60)
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	@NotBlank
	@Column(nullable = false, length = 60)
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	@NotBlank
	@Column(nullable = false, length = 60)
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@NotBlank
	@Column(nullable = false, length = 8)
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {		
		this.cep = cep;
	}
	
	@Column(name = "municipio_ibge", nullable = false, length = 10)
	public Integer getMunicipioIbge() {
		return municipioIbge;
	}
	
	public void setMunicipioIbge(Integer municipioIbge) {
		this.municipioIbge = municipioIbge;
	}
	
	@NotBlank
	@Column(nullable = false, length = 2)
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
				
	public String getPrincipal() {
		return principal;
	}
	
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
		
	public String getEntrega() {
		return entrega;
	}
	
	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}
		
	public String getCobranca() {
		return cobranca;
	}
	
	public void setCobranca(String cobranca) {
		this.cobranca = cobranca;
	}
		
	public String getCorrespondencia() {
		return correspondencia;
	}
	
	public void setCorrespondencia(String correspondencia) {
		this.correspondencia = correspondencia;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}