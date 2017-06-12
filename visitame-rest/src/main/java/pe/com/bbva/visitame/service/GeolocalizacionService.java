package pe.com.bbva.visitame.service;

import pe.com.bbva.visitame.dominio.dto.gelocalizacion.GeolocalizacionRequestParam;
import pe.com.bbva.visitame.dominio.dto.gelocalizacion.ResultGeolocalizacion;
import pe.com.bbva.visitame.exception.NegocioException;

public interface GeolocalizacionService {

	ResultGeolocalizacion obtenerPois(GeolocalizacionRequestParam param)  throws NegocioException;
	
}
