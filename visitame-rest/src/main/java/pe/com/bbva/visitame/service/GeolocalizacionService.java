package pe.com.bbva.visitame.service;

import pe.com.bbva.visitame.dominio.dto.geolocalizacion.GeolocalizacionRequestParam;
import pe.com.bbva.visitame.dominio.dto.geolocalizacion.PoiDetail;
import pe.com.bbva.visitame.exception.NegocioException;

public interface GeolocalizacionService {

	PoiDetail obtenerPois(GeolocalizacionRequestParam param)  throws NegocioException;
	
	PoiDetail obtenerPoisSaturacion(GeolocalizacionRequestParam param)  throws NegocioException;
}
