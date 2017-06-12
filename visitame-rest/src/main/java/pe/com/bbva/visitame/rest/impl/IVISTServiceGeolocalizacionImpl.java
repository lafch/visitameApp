package pe.com.bbva.visitame.rest.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.bbva.visitame.dominio.dto.gelocalizacion.GeolocalizacionRequestParam;
import pe.com.bbva.visitame.dominio.dto.gelocalizacion.ResultGeolocalizacion;
import pe.com.bbva.visitame.dominio.util.Constantes;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.exception.ValidacionException;
import pe.com.bbva.visitame.rest.IVISTServiceGeolocalizacion;
import pe.com.bbva.visitame.service.GeolocalizacionService;

@Component
public class IVISTServiceGeolocalizacionImpl implements IVISTServiceGeolocalizacion {

	@Autowired
	private GeolocalizacionService geolocalizacionService;

	@Override
	public Map<String, ResultGeolocalizacion> obtenerOficinas(String latitud, String longitud, String radius,
			String filter, String startAt, String limit,String type) throws ValidacionException, NegocioException {
		GeolocalizacionRequestParam param = new GeolocalizacionRequestParam();
		
		if(Constantes.ETIQUETAS_POIS.TYPE_CAJERO.equals(type)){
			param.setFilter(Constantes.ETIQUETAS_POIS.FILTER_CAJERO);
		}else if(Constantes.ETIQUETAS_POIS.TYPE_OFICINA.equals(type)){
			param.setFilter(Constantes.ETIQUETAS_POIS.FILTER_OFICINA);
		}
		param.setType(type);
		param.setLatitud(latitud);
		param.setLongitud(longitud);
		param.setRadius(radius);
		Map<String, ResultGeolocalizacion> data = new HashMap<String, ResultGeolocalizacion>();
		data.put("data", geolocalizacionService.obtenerPois(param));
		return data;
	}

}
