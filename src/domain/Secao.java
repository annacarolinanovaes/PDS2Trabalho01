package domain;

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
@Table(name="TB_SECAO")
public class Secao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_SECAO")
	private Integer codSecao;
	
	@ManyToOne
	@JoinColumn(name="CD_ZONAELEITORAL",referencedColumnName="CD_ZONAELEITORAL")
	private ZonaEleitoral zonaEleitoral;
	
	@Column(name="NM_ESCOLA")
	private String nomeEscola;
	
	@Column(name="NM_SALA")
	private String nroSala;
	
	@Column(name="BAIRRO")
	private String bairro;
	
	
	public Secao(){
		
	}
	
	public Secao(Integer codSecao, String nomeEscola, String nroSala, String bairro) {
		super();
		this.codSecao = codSecao;
		this.nomeEscola = nomeEscola;
		this.nroSala = nroSala;
		this.bairro = bairro;
	}
	
	public Integer getCodSecao() {
		return codSecao;
	}

	public void setCodSecao(Integer codSecao) {
		this.codSecao = codSecao;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}
	
	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}
	
	public String getNroSala() {
		return nroSala;
	}
	
	public void setNroSala(String nroSala) {
		this.nroSala = nroSala;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
	
	
}
