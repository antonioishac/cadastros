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
@Table(name = "empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//campo TIPO - Valores possíveis: M-Matriz | F-Filial | D=Depósito
	//campo CRT - Código Regime Tributário [1=Simples Nacional | 2=Simples Nacional - excesso de sublimite da receita bruta  | 3=Regime Normal
	//campo Tipo Regime - 1-Lucro REAL;2-Lucro presumido;3-Simples nacional;

	private Integer id;                                                                                                                                                                                                     
	private Empresa empresa;                                                                                                                                                                                             
	private SindicatoPatronal sindicatoPatronal;                                                                                                                                                                                  
	private Fpas fpas;                                                                                                                                                                                                
	private Contador contador;                                                                                                                                                                                            
	private String razaoSocial;                                                                                                                                                                                           
	private String nomeFantasia;                                                                                                                                                                                          
	private String cnpj;                                                                                                                                                                                                   
	private String inscricaoEstadual;                                                                                                                                                                                     
	private String inscricaoEstadualSt;                                                                                                                                                                                  
	private String inscricaoMunicipal;                                                                                                                                                                                    
	private String inscricaoJuntaComercial;                                                                                                                                                                              
	private Date dataInscJuntaComercial;                                                                                                                                                                              
	private Character tipo;                                                                                                                                            
	private Date dataCadastro;                                                                                                                                                                                          
	private Date dataInicioAtividades;                                                                                                                                                                                 
	private String suframa;                                                                                                                                                                                                
	private String email;                                                                                                                                                                                                  
	private String imagemLogotipo;                                                                                                                                                                                        
	private Character crt;                                                                    
	private Character tipoRegime;       
	
	//Aliquota do PIS padrao para a empresa
	private BigDecimal aliquotaPis;                                                                                                                                                    
	
	private String empresaContato;    
	
	//Aliquota padrao do Confins 
	private BigDecimal aliquotaCofins;                                                                                                                                                                                        
	
	private Integer codigoIbgeCidade;                                                                                                                                                                                     
	private Integer codigoIbgeUf;
	
	//Codigo das contribuicoes para terceiros incidentes sobre a folha de pagamento (os terceiros sao SESI, SENAI, SEBRAE, INCRA, etc) esta tabela consta na IN 971/2009  da RFB
	private Integer codigoTerceiros;           
	
	//Codigo de pagamento da GPS, trata-se de tabale encontrada no site da Previdencia Social
	private Integer codigoGps;                                                                                                    
	
	//Aliquota do Seguro contra Acidente de trabalho incidente sobre a folha de pagametno dos empregados
	private BigDecimal aliquotaSat;
	
	//Número de inscrição do estabelecimento no Cadastro Específico do INSS
	private String cei;                                                                                                                         
	
	//Demais códigos da empresa devem ser informados na tabela EMPRESA_CNAE
	private String codigoCnaePrincipal; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@NotBlank
	@Column(name = "RAZAO_SOCIAL", nullable = false, length = 150)
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	@NotBlank
	@Column(name = "NOME_FANTASIA", nullable = false, length = 150)
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
		
	@Column(nullable = false, length = 14)
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Column(name = "INSCRICAO_ESTADUAL", length = 30)
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
	@Column(name = "INSCRICAO_ESTADUAL_ST", length = 30)
	public String getInscricaoEstadualSt() {
		return inscricaoEstadualSt;
	}
	
	public void setInscricaoEstadualSt(String inscricaoEstadualSt) {
		this.inscricaoEstadualSt = inscricaoEstadualSt;
	}
	
	@Column(name = "INSCRICAO_MUNICIPAL", length = 30)
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	
	@Column(name = "INSCRICAO_JUNTA_COMERCIAL", length = 30)
	public String getInscricaoJuntaComercial() {
		return inscricaoJuntaComercial;
	}
	
	public void setInscricaoJuntaComercial(String inscricaoJuntaComercial) {
		this.inscricaoJuntaComercial = inscricaoJuntaComercial;
	}
	
	@Column(name = "DATA_INSC_JUNTA_COMERCIAL")
	public Date getDataInscJuntaComercial() {
		return dataInscJuntaComercial;
	}
	
	public void setDataInscJuntaComercial(Date dataInscJuntaComercial) {
		this.dataInscJuntaComercial = dataInscJuntaComercial;
	}
		
	@Column(length = 1)
	public Character getTipo() {
		return tipo;
	}
	
	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}
	
	@Column(name = "DATA_CADASTRO")
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@Column(name = "DATA_INICIO_ATIVIDADES")
	public Date getDataInicioAtividades() {
		return dataInicioAtividades;
	}
	
	public void setDataInicioAtividades(Date dataInicioAtividades) {
		this.dataInicioAtividades = dataInicioAtividades;
	}
	
	@Column(length = 9)
	public String getSuframa() {
		return suframa;
	}
	
	public void setSuframa(String suframa) {
		this.suframa = suframa;
	}
	
	@Column(length = 250)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "IMAGEM_LOGOTIPO")
	public String getImagemLogotipo() {
		return imagemLogotipo;
	}
	
	public void setImagemLogotipo(String imagemLogotipo) {
		this.imagemLogotipo = imagemLogotipo;
	}
	
	@Column(length = 1)
	public Character getCrt() {
		return crt;
	}
	
	public void setCrt(Character crt) {
		this.crt = crt;
	}
	
	@Column(name = "TIPO_REGIME",length = 1)
	public Character getTipoRegime() {
		return tipoRegime;
	}
	
	public void setTipoRegime(Character tipoRegime) {
		this.tipoRegime = tipoRegime;
	}
			
	@Column(name = "CODIGO_IBGE_CIDADE", length = 10)
	public Integer getCodigoIbgeCidade() {
		return codigoIbgeCidade;
	}
	
	public void setCodigoIbgeCidade(Integer codigoIbgeCidade) {
		this.codigoIbgeCidade = codigoIbgeCidade;
	}
	
	@Column(name = "CODIGO_IBGE_UF", length = 10)
	public Integer getCodigoIbgeUf() {
		return codigoIbgeUf;
	}
	
	public void setCodigoIbgeUf(Integer codigoIbgeUf) {
		this.codigoIbgeUf = codigoIbgeUf;
	}
	
	@Column(name = "CODIGO_TERCEIROS", length = 10)
	public Integer getCodigoTerceiros() {
		return codigoTerceiros;
	}
	
	public void setCodigoTerceiros(Integer codigoTerceiros) {
		this.codigoTerceiros = codigoTerceiros;
	}
	
	@Column(name = "CODIGO_GPS", length = 10)
	public Integer getCodigoGps() {
		return codigoGps;
	}
	
	public void setCodigoGps(Integer codigoGps) {
		this.codigoGps = codigoGps;
	}
	
	@Column(length = 12)
	public String getCei() {
		return cei;
	}
	
	public void setCei(String cei) {
		this.cei = cei;
	}
	
	@Column(name = "CODIGO_CNAE_PRINCIPAL", length = 7)
	public String getCodigoCnaePrincipal() {
		return codigoCnaePrincipal;
	}
		
	public void setCodigoCnaePrincipal(String codigoCnaePrincipal) {
		this.codigoCnaePrincipal = codigoCnaePrincipal;
	}
	
	@ManyToOne
	@JoinColumn(name = "ID_EMPRESA")
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@ManyToOne
	@JoinColumn(name = "ID_SINDICATO_PATRONAL")
	public SindicatoPatronal getSindicatoPatronal() {
		return sindicatoPatronal;
	}
	
	public void setSindicatoPatronal(SindicatoPatronal sindicatoPatronal) {
		this.sindicatoPatronal = sindicatoPatronal;
	}
	
	@ManyToOne
	@JoinColumn(name = "ID_FPAS")
	public Fpas getFpas() {
		return fpas;
	}
	
	public void setFpas(Fpas fpas) {
		this.fpas = fpas;
	}
	
	@ManyToOne
	@JoinColumn(name = "ID_CONTADOR")
	public Contador getContador() {
		return contador;
	}
	
	public void setContador(Contador contador) {
		this.contador = contador;
	}

	@Column(name = "ALIQUOTA_PIS")
	public BigDecimal getAliquotaPis() {
		return aliquotaPis;
	}

	public void setAliquotaPis(BigDecimal aliquotaPis) {
		this.aliquotaPis = aliquotaPis;
	}	

	@Column (name = "EMPRESA_CONTATO")
	public String getEmpresaContato() {
		return empresaContato;
	}

	public void setEmpresaContato(String empresaContato) {
		this.empresaContato = empresaContato;
	}

	@Column(name = "ALIQUOTA_COFINS")
	public BigDecimal getAliquotaCofins() {
		return aliquotaCofins;
	}

	public void setAliquotaCofins(BigDecimal aliquotaCofins) {
		this.aliquotaCofins = aliquotaCofins;
	}

	@Column(name = "ALIQUOTA_SAT")
	public BigDecimal getAliquotaSat() {
		return aliquotaSat;
	}

	public void setAliquotaSat(BigDecimal aliquotaSat) {
		this.aliquotaSat = aliquotaSat;
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
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}