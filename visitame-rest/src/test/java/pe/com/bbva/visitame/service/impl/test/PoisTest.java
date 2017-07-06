package pe.com.bbva.visitame.service.impl.test;

import java.util.HashMap;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;

import pe.com.bbva.visitame.dominio.dto.geolocalizacion.GeolocalizacionRequestParam;
import pe.com.bbva.visitame.dominio.dto.geolocalizacion.Poi;
import pe.com.bbva.visitame.dominio.dto.geolocalizacion.PoiDetail;
import pe.com.bbva.visitame.dominio.util.Constantes;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.service.GeolocalizacionService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
									"classpath:test-context-datasource.xml",
									"classpath:spring/applicationContext-Service.xml" 
									}) 
public class PoisTest {
	
	
	@Autowired
	private GeolocalizacionService geolocalizacionService; 
	
	@Test
	public void testGeoPoisSaturacion() throws NegocioException {
	GeolocalizacionRequestParam param = new GeolocalizacionRequestParam();
	
		String type = "O";
		String latitud = "-12.094307";
		String longitud = "-77.021424";
		String radius = "5000";
		String startAt = "0";
		String limit = "20";

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
		
		geolocalizacionService.obtenerPoisSaturacion(param);
		
	}
	
	@Test
	public void testGeoPois() throws NegocioException {
	GeolocalizacionRequestParam param = new GeolocalizacionRequestParam();
	
		String type = "O";
		String latitud = "-12.094307";
		String longitud = "-77.021424";
		String radius = "5000";
		String startAt = "0";
		String limit = "20";

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
		
	    PoiDetail detail = geolocalizacionService.obtenerPois(param);
		
	    Gson gson = new Gson();
	    System.out.println(gson.toJson(detail));
	    
	}

}
