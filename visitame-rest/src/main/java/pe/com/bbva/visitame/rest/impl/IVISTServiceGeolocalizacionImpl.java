package pe.com.bbva.visitame.rest.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.bbva.visitame.dominio.dto.geolocalizacion.GeolocalizacionRequestParam;
import pe.com.bbva.visitame.dominio.dto.geolocalizacion.PoiDetail;
import pe.com.bbva.visitame.dominio.util.Constantes;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.exception.ValidacionException;
import pe.com.bbva.visitame.rest.IVISTServiceGeolocalizacio;
import pe.com.bbva.visitame.service.GeolocalizacionService;

@Component
public class IVISTServiceGeolocalizacionImpl implements IVISTServiceGeolocalizacio {

	@Autowired
	private GeolocalizacionService geolocalizacionService;

	@Override
	public Map<String, PoiDetail> listarUnidadAtencion(String latitud, String longitud, String radius,
			String filter, String startAt, String limit,String type) throws ValidacionException, NegocioException {
	

		GeolocalizacionRequestParam param = new GeolocalizacionRequestParam();
		
		if(Constantes.ETIQUETAS_POIS.TYPE_CAJERO.equals(type)){
			param.setFilter(Constantes.ETIQUETAS_POIS.FILTER_CAJERO);
		}else if(Constantes.ETIQUETAS_POIS.TYPE_OFICINA.equals(type)){
			param.setFilter(Constantes.ETIQUETAS_POIS.FILTER_OFICINA);
		}
		else if(Constantes.ETIQUETAS_POIS.TYPE_AGENTE.equals(type)){
			param.setFilter(Constantes.ETIQUETAS_POIS.FILTER_AGENTE);
		}
		
		param.setType(type);
		param.setLatitud(latitud);
		param.setLongitud(longitud);
		param.setRadius(radius);
		param.setStartAt(startAt);
		param.setLimit(limit);
		Map<String, PoiDetail> data = new HashMap<String, PoiDetail>();
		if(Constantes.ETIQUETAS_POIS.TYPE_OFICINA.equals(type)) {
			data.put("data", geolocalizacionService.obtenerPoisSaturacion(param));
		}else {
			data.put("data", geolocalizacionService.obtenerPois(param));
		}
		return data;
	}

}
