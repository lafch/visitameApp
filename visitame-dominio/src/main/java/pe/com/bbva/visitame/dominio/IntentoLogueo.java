package pe.com.bbva.visitame.dominio;

import java.io.Serializable;
import javax.persistence.*;

import pe.com.bbva.visitame.dominio.util.Constantes;

import java.util.Date;


/**
 * The persistent class for the tvisita005_seg_intento_logueo database table.
 * 
 */
@Entity
@Table(name="tvisita005_seg_intento_logueo" , schema=Constantes.SCHEMA.VIST)
public class IntentoLogueo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TVISITA005_SEG_INTENTO_LOGUEO_CDINTENTO_GENERATOR", sequenceName="appvisitame.SEQ_TVISITA005_SEG_INTENTO_LOGUEO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TVISITA005_SEG_INTENTO_LOGUEO_CDINTENTO_GENERATOR")
	@Column(name="cd_intento")
	private Integer cdIntento;

	@Column(name="cd_creador")
	private Integer cdCreador;

	@Column(name="cd_editor")
	private Integer cdEditor;

	@Column(name="cd_tipo_doi")
	private Integer cdTipoDoi;

	@Column(name="nb_id_dispositivo")
	private String nbIdDispositivo;

	@Column(name="nb_ip")
	private String nbIp;

	@Column(name="nb_login")
	private String nbLogin;

	@Column(name="nb_num_doi")
	private String nbNumDoi;

	@Column(name="nb_resultado")
	private String nbResultado;

	@Column(name="tm_creacion")
	private Date tmCreacion;

	@Column(name="tm_edicion")
	private Date tmEdicion;

	@Column(name="tm_hora_login")
	private Date tmHoraLogin;

	public IntentoLogueo() {
	}

	public Integer getCdIntento() {
		return this.cdIntento;
	}

	public void setCdIntento(Integer cdIntento) {
		this.cdIntento = cdIntento;
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

	public String getNbIdDispositivo() {
		return this.nbIdDispositivo;
	}

	public void setNbIdDispositivo(String nbIdDispositivo) {
		this.nbIdDispositivo = nbIdDispositivo;
	}

	public String getNbIp() {
		return this.nbIp;
	}

	public void setNbIp(String nbIp) {
		this.nbIp = nbIp;
	}

	public String getNbLogin() {
		return this.nbLogin;
	}

	public void setNbLogin(String nbLogin) {
		this.nbLogin = nbLogin;
	}

	public String getNbNumDoi() {
		return this.nbNumDoi;
	}

	public void setNbNumDoi(String nbNumDoi) {
		this.nbNumDoi = nbNumDoi;
	}

	public String getNbResultado() {
		return this.nbResultado;
	}

	public void setNbResultado(String nbResultado) {
		this.nbResultado = nbResultado;
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

	public Date getTmHoraLogin() {
		return this.tmHoraLogin;
	}

	public void setTmHoraLogin(Date tmHoraLogin) {
		this.tmHoraLogin = tmHoraLogin;
	}

}