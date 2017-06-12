package pe.com.bbva.visitame.helper.geolocalizacion;


import java.net.ConnectException;
import java.util.concurrent.Future;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import pe.com.bbva.visitame.domain.geo.UbicationParser;
import pe.com.bbva.visitame.dominio.dto.zic.ZicResult;

@Component
@EnableAsync
public class GoogleMapsServiceHelper {

	private static final String INICIO_PARM = "?";
	private static final String IGUAL = "=";
	private static final String COMA = ",";
	private static final String Y = "&";
	
	private static final String ORIGEN = "origin";
	private static final String DESTINO = "destination";
	private static final String KEY = "key";
	
	@Value("${visitame.servicio.rest.google.url}")
	private String urlGoogleUbicacion;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Async
	public  Future<ZicResult> obtenerDatosUbicacion(String LatInicio, String LngInicio,String LatFin, String LngFin) throws  ConnectException {
		ZicResult resultService = null;
		
		StringBuilder url = new StringBuilder(urlGoogleUbicacion);

		resultService = new ZicResult();
		
		if(StringUtils.isNotBlank(LatInicio))
			url.append(INICIO_PARM).append(ORIGEN).append(IGUAL).append(LatInicio);
		
		if(StringUtils.isNotBlank(LngInicio))
			url.append(COMA).append(LngInicio);
	
		if(StringUtils.isNotBlank(LatFin))
			url.append(Y).append(DESTINO).append(IGUAL).append(LatFin);
			
		if(StringUtils.isNotBlank(LngFin))
			url.append(COMA).append(LngFin).append(Y).append(KEY).append(IGUAL).append("AIzaSyCa5vK_77v5kHLMhtJ8FVU8_pSDS9R_kiw");
			
		ResponseEntity<Object> responseEntity = null;
		try {
			
			responseEntity = restTemplate.exchange(url.toString(), HttpMethod.GET,null, Object.class);
		
			Gson gson = new Gson();
			resultService.setEntidad(new UbicationParser().parse(new JSONObject(gson.toJson(responseEntity.getBody()))));
		
		} catch (Exception e) {}
				
	    return new AsyncResult<ZicResult>(resultService);
	}	
}