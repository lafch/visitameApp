package pe.com.bbva.visitame.service.impl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.bbva.visitame.dao.OficinaDAO;
import pe.com.bbva.visitame.dominio.Oficina;
import pe.com.bbva.visitame.dominio.dto.geolocalizacion.GeolocalizacionRequestParam;
import pe.com.bbva.visitame.dominio.dto.geolocalizacion.Poi;
import pe.com.bbva.visitame.dominio.dto.geolocalizacion.PoiDetail;
import pe.com.bbva.visitame.dominio.util.Constantes;
import pe.com.bbva.visitame.exception.DAOException;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.service.GeolocalizacionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
									"classpath:test-context-datasource.xml",
									"classpath:spring/applicationContext-Service.xml" 
									}) 
public class DummyOficinas {
	
	@Autowired
	private GeolocalizacionService geolocalizacionService; 
	
	@Autowired
	private OficinaDAO oficinaDAO;
	
	@Test
	public void setDataOficinasDummy() throws NegocioException, DAOException {
	GeolocalizacionRequestParam param = new GeolocalizacionRequestParam();
	
		String type = "O";
		String latitud = "-12.094307";
		String longitud = "-77.021424";
		String radius = "1000000";
		String startAt = "0";
		String limit = "400";
	//-12.094307, -77.021424
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
		System.out.println("Total de pois = "+detail.getPois().size());
		
		Oficina oficina = null;
		
		for (Poi poi : detail.getPois()) {
			oficina = new Oficina();
			oficina.setCodigo(poi.getCodoficina());
			oficina.setNombreOficina(poi.getDescription());
			oficina.setDireccion(poi.getAddress());
			oficina.setSecuenciaTicket(0);
			oficinaDAO.crear(oficina);
		}
		
//		Map<String, PoiDetail> data = new HashMap<String, PoiDetail>();
//		data.put("data", geolocalizacionService.obtenerPois(param));
//		Gson gson = new Gson();
//		System.out.println(gson.toJson(data));
		
	}
	

}
