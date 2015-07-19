package br.com.cactus.cadastros.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "PESSOA_JURIDICA")
public class PessoaJuridica implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;    
    private String cnpj;    
    private String fantasia;    
    private String inscricaoMunicipal;    
    private String inscricaoEstadual;    
    private Date dataConstituicao;    
    private String tipoRegime;    
    private String tipoCrt;    
    private String suframa;    
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
	@Column(name = "CNPJ", nullable = false, length = 14)
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@NotBlank
	@Column(name = "FANTASIA", nullable = false, length = 150)
	public String getFantasia() {
		return fantasia;
	}
	
	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}
	
	@Column(name = "INSCRICAO_MUNICIPAL", nullable = false, length = 30)
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	
	@Column(name = "INSCRICAO_ESTADUAL", nullable = false, length = 30)
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
	@Column(name = "DATA_CONSTITUICAO")
	public Date getDataConstituicao() {
		return dataConstituicao;
	}
	
	public void setDataConstituicao(Date dataConstituicao) {
		this.dataConstituicao = dataConstituicao;
	}	
	
	@Column(name = "SUFRAMA", nullable = false, length = 9)
	public String getSuframa() {
		return suframa;
	}
	
	public void setSuframa(String suframa) {
		this.suframa = suframa;
	}
	
	@JoinColumn(name = "ID_PESSOA", nullable = false)
	@OneToOne
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}	
		
	@Column(name = "TIPO_REGIME", nullable = false, length = 20)
	public String getTipoRegime() {
		return tipoRegime;
	}

	public void setTipoRegime(String tipoRegime) {
		this.tipoRegime = tipoRegime;
	}

	@Column(name = "CRT", nullable = false, length = 20)
	public String getTipoCrt() {
		return tipoCrt;
	}

	public void setTipoCrt(String tipoCrt) {
		this.tipoCrt = tipoCrt;
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
		PessoaJuridica other = (PessoaJuridica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
