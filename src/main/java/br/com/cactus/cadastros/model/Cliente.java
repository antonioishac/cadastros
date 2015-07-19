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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.cactus.cadastros.model.AtividadeForCli;
import br.com.cactus.cadastros.model.ContabilConta;
import br.com.cactus.cadastros.model.OperacaoFiscal;
import br.com.cactus.cadastros.model.SituacaoForCli;
import br.com.cactus.cadastros.model.Pessoa;

@Entity
@Table(name ="CLIENTE")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date desde;
	private Date dataCadastro;
	private String observacao;
	private String contaTomador;
	private String geraFinanceiro;
	private String indicadorPreco;
	private BigDecimal porcentoDesconto;
	private String formaDesconto;
	private BigDecimal limiteCredito;
	private String tipoFrete;
	private ContabilConta contabilConta;	
	private OperacaoFiscal operacaoFiscal;
	private Pessoa pessoa;
	private AtividadeForCli atividadeForCli;
	private SituacaoForCli situacaoForCli;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}	
	
	@Temporal(TemporalType.DATE)
	public Date getDesde() {
		return desde;
	}	
	
	public void setDesde(Date desde) {
		this.desde = desde;
	}	
		
	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro")
	public Date getDataCadastro() {
		return dataCadastro;
	}	
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Column(name = "CONTA_TOMADOR", nullable = false, length = 30)
	public String getContaTomador() {
		return contaTomador;
	}
	
	public void setContaTomador(String contaTomador) {
		this.contaTomador = contaTomador;
	}	
	
	@Column(name = "GERA_FINANCEIRO", nullable = false, length = 1)
	public String getGeraFinanceiro() {
		return geraFinanceiro;
	}
	
	public void setGeraFinanceiro(String geraFinanceiro) {
		this.geraFinanceiro = geraFinanceiro;
	}	
	
	@Column(name = "INDICADOR_PRECO", nullable = false, length = 1)
	public String getIndicadorPreco() {
		return indicadorPreco;
	}
	
	public void setIndicadorPreco(String indicadorPreco) {
		this.indicadorPreco = indicadorPreco;
	}
		
	@Column(name = "FORMA_DESCONTO", nullable = false, length = 1)
	public String getFormaDesconto() {
		return formaDesconto;
	}
	
	public void setFormaDesconto(String formaDesconto) {
		this.formaDesconto = formaDesconto;
	}
			
	@Column(name = "TIPO_FRETE", nullable = false, length = 1)
	public String getTipoFrete() {
		return tipoFrete;
	}
	
	public void setTipoFrete(String tipoFrete) {
		this.tipoFrete = tipoFrete;
	}	
	
	@JoinColumn(name = "ID_CONTABIL_CONTA", referencedColumnName = "ID")
    @ManyToOne
	public ContabilConta getContabilConta() {
		return contabilConta;
	}
	
	public void setContabilConta(ContabilConta contabilConta) {
		this.contabilConta = contabilConta;
	}	
	
	@JoinColumn(name = "ID_OPERACAO_FISCAL", referencedColumnName = "ID")
    @ManyToOne
	public OperacaoFiscal getOperacaoFiscal() {
		return operacaoFiscal;
	}
	
	public void setOperacaoFiscal(OperacaoFiscal operacaoFiscal) {
		this.operacaoFiscal = operacaoFiscal;
	}	
	
	@ManyToOne
    @JoinColumn(name = "ID_PESSOA", nullable = false)
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}		
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "ID_ATIVIDADE_FOR_CLI", nullable = false)    
	public AtividadeForCli getAtividadeForCli() {
		return atividadeForCli;
	}
	
	public void setAtividadeForCli(AtividadeForCli atividadeForCli) {
		this.atividadeForCli = atividadeForCli;
	}	
	
	@NotNull
    @ManyToOne
    @JoinColumn(name = "ID_SITUACAO_FOR_CLI", nullable = false)
	public SituacaoForCli getSituacaoForCli() {
		return situacaoForCli;
	}
	
	public void setSituacaoForCli(SituacaoForCli situacaoForCli) {
		this.situacaoForCli = situacaoForCli;
	}

	@Column(name = "PORCENTO_DESCONTO")
	public BigDecimal getPorcentoDesconto() {
		return porcentoDesconto;
	}

	public void setPorcentoDesconto(BigDecimal porcentoDesconto) {
		this.porcentoDesconto = porcentoDesconto;
	}

	@Column(name = "LIMITE_CREDITO")
	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
