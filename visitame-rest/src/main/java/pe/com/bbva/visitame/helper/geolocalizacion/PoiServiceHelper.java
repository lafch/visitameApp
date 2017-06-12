package pe.com.bbva.visitame.helper.geolocalizacion;

import java.net.ConnectException;
import java.text.MessageFormat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import pe.com.bbva.visitame.dominio.dto.geolocalizacion.GeolocalizacionRequestParam;
import pe.com.bbva.visitame.dominio.dto.zic.ZicResult;
import pe.com.bbva.visitame.exception.NegocioException;

@Component
public class PoiServiceHelper {

	@Value("${visitame.servicio.rest.pois.url}")
	private String urlPois;	
	
	@Value("${visitame.servicio.rest.pois.header.authorization}")
	private String headerAuthorization;	
	
	public ZicResult obtenerGeolocalizaconsPois(GeolocalizacionRequestParam param) throws NegocioException, ConnectException {

		RestTemplate restTemplate = new RestTemplate();
		ZicResult resultService = new ZicResult();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", headerAuthorization);
		StringBuilder url = new StringBuilder(urlPois);
		StringBuilder parametrosEnvio = new StringBuilder(StringUtils.EMPTY);
		
		if(param == null){ param = new GeolocalizacionRequestParam(); }
		if(StringUtils.isBlank(param.getStartAt())){
			param.setStartAt("0");
		}
		if(StringUtils.isBlank(param.getLimit())){
			param.setLimit("10");
		}
		if(StringUtils.isBlank(param.getRadius())){
			param.setRadius("5000");
		}
		parametrosEnvio.append(
					MessageFormat.format(
							"?latitude={0}&longitude={1}&filter={2}&limit={3}&startAt={4}&radius={5}"
							,param.getLatitud()
							,param.getLongitud()
							,param.getFilter()
							,param.getLimit()
							,param.getStartAt()
							,param.getRadius()
							)
					);
		
		url.append(parametrosEnvio.toString());
		
		ResponseEntity<String> responseEntity = null;
		try {
			responseEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, new HttpEntity<String>(headers), String.class);
			resultService.setEntidad(responseEntity.getBody());
		} catch (Exception e) { resultService.calcularError(e); } 
	
		return resultService;
	}
	
}
