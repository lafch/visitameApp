package pe.com.bbva.visitame.dominio;

import java.io.Serializable;

import javax.persistence.*;

import pe.com.bbva.visitame.dominio.util.Constantes;
import java.util.Date;


/**
 * The persistent class for the tvisita004_per_persona database table.
 * 
 */
@Entity
@Table(name="tvisita004_per_persona" , schema=Constantes.SCHEMA.VIST)
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TVISITA004_PER_PERSONA_CDPERSONA_GENERATOR", sequenceName="appvisitame.SEQ_TVISITA004_PER_PERSONA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TVISITA004_PER_PERSONA_CDPERSONA_GENERATOR")
	@Column(name="cd_persona")
	private Integer cdPersona;

	@Column(name="cd_alterno")
	private Integer cdAlterno;

	@Column(name="cd_creador")
	private Integer cdCreador;

	@Column(name="cd_editor")
	private Integer cdEditor;

	@Column(name="cd_tipo_doi")
	private Integer cdTipoDoi;

	@Column(name="cd_tipo_persona")
	private Integer cdTipoPersona;

	@Column(name="nb_email")
	private String nbEmail;

	@Column(name="nb_materno")
	private String nbMaterno;

	@Column(name="nb_nombre")
	private String nbNombre;

	@Column(name="nb_num_doi")
	private String nbNumDoi;

	@Column(name="nb_paterno")
	private String nbPaterno;

	@Column(name="nb_telefono")
	private String nbTelefono;

	@Column(name="tm_creacion")
	private Date tmCreacion;

	@Column(name="tm_edicion")
	private Date tmEdicion;
	
	@Column(name="nb_cliente")
	private String isCliente;

	public Persona() {
	}

	public Integer getCdPersona() {
		return this.cdPersona;
	}

	public void setCdPersona(Integer cdPersona) {
		this.cdPersona = cdPersona;
	}

	public Integer getCdAlterno() {
		return this.cdAlterno;
	}

	public void setCdAlterno(Integer cdAlterno) {
		this.cdAlterno = cdAlterno;
	}

	public Integer getCdCreador() {
		return this.cdCreador;
	}

	public void setCdCreador(Integer cdCreador) {
		this.cdCreador = cdCreador;
	}

	public Integer getCdEditor() {
		return this.cdEditor;
	}

	public void setCdEditor(Integer cdEditor) {
		this.cdEditor = cdEditor;
	}

	public Integer getCdTipoDoi() {
		return this.cdTipoDoi;
	}

	public void setCdTipoDoi(Integer cdTipoDoi) {
		this.cdTipoDoi = cdTipoDoi;
	}

	public Integer getCdTipoPersona() {
		return this.cdTipoPersona;
	}

	public void setCdTipoPersona(Integer cdTipoPersona) {
		this.cdTipoPersona = cdTipoPersona;
	}

	public String getNbEmail() {
		return this.nbEmail;
	}

	public void setNbEmail(String nbEmail) {
		this.nbEmail = nbEmail;
	}

	public String getNbMaterno() {
		return this.nbMaterno;
	}

	public void setNbMaterno(String nbMaterno) {
		this.nbMaterno = nbMaterno;
	}

	public String getNbNombre() {
		return this.nbNombre;
	}

	public void setNbNombre(String nbNombre) {
		this.nbNombre = nbNombre;
	}

	public String getNbNumDoi() {
		return this.nbNumDoi;
	}

	public void setNbNumDoi(String nbNumDoi) {
		this.nbNumDoi = nbNumDoi;
	}

	public String getNbPaterno() {
		return this.nbPaterno;
	}

	public void setNbPaterno(String nbPaterno) {
		this.nbPaterno = nbPaterno;
	}

	public String getNbTelefono() {
		return this.nbTelefono;
	}

	public void setNbTelefono(String nbTelefono) {
		this.nbTelefono = nbTelefono;
	}

	public Date getTmCreacion() {
		return this.tmCreacion;
	}

	public void setTmCreacion(Date tmCreacion) {
		this.tmCreacion = tmCreacion;
	}

	public Date getTmEdicion() {
		return this.tmEdicion;
	}

	public void setTmEdicion(Date tmEdicion) {
		this.tmEdicion = tmEdicion;
	}
	
	

	public String getIsCliente() {
		return isCliente;
	}

	public void setIsCliente(String isCliente) {
		this.isCliente = isCliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdAlterno == null) ? 0 : cdAlterno.hashCode());
		result = prime * result + ((cdCreador == null) ? 0 : cdCreador.hashCode());
		result = prime * result + ((cdEditor == null) ? 0 : cdEditor.hashCode());
		result = prime * result + ((cdPersona == null) ? 0 : cdPersona.hashCode());
		result = prime * result + ((cdTipoDoi == null) ? 0 : cdTipoDoi.hashCode());
		result = prime * result + ((cdTipoPersona == null) ? 0 : cdTipoPersona.hashCode());
		result = prime * result + ((isCliente == null) ? 0 : isCliente.hashCode());
		result = prime * result + ((nbEmail == null) ? 0 : nbEmail.hashCode());
		result = prime * result + ((nbMaterno == null) ? 0 : nbMaterno.hashCode());
		result = prime * result + ((nbNombre == null) ? 0 : nbNombre.hashCode());
		result = prime * result + ((nbNumDoi == null) ? 0 : nbNumDoi.hashCode());
		result = prime * result + ((nbPaterno == null) ? 0 : nbPaterno.hashCode());
		result = prime * result + ((nbTelefono == null) ? 0 : nbTelefono.hashCode());
		result = prime * result + ((tmCreacion == null) ? 0 : tmCreacion.hashCode());
		result = prime * result + ((tmEdicion == null) ? 0 : tmEdicion.hashCode());
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
		Persona other = (Persona) obj;
		if (cdAlterno == null) {
			if (other.cdAlterno != null)
				return false;
		} else if (!cdAlterno.equals(other.cdAlterno))
			return false;
		if (cdCreador == null) {
			if (other.cdCreador != null)
				return false;
		} else if (!cdCreador.equals(other.cdCreador))
			return false;
		if (cdEditor == null) {
			if (other.cdEditor != null)
				return false;
		} else if (!cdEditor.equals(other.cdEditor))
			return false;
		if (cdPersona == null) {
			if (other.cdPersona != null)
				return false;
		} else if (!cdPersona.equals(other.cdPersona))
			return false;
		if (cdTipoDoi == null) {
			if (other.cdTipoDoi != null)
				return false;
		} else if (!cdTipoDoi.equals(other.cdTipoDoi))
			return false;
		if (cdTipoPersona == null) {
			if (other.cdTipoPersona != null)
				return false;
		} else if (!cdTipoPersona.equals(other.cdTipoPersona))
			return false;
		if (isCliente == null) {
			if (other.isCliente != null)
				return false;
		} else if (!isCliente.equals(other.isCliente))
			return false;
		if (nbEmail == null) {
			if (other.nbEmail != null)
				return false;
		} else if (!nbEmail.equals(other.nbEmail))
			return false;
		if (nbMaterno == null) {
			if (other.nbMaterno != null)
				return false;
		} else if (!nbMaterno.equals(other.nbMaterno))
			return false;
		if (nbNombre == null) {
			if (other.nbNombre != null)
				return false;
		} else if (!nbNombre.equals(other.nbNombre))
			return false;
		if (nbNumDoi == null) {
			if (other.nbNumDoi != null)
				return false;
		} else if (!nbNumDoi.equals(other.nbNumDoi))
			return false;
		if (nbPaterno == null) {
			if (other.nbPaterno != null)
				return false;
		} else if (!nbPaterno.equals(other.nbPaterno))
			return false;
		if (nbTelefono == null) {
			if (other.nbTelefono != null)
				return false;
		} else if (!nbTelefono.equals(other.nbTelefono))
			return false;
		if (tmCreacion == null) {
			if (other.tmCreacion != null)
				return false;
		} else if (!tmCreacion.equals(other.tmCreacion))
			return false;
		if (tmEdicion == null) {
			if (other.tmEdicion != null)
				return false;
		} else if (!tmEdicion.equals(other.tmEdicion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persona [cdPersona=" + cdPersona + ", cdAlterno=" + cdAlterno + ", cdCreador=" + cdCreador
				+ ", cdEditor=" + cdEditor + ", cdTipoDoi=" + cdTipoDoi + ", cdTipoPersona=" + cdTipoPersona
				+ ", nbEmail=" + nbEmail + ", nbMaterno=" + nbMaterno + ", nbNombre=" + nbNombre + ", nbNumDoi="
				+ nbNumDoi + ", nbPaterno=" + nbPaterno + ", nbTelefono=" + nbTelefono + ", tmCreacion=" + tmCreacion
				+ ", tmEdicion=" + tmEdicion + ", isCliente=" + isCliente + "]";
	}

}