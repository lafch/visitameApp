package pe.com.bbva.visitame.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.com.bbva.visitame.dominio.util.Constantes;


@Entity
@Table(name="tvisita006_ofi_oficina" , schema=Constantes.SCHEMA.VIST)
public class Oficina implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="TVISITA006_OFI_OFICINA_CDOFICINA_GENERATOR", sequenceName=Constantes.SCHEMA.VIST+".SEQ_TVISITA006_OFI_OFICINA" , schema=Constantes.SCHEMA.VIST)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TVISITA006_OFI_OFICINA_CDOFICINA_GENERATOR")
	@Column(name="cd_oficina")
	private Integer id;
	
	@Column(name="cd_alterno")
	private String codigo;

	@Column(name="nb_oficina")
	private String nombreOficina ;
	
	@Column(name="nb_direccion")
	private String direccion;
	
	@Column(name="nu_sec_ticket")
	private Integer secuenciaTicket;
	
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
	public String getCodigo() { return codigo; }
	public void setCodigo(String codigo) { this.codigo = codigo; }
	
	public String getNombreOficina() { return nombreOficina;}
	public void setNombreOficina(String nombreOficina) { this.nombreOficina = nombreOficina; }
	
	public String getDireccion() { return direccion; }
	public void setDireccion(String direccion) { this.direccion = direccion; }
	
	public Integer getSecuenciaTicket() { return secuenciaTicket; }
	public void setSecuenciaTicket(Integer secuenciaTicket) { this.secuenciaTicket = secuenciaTicket; }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombreOficina == null) ? 0 : nombreOficina.hashCode());
		result = prime * result + ((secuenciaTicket == null) ? 0 : secuenciaTicket.hashCode());
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
		Oficina other = (Oficina) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombreOficina == null) {
			if (other.nombreOficina != null)
				return false;
		} else if (!nombreOficina.equals(other.nombreOficina))
			return false;
		if (secuenciaTicket == null) {
			if (other.secuenciaTicket != null)
				return false;
		} else if (!secuenciaTicket.equals(other.secuenciaTicket))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Oficina [id=" + id + ", codigo=" + codigo + ", nombreOficina=" + nombreOficina + ", direccion="
				+ direccion + ", secuenciaTicket=" + secuenciaTicket + "]";
	}	
}