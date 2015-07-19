package br.com.cactus.cadastros.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "SINDICATO")
public class SindicatoPatronal implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Integer codigoBanco;
	private Integer codigoAgencia;
	private String contaBanco;
	private String codigoCedente;
	private String logradouro;
	private String numero;
	private String bairro;
	private Integer municipioIbge;
	private String uf;
	private String fone1;
	private String fone2;
	private String email;
	private String tipoSindicato;
	private Date dataBase;
	private BigDecimal pisoSalarial;
	private String cnpj;

	private ContabilConta contabilConta;

	
	//getter and setter
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
	
	@Column(name = "CODIGO_BANCO", nullable = false, length = 10)
	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	@NotBlank
	@Column(name = "CODIGO_AGENCIA", nullable = false, length = 10)
	public Integer getCodigoAgencia() {
		return codigoAgencia;
	}

	public void setCodigoAgencia(Integer codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}

	@Column(name = "CONTA_BANCO", nullable = false, length = 20)
	public String getContaBanco() {
		return contaBanco;
	}

	public void setContaBanco(String contaBanco) {
		this.contaBanco = contaBanco;
	}

	@Column(name = "CODIGO_CEDENTE",nullable = false, length = 30)
	public String getCodigoCedente() {
		return codigoCedente;
	}

	public void setCodigoCedente(String codigoCedente) {
		this.codigoCedente = codigoCedente;
	}

	@Column(nullable = false, length = 100)
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Column(nullable = false, length = 10)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(nullable = false, length = 100)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(name = "MUNICIPIO_IBGE", nullable = false, length = 10)
	public Integer getMunicipioIbge() {
		return municipioIbge;
	}

	public void setMunicipioIbge(Integer municipioIbge) {
		this.municipioIbge = municipioIbge;
	}

	@Column(nullable = false, length = 2)
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Column(nullable = false, length = 14)
	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	@Column(nullable = false, length = 14)
	public String getFone2() {
		return fone2;
	}

	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}

	@Column(nullable = false, length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "TIPO_SINDICATO", nullable = false, length = 1)
	public String getTipoSindicato() {
		return tipoSindicato;
	}

	public void setTipoSindicato(String tipoSindicato) {
		this.tipoSindicato = tipoSindicato;
	}

	@Column(name = "DATA_BASE")
	public Date getDataBase() {
		return dataBase;
	}

	public void setDataBase(Date dataBase) {
		this.dataBase = dataBase;
	}

	@Column(nullable = false, length = 14)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@ManyToOne
	@JoinColumn(name = "ID_CONTABIL_CONTA", nullable = false)
	public ContabilConta getContabilConta() {
		return contabilConta;
	}

	public void setContabilConta(ContabilConta contabilConta) {
		this.contabilConta = contabilConta;
	}

	@Column(name = "PISO_SALARIAL")
	public BigDecimal getPisoSalarial() {
		return pisoSalarial;
	}

	public void setPisoSalarial(BigDecimal pisoSalarial) {
		this.pisoSalarial = pisoSalarial;
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
		SindicatoPatronal other = (SindicatoPatronal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
