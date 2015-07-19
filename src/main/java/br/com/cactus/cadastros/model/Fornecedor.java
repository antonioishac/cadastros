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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.cactus.cadastros.model.AtividadeForCli;
import br.com.cactus.cadastros.model.ContabilConta;
import br.com.cactus.cadastros.model.SituacaoForCli;
import br.com.cactus.cadastros.model.Pessoa;

@Entity
@Table(name = "FORNECEDOR")
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date desde;
	private String optanteSimplesNacional;
	private String localizacao;
	private Date dataCadastro;
	private String sofreRetencao;
	private String chequeNominalA;
	private String observacao;
	private String contaRemetente;
	private Integer prazoMedioEntrega;
	private String geraFaturamento;
	private Integer numDiasPrimeiroVencimento;
	private Integer numDiasIntervalo;
	private Integer quantidadeParcelas;	
	private ContabilConta contabilConta;
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
	@Column(name = "DESDE")
	public Date getDesde() {
		return desde;
	}
		
	public void setDesde(Date desde) {
		this.desde = desde;
	}
	
	@Column(name = "OPTANTE_SIMPLES_NACIONAL", nullable = false, length = 1)
	public String getOptanteSimplesNacional() {
		return optanteSimplesNacional;
	}
	
	public void setOptanteSimplesNacional(String optanteSimplesNacional) {
		this.optanteSimplesNacional = optanteSimplesNacional;
	}
		
	@Column(name = "LOCALIZACAO", nullable = false, length = 1)
	public String getLocalizacao() {
		return localizacao;
	}
	
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_CADASTRO")
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@Column(name = "SOFRE_RETENCAO", nullable = false, length = 1)
	public String getSofreRetencao() {
		return sofreRetencao;
	}
	
	public void setSofreRetencao(String sofreRetencao) {
		this.sofreRetencao = sofreRetencao;
	}
	
	@Column(name = "CHEQUE_NOMINAL_A", nullable = false, length = 100)
	public String getChequeNominalA() {
		return chequeNominalA;
	}
	
	public void setChequeNominalA(String chequeNominalA) {
		this.chequeNominalA = chequeNominalA;
	}
	
	@Column(name = "OBSERVACAO")
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@Column(name = "CONTA_REMETENTE", nullable = false, length = 30)
	public String getContaRemetente() {
		return contaRemetente;
	}
	
	public void setContaRemetente(String contaRemetente) {
		this.contaRemetente = contaRemetente;
	}
	
	@Column(name = "PRAZO_MEDIO_ENTREGA", nullable = false, length = 10)
	public Integer getPrazoMedioEntrega() {
		return prazoMedioEntrega;
	}
	
	public void setPrazoMedioEntrega(Integer prazoMedioEntrega) {
		this.prazoMedioEntrega = prazoMedioEntrega;
	}
	
	@Column(name = "GERA_FATURAMENTO", nullable = false, length = 1)
	public String getGeraFaturamento() {
		return geraFaturamento;
	}
	
	public void setGeraFaturamento(String geraFaturamento) {
		this.geraFaturamento = geraFaturamento;
	}
		
	@Column(name = "NUM_DIAS_PRIMEIRO_VENCIMENTO", nullable = false, length = 10)
	public Integer getNumDiasPrimeiroVencimento() {
		return numDiasPrimeiroVencimento;
	}
	
	public void setNumDiasPrimeiroVencimento(Integer numDiasPrimeiroVencimento) {
		this.numDiasPrimeiroVencimento = numDiasPrimeiroVencimento;
	}
	
	@Column(name = "NUM_DIAS_INTERVALO", nullable = false, length = 10)
	public Integer getNumDiasIntervalo() {
		return numDiasIntervalo;
	}
	
	public void setNumDiasIntervalo(Integer numDiasIntervalo) {
		this.numDiasIntervalo = numDiasIntervalo;
	}
	
	@Column(name = "QUANTIDADE_PARCELAS", nullable = false, length = 10)
	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}
	
	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}
	
	@JoinColumn(name = "ID_CONTABIL_CONTA", referencedColumnName = "ID")
    @ManyToOne
	public ContabilConta getContabilConta() {
		return contabilConta;
	}
	
	public void setContabilConta(ContabilConta contabilConta) {
		this.contabilConta = contabilConta;
	}
	
	@NotNull
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
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}