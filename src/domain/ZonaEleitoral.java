package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_ZONAELEITORAL")
public class ZonaEleitoral implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_ZONAELEITORAL")
	private Integer codZona;
	
	@Column(name="NR_ZONA")
	private String nroZona;
	
	@OneToMany(mappedBy="zonaEleitoral")
	private List<Secao> secoes;
	
	@OneToMany(mappedBy="eleitor")
	private List<Eleitor> eleitores;
	
	public ZonaEleitoral(){
		
	}

	public ZonaEleitoral(Integer codZona, String nroZona) {
		super();
		this.codZona = codZona;
		this.nroZona = nroZona;
	}

	public Integer getCodZona() {
		return codZona;
	}

	public void setCodZona(Integer codZona) {
		this.codZona = codZona;
	}

	public String getNroZona() {
		return nroZona;
	}

	public void setNroZona(String nroZona) {
		this.nroZona = nroZona;
	}
	
	//Getters e setters das outras classes
	public List<Secao> getSecoes() {
		return secoes;
	}

	public void setSecoes(List<Secao> secoes) {
		this.secoes = secoes;
	}
	
	public List<Eleitor> getEleitores() {
		return eleitores;
	}

	public void setEleitores(List<Eleitor> eleitores) {
		this.eleitores = eleitores;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codZona == null) ? 0 : codZona.hashCode());
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
		ZonaEleitoral other = (ZonaEleitoral) obj;
		if (codZona == null) {
			if (other.codZona != null)
				return false;
		} else if (!codZona.equals(other.codZona))
			return false;
		return true;
	}


	
	
}
