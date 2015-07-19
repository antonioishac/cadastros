package br.com.cactus.cadastros.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "FPAS")
public class Fpas implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer codigo;
	private String cnae;
	private BigDecimal aliquotaSat;
	private String descricao;
	private BigDecimal percentualInssPatronal;
	private BigDecimal codigoTerceiro;
	private BigDecimal percentualTerceiros;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotBlank
	@Column(nullable = false, length = 10)
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Column(nullable = false, length = 14)
	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
	}

	@Column(name = "ALIQUOTA_SAT")
	public BigDecimal getAliquotaSat() {
		return aliquotaSat;
	}

	public void setAliquotaSat(BigDecimal aliquotaSat) {
		this.aliquotaSat = aliquotaSat;
	}

	@Column(nullable = false, length = 250)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "PERCENTUAL_INSS_PATRONAL")
	public BigDecimal getPercentualInssPatronal() {
		return percentualInssPatronal;
	}

	public void setPercentualInssPatronal(BigDecimal percentualInssPatronal) {
		this.percentualInssPatronal = percentualInssPatronal;
	}

	@Column(name = "CODIGO_TERCEIRO")
	public BigDecimal getCodigoTerceiro() {
		return codigoTerceiro;
	}

	public void setCodigoTerceiro(BigDecimal codigoTerceiro) {
		this.codigoTerceiro = codigoTerceiro;
	}

	@Column(name = "PERCENTUAL_TERCEIROS")
	public BigDecimal getPercentualTerceiros() {
		return percentualTerceiros;
	}

	public void setPercentualTerceiros(BigDecimal percentualTerceiros) {
		this.percentualTerceiros = percentualTerceiros;
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
		Fpas other = (Fpas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}