package br.com.cactus.cadastros.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String nome;
    private String email;
    private String site;
    private String cliente;
    private String fornecedor;
    private String colaborador;
    private String transportadora;    
    private TipoPessoa tipo;
    private PessoaFisica pessoaFisica;
    private PessoaJuridica pessoaJuridica;
        
    private List<Contato> contatos = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();
    private List<Telefone> telefones = new ArrayList<>();
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
    
	public void setId(Integer id) {
		this.id = id;
	}
	
	@NotBlank
	@Column(nullable = false, length = 150)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
			
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public TipoPessoa getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}
		
	@Column(nullable = false, length = 250)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(nullable = false, length = 250)
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}

	@NotBlank
	@Column(nullable = false, length = 1)
	public String getCliente() {
		return cliente;
	}
	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	@NotBlank
	@Column(nullable = false, length = 1)
	public String getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	@NotBlank
	@Column(nullable = false, length = 1)
	public String getColaborador() {
		return colaborador;
	}
	
	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}
			
	@NotBlank
	@Column(nullable = false, length = 1)
	public String getTransportadora() {
		return transportadora;
	}
	
	public void setTransportadora(String transportadora) {
		this.transportadora = transportadora;
	}

	@NotNull
	@OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL)
	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	@NotNull
	@OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL)
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}	
	
	@NotNull
	@OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL)
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "pessoa", cascade = CascadeType.ALL)
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "pessoa", cascade = CascadeType.ALL)
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
