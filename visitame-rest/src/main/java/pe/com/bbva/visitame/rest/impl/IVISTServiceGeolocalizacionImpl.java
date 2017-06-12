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
import pe.com.bbva.visitame.rest.IVISTServicePois;
import pe.com.bbva.visitame.service.GeolocalizacionService;

@Component
public class IVISTServiceGeolocalizacionImpl implements IVISTServicePois {

	@Autowired
	private GeolocalizacionService geolocalizacionService;

	@Override
	public Map<String, PoiDetail> obtenerOficinas(String latitud, String longitud, String radius,
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
		Map<String, PoiDetail> data = new HashMap<String, PoiDetail>();
		data.put("data", geolocalizacionService.obtenerPois(param));
		return data;
	}

}
