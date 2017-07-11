package pe.com.bbva.visitame.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import pe.com.bbva.visitame.dominio.util.Constantes;

/**
 * The persistent class for the tvisita003_cfg_valor database table.
 * 
 */
@Entity
@Table(name="tvisita007_ofi_historico" , schema=Constantes.SCHEMA.VIST)
public class Historico implements Serializable {
	private static final long serialVersionUID = 1L;
	 // tvisita003_cfg_valor
	@Id
	@SequenceGenerator(name="TVISITA007_OFI_HISTORICO_CDHISTORICO_GENERATOR", sequenceName=Constantes.SCHEMA.VIST+".SEQ_TVISITA007_OFI_HISTORICO" , schema=Constantes.SCHEMA.VIST)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TVISITA007_OFI_HISTORICO_CDHISTORICO_GENERATOR")
	@Column(name="cd_historico")
	private Integer id;
	
	@Column(name="cd_alterno")
	private Integer codigo;

	@Column(name="nu_telefono")
	private String telefono;

	@Column(name="nb_correo")
	private String correo;
	
	@Column(name="cd_creador")
	private Integer creador;
	
	@Column(name="cd_editor")
	private Integer editor;
	
	@Column(name="tm_creacion")
	private Date tmCreacion;

	@Column(name="tm_edicion")
	private Date tmEdicion;

	
	@ManyToOne
	@JoinColumn(name="cd_persona")
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name="cd_est_envio")
	private Valor estadoEnvio;
	
	@ManyToOne
	@JoinColumn(name="cd_tip_operador")
	private Valor tipoOperador;

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
	public Integer getCodigo() { return codigo; }
	public void setCodigo(Integer codigo) { this.codigo = codigo; }
	
	public String getTelefono() { return telefono; }
	public void setTelefono(String telefono) { this.telefono = telefono; }
	
	public String getCorreo() { return correo; }
	public void setCorreo(String correo) { this.correo = correo; }
	
	public Integer getCreador() { return creador; }
	public void setCreador(Integer creador) { this.creador = creador; }
	
	public Integer getEditor() { return editor; }
	public void setEditor(Integer editor) { this.editor = editor; }
	
	public Date getTmCreacion() { return tmCreacion; }
	public void setTmCreacion(Date tmCreacion) { this.tmCreacion = tmCreacion; }
	
	public Date getTmEdicion() { return tmEdicion; }
	public void setTmEdicion(Date tmEdicion) { this.tmEdicion = tmEdicion; }
	
	public Persona getPersona() { return persona; }
	public void setPersona(Persona persona) { this.persona = persona; }

	public Valor getEstadoEnvio() { return estadoEnvio; }
	
	public void setEstadoEnvio(Valor estadoEnvio) { this.estadoEnvio = estadoEnvio; }
	
	public Valor getTipoOperador() { return tipoOperador; }
	public void setTipoOperador(Valor tipoOperador) { this.tipoOperador = tipoOperador; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((creador == null) ? 0 : creador.hashCode());
		result = prime * result + ((editor == null) ? 0 : editor.hashCode());
		result = prime * result + ((estadoEnvio == null) ? 0 : estadoEnvio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((tipoOperador == null) ? 0 : tipoOperador.hashCode());
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
		Historico other = (Historico) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (creador == null) {
			if (other.creador != null)
				return false;
		} else if (!creador.equals(other.creador))
			return false;
		if (editor == null) {
			if (other.editor != null)
				return false;
		} else if (!editor.equals(other.editor))
			return false;
		if (estadoEnvio == null) {
			if (other.estadoEnvio != null)
				return false;
		} else if (!estadoEnvio.equals(other.estadoEnvio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (tipoOperador == null) {
			if (other.tipoOperador != null)
				return false;
		} else if (!tipoOperador.equals(other.tipoOperador))
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
		return "Historico [id=" + id + ", codigo=" + codigo + ", telefono=" + telefono + ", correo=" + correo
				+ ", creador=" + creador + ", editor=" + editor + ", tmCreacion=" + tmCreacion + ", tmEdicion="
				+ tmEdicion + ", persona=" + persona + ", estadoEnvio=" + estadoEnvio + ", tipoOperador=" + tipoOperador
				+ "]";
	}	
}