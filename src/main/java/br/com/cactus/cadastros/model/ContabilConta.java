package br.com.cactus.cadastros.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTABIL_CONTA")
public class ContabilConta implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String classificacao;
	private String tipo;
	private String descricao;
	private Date dataInclusao;
	private String situacao;
	private String natureza;
	private String patrimonioResultado;
	private String livroCaixa;
	private String dfc;
	private String ordem;
	private String codigoReduzido;
	private String codigoEfd;
	private ContabilConta contabilConta;
	private PlanoConta planoConta;
	private PlanoContaRefSped planoContaRefSped;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
		
	@Column(nullable = false, length = 30)
	public String getClassificacao() {
		return classificacao;
	}
	
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
		
	@Column(nullable = false, length = 1)
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
		
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Column(name = "DATA_INCLUSAO")
	public Date getDataInclusao() {
		return dataInclusao;
	}
	
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	
	@Column(nullable = false, length = 1)
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	@Column(nullable = false, length = 1)
	public String getNatureza() {
		return natureza;
	}
	
	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}
		
	@Column(name = "PATRIMONIO_RESULTADO", nullable = false, length = 1)
	public String getPatrimonioResultado() {
		return patrimonioResultado;
	}
	
	public void setPatrimonioResultado(String patrimonioResultado) {
		this.patrimonioResultado = patrimonioResultado;
	}
	
	@Column(name = "LIVRO_CAIXA", nullable = false, length = 1)
	public String getLivroCaixa() {
		return livroCaixa;
	}
	
	public void setLivroCaixa(String livroCaixa) {
		this.livroCaixa = livroCaixa;
	}
	
	@Column(nullable = false, length = 1)
	public String getDfc() {
		return dfc;
	}
	
	public void setDfc(String dfc) {
		this.dfc = dfc;
	}
	
	@Column(nullable = false, length = 20)
	public String getOrdem() {
		return ordem;
	}
	
	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}
	
	@Column(name = "CODIGO_REDUZIDO", nullable = false, length = 10)
	public String getCodigoReduzido() {
		return codigoReduzido;
	}
	
	public void setCodigoReduzido(String codigoReduzido) {
		this.codigoReduzido = codigoReduzido;
	}
	
	@Column(name = "CODIGO_EFD", nullable = false, length = 2)
	public String getCodigoEfd() {
		return codigoEfd;
	}
	
	public void setCodigoEfd(String codigoEfd) {
		this.codigoEfd = codigoEfd;
	}
	
	@JoinColumn(name = "ID_CONTABIL_CONTA", referencedColumnName = "ID")
    @ManyToOne
	public ContabilConta getContabilConta() {
		return contabilConta;
	}
	
	public void setContabilConta(ContabilConta contabilConta) {
		this.contabilConta = contabilConta;
	}
	
	@JoinColumn(name = "ID_PLANO_CONTA", referencedColumnName = "ID")
    @ManyToOne
	public PlanoConta getPlanoConta() {
		return planoConta;
	}
	
	public void setPlanoConta(PlanoConta planoConta) {
		this.planoConta = planoConta;
	}
	
	@JoinColumn(name = "ID_PLANO_CONTA_REF_SPED", referencedColumnName = "ID")
    @ManyToOne
	public PlanoContaRefSped getPlanoContaRefSped() {
		return planoContaRefSped;
	}
	
	public void setPlanoContaRefSped(PlanoContaRefSped planoContaRefSped) {
		this.planoContaRefSped = planoContaRefSped;
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
		ContabilConta other = (ContabilConta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
