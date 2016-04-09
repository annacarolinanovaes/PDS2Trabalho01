package model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_ELEITOR")
public class Eleitor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_ELEITOR")
	private Integer codEleitor;
	
	@ManyToOne
	@JoinColumn(name="CD_ZONAELEITORAL",referencedColumnName="CD_ZONAELEITORAL")
	private ZonaEleitoral zonaEleitoral;
	
	@Column(name="NM_ELEITOR")
	private String nomeEleitor;
	
	@Column(name="CPF_ELEITOR")
	private String CPF;
	
	@Column(name="NRO_TITULOELEITOR")
	private String nroTituloEleitor;
	
	@Column(name="LOG_ELEITOR")
	private String logradouroEleitor;
	
	@Column(name="CEP_ELEITOR")
	private String cepEleitor;
	
	public Eleitor(){
		
	}
	
	public Eleitor(Integer codEleitor, String nomeEleitor, String cPF, String nroTituloEleitor,
			String logradouroEleitor, String cepEleitor) {
		super();
		this.codEleitor = codEleitor;
		this.nomeEleitor = nomeEleitor;
		CPF = cPF;
		this.nroTituloEleitor = nroTituloEleitor;
		this.logradouroEleitor = logradouroEleitor;
		this.cepEleitor = cepEleitor;
	}

	//Getters e setters
	public Integer getCodEleitor() {
		return codEleitor;
	}
	
	public void setCodEleitor(Integer codEleitor) {
		this.codEleitor = codEleitor;
	}
	
	public String getNomeEleitor() {
		return nomeEleitor;
	}
	
	
	public void setNomeEleitor(String nomeEleitor) {
		this.nomeEleitor = nomeEleitor;
	}
	
	public String getCPF() {
		return CPF;
	}
	
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	public String getNroTituloEleitor() {
		return nroTituloEleitor;
	}
	
	public void setNroTituloEleitor(String nroTituloEleitor) {
		this.nroTituloEleitor = nroTituloEleitor;
	}
	
	public String getLogradouroEleitor() {
		return logradouroEleitor;
	}
	
	public void setLogradouroEleitor(String logradouroEleitor) {
		this.logradouroEleitor = logradouroEleitor;
	}
	
	public String getCepEleitor() {
		return cepEleitor;
	}
	
	public void setCepEleitor(String cepEleitor) {
		this.cepEleitor = cepEleitor;
	}
	
	public ZonaEleitoral getZonaEleitoral() {
		return zonaEleitoral;
	}

	public void setZonaEleitoral(ZonaEleitoral zonaEleitoral) {
		this.zonaEleitoral = zonaEleitoral;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codEleitor == null) ? 0 : codEleitor.hashCode());
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
		Eleitor other = (Eleitor) obj;
		if (codEleitor == null) {
			if (other.codEleitor != null)
				return false;
		} else if (!codEleitor.equals(other.codEleitor))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
