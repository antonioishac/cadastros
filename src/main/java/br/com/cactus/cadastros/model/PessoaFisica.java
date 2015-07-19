package br.com.cactus.cadastros.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.cactus.cadastros.model.EstadoCivil;
import br.com.cactus.cadastros.model.TipoRaca;
import br.com.cactus.cadastros.model.TipoSangue;
import br.com.cactus.cadastros.model.TipoSexo;

@Entity
@Table(name = "PESSOA_FISICA")
public class PessoaFisica implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;    
    private String cpf;    
    private String rg;    
    private String orgaoRg;    
    private Date dataEmissaoRg;    
    private Date dataNascimento;    
    private TipoSexo tipoSexo;    
    private String naturalidade;    
    private String nacionalidade;    
    private TipoRaca tipoRaca;    
    private TipoSangue tipoSangue;    
    private String cnhNumero;    
    private String cnhCategoria;    
    private Date cnhVencimento;    
    private String tituloEleitoralNumero;    
    private Integer tituloEleitoralZona;    
    private Integer tituloEleitoralSecao;    
    private String reservistaNumero;    
    private Integer reservistaCategoria;    
    private String nomeMae;    
    private String nomePai;        
    private EstadoCivil estadoCivil;    
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
	@Column(nullable = false, length = 11)
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
	
	@Column(nullable = false, length = 20)
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	@Column(name = "ORGAO_RG", nullable = false, length = 20)
	public String getOrgaoRg() {
		return orgaoRg;
	}
	
	public void setOrgaoRg(String orgaoRg) {
		this.orgaoRg = orgaoRg;
	}
	
	@Column(name = "DATA_EMISSAO_RG")
	public Date getDataEmissaoRg() {
		return dataEmissaoRg;
	}
	
	public void setDataEmissaoRg(Date dataEmissaoRg) {
		this.dataEmissaoRg = dataEmissaoRg;
	}
	
	@Column(name = "DATA_NASCIMENTO")
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	
		
	@Enumerated(EnumType.STRING)
	@Column(name = "SEXO", nullable = false)
	public TipoSexo getTipoSexo() {
		return tipoSexo;
	}
	
	public void setTipoSexo(TipoSexo tipoSexo) {
		this.tipoSexo = tipoSexo;
	}	
	
	@Column(nullable = false, length = 100)
	public String getNaturalidade() {
		return naturalidade;
	}
	
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}	
	
	@Column(nullable = false, length = 100)
	public String getNacionalidade() {
		return nacionalidade;
	}
	
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}	
		
	@Enumerated(EnumType.STRING)
	@Column(name = "RACA", nullable = false)
	public TipoRaca getTipoRaca() {
		return tipoRaca;
	}
	
	public void setTipoRaca(TipoRaca tipoRaca) {
		this.tipoRaca = tipoRaca;
	}	
		
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_SANGUE", nullable = false)
	public TipoSangue getTipoSangue() {
		return tipoSangue;
	}
	
	public void setTipoSangue(TipoSangue tipoSangue) {
		this.tipoSangue = tipoSangue;
	}	
	
	@Column(name = "CNH_NUMERO", nullable = false, length = 20)
	public String getCnhNumero() {
		return cnhNumero;
	}
	
	public void setCnhNumero(String cnhNumero) {
		this.cnhNumero = cnhNumero;
	}
	
	@Column(name = "CNH_CATEGORIA" ,nullable = false, length = 2)
	public String getCnhCategoria() {
		return cnhCategoria;
	}
	
	public void setCnhCategoria(String cnhCategoria) {
		this.cnhCategoria = cnhCategoria;
	}
	
	@Column(name = "CNH_VENCIMENTO")
	public Date getCnhVencimento() {
		return cnhVencimento;
	}
	
	public void setCnhVencimento(Date cnhVencimento) {
		this.cnhVencimento = cnhVencimento;
	}
	
	
	@Column(name = "TITULO_ELEITORAL_NUMERO", nullable = false, length = 20)
	public String getTituloEleitoralNumero() {
		return tituloEleitoralNumero;
	}
	
	public void setTituloEleitoralNumero(String tituloEleitoralNumero) {
		this.tituloEleitoralNumero = tituloEleitoralNumero;	
	}
	
	
	@Column(name = "TITULO_ELEITORAL_ZONA", nullable = false, length = 10)
	public Integer getTituloEleitoralZona() {
		return tituloEleitoralZona;
	}
	
	public void setTituloEleitoralZona(Integer tituloEleitoralZona) {
		this.tituloEleitoralZona = tituloEleitoralZona;
	}
	
	
	@Column(name = "TITULO_ELEITORAL_SECAO", nullable = false, length = 10)
	public Integer getTituloEleitoralSecao() {
		return tituloEleitoralSecao;
	}
	
	public void setTituloEleitoralSecao(Integer tituloEleitoralSecao) {
		this.tituloEleitoralSecao = tituloEleitoralSecao;
	}
	
	
	@Column(name = "RESERVISTA_NUMERO", nullable = false, length = 20)
	public String getReservistaNumero() {
		return reservistaNumero;
	}
	
	public void setReservistaNumero(String reservistaNumero) {
		this.reservistaNumero = reservistaNumero;
	}
	
	
	@Column(name = "RESERVISTA_CATEGORIA", nullable = false, length = 20)
	public Integer getReservistaCategoria() {
		return reservistaCategoria;
	}
	
	public void setReservistaCategoria(Integer reservistaCategoria) {
		this.reservistaCategoria = reservistaCategoria;
	}
	
	
	@Column(name = "NOME_MAE", nullable = false, length = 100)
	public String getNomeMae() {
		return nomeMae;
	}
	
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	
	
	@Column(name = "NOME_PAI", nullable = false, length = 100)
	public String getNomePai() {
		return nomePai;
	}
	
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	
	@NotNull
	@JoinColumn(name = "ID_ESTADO_CIVIL", referencedColumnName = "ID")
    @ManyToOne
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	@JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
    @OneToOne(orphanRemoval = true)
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
		PessoaFisica other = (PessoaFisica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}    
}
