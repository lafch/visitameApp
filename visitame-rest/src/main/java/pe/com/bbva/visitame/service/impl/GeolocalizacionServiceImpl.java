package pe.com.bbva.visitame.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bbva.visitame.dominio.Valor;
import pe.com.bbva.visitame.dominio.dto.geolocalizacion.GeolocalizacionRequestParam;
import pe.com.bbva.visitame.dominio.dto.geolocalizacion.Poi;
import pe.com.bbva.visitame.dominio.dto.geolocalizacion.PoiDetail;
import pe.com.bbva.visitame.dominio.dto.zic.ZicResult;
import pe.com.bbva.visitame.dominio.util.Constantes;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.helper.geolocalizacion.PoiServiceHelper;
import pe.com.bbva.visitame.service.ConfiguracionService;
import pe.com.bbva.visitame.service.GeolocalizacionService;
import pe.com.bbva.visitame.util.MathUtil;

import java.io.StringReader;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Service
public class GeolocalizacionServiceImpl extends BaseServiceImpl implements GeolocalizacionService {

	private static final long serialVersionUID = 1229565922149112061L;
	
	@Autowired
	private PoiServiceHelper geolocalizacionServiceHelper;
	
	@Autowired
	private ConfiguracionService configuracionService;
	
	@Override
	public PoiDetail obtenerPois(GeolocalizacionRequestParam param) throws NegocioException {
		PoiDetail resultGeolocalizacion = new PoiDetail();
		resultGeolocalizacion.setType(param.getType());
		try {
			
			ZicResult resultStringXml = geolocalizacionServiceHelper.obtenerGeolocalizaconsPois(param);
			
			if(resultStringXml.getCodeError() != null){
				lanzarExcepcionMedia(resultStringXml.getCodeError(), new Object[]{}, resultStringXml.getMessageError(), null);
			}
						
			List<Poi> pois = new ArrayList<Poi>();
		
			DocumentBuilderFactory odbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder odb =  odbf.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(resultStringXml.getEntidad().toString()));
	        Document odoc = odb.parse(is);
            odoc.getDocumentElement().normalize ();   
            NodeList listResult = odoc.getElementsByTagName("Result");
            
            for(int k = 0; k < listResult.getLength() ; k++)
            {
            	Node objresult = listResult.item(k);
            	if (objresult.getNodeType() == Node.ELEMENT_NODE) {
            		Element eElement = (Element) objresult;
            		resultGeolocalizacion.setValue(eElement.getElementsByTagName("Value").item(0).getTextContent());
            		resultGeolocalizacion.setHasMoreData(Boolean.parseBoolean(eElement.getElementsByTagName("HasMoreData").item(0).getTextContent()));
            	}
            }

            NodeList listPoi = odoc.getElementsByTagName("Poi");

            for(int j =0; j < listPoi.getLength() ; j++)
            {
                Node objPoi = listPoi.item(j);
            	if (objPoi.getNodeType() == Node.ELEMENT_NODE) {
        			Element eElement = (Element) objPoi;
        			pois.add(this.getPoi(eElement));
        		}
            }
            
            resultGeolocalizacion.setPois(pois);
			
		} catch (Exception e) {
			lanzarExcepcionGrave(NegocioException.CODIGO.NEG_ERROR_INESPERADO, null, "Ocurrio un error inesperdado", e);
		}
		
		return resultGeolocalizacion;
	}
	
	public void setSaturacion(Poi poi , List<Valor> rangosSaturacion) throws NegocioException {
		//call servicio rest recibe codOficina
		//para obtencion de satutacion cuando este disponible
		Integer saturacion = MathUtil.generateRandom(1, 20);
		poi.setSaturacion(saturacion.toString().toString());
		
		Integer saturacionBaja = null, saturacionMedia = null, saturacionAlta = null;  
        
		String saturacionVerde = null, saturacionAmarillo = null,  saturacionMorado = null;
		
		for (Valor valor : rangosSaturacion) {
			if(Constantes.EstadosSaturacion.BAJA.toString().equals(valor.getCdAlterno())) {
				saturacionBaja = Integer.parseInt(valor.getNbValor());
				saturacionVerde = valor.getIcono();
			}else if(Constantes.EstadosSaturacion.MEDIA.toString().equals(valor.getCdAlterno())) {
				saturacionMedia = Integer.parseInt(valor.getNbValor());
				saturacionAmarillo = valor.getIcono();
			}else if(Constantes.EstadosSaturacion.ALTA.toString().equals(valor.getCdAlterno())) {
				saturacionAlta = Integer.parseInt(valor.getNbValor());
				saturacionMorado = valor.getIcono();
			}
		}
		
		if(saturacion > 0 && saturacion <= saturacionBaja) {
			poi.setIconoSaturacion(saturacionVerde);
		}else if(saturacion > saturacionBaja && saturacion <= saturacionAlta) {
			poi.setIconoSaturacion(saturacionAmarillo);
		}else if(saturacion > saturacionAlta) {
			poi.setIconoSaturacion(saturacionMorado);
		}

	}
	
	public PoiDetail obtenerPoisSaturacion(GeolocalizacionRequestParam param) throws NegocioException {
		PoiDetail poiDetail = obtenerPois(param);
		List<Valor> rangosSaturacion = configuracionService.listarValores(Constantes.LISTA.LISTA_SATURACION_OFI);
		for(Poi poi : poiDetail.getPois()) {
			this.setSaturacion(poi,rangosSaturacion);
		}
		return poiDetail;
	}

	
	private Poi getPoi(Element eElement){
		
			Poi poi = new Poi();
			poi.setIdPoi(eElement.getElementsByTagName("IdPoi").item(0).getTextContent());
			poi.setCategory(eElement.getElementsByTagName("Category").item(0).getTextContent());
			poi.setLatitude(eElement.getElementsByTagName("Latitude").item(0).getTextContent());
			poi.setLongitude(eElement.getElementsByTagName("Longitude").item(0).getTextContent());
			poi.setCountry(eElement.getElementsByTagName("Country").item(0).getTextContent());
			
			NodeList listAttributes  = eElement.getElementsByTagName("PoiAttribute");
			
			for (int i = 0; i < listAttributes.getLength(); i++) {
				Node objAttribute = listAttributes.item(i);
				if (objAttribute.getNodeType() == Node.ELEMENT_NODE) {
					Element eElementAttributte = (Element) objAttribute;
					//MASTER-->
					if(Constantes.ETIQUETAS_POIS.ADDRESS.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setAddress(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}else if(Constantes.ETIQUETAS_POIS.ADDRESS1.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setAddress1(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}else if(Constantes.ETIQUETAS_POIS.ADDRESS2.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setAddress2(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}else if(Constantes.ETIQUETAS_POIS.DESCRIPTION.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setDescription(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}else if(Constantes.ETIQUETAS_POIS.TELEPHONE.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setTelephone(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}else if(Constantes.ETIQUETAS_POIS.CITY.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setCity(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}else if(Constantes.ETIQUETAS_POIS.ACCESIBILITY.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setAccesibility(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}else if(Constantes.ETIQUETAS_POIS.ID.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setId(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}else if(Constantes.ETIQUETAS_POIS.ZIP.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setZip(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}else if(Constantes.ETIQUETAS_POIS.BANK.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setBank(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}else if(Constantes.ETIQUETAS_POIS.PROVINCE.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setProvince(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}else if(Constantes.ETIQUETAS_POIS.ACCESIBILITY_ACTION.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setAccesibility_action(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}else if(Constantes.ETIQUETAS_POIS.DISTANCE.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setDistance(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}
					//CAJERO-->
					else if(Constantes.ETIQUETAS_POIS.STATUS.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setStatus(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}else if(Constantes.ETIQUETAS_POIS.BRANCH_CODE.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setBranch_code(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}
					//OFICINA-->
					else if(Constantes.ETIQUETAS_POIS.HOURS_SAT.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setHours_sat(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}else if(Constantes.ETIQUETAS_POIS.HOURS_MF.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setHours_mf(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}else if(Constantes.ETIQUETAS_POIS.CODOFICINA.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setCodoficina(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}else if(Constantes.ETIQUETAS_POIS.HOURS_SUN.equals
							(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_NAME).item(0).getTextContent())){
						poi.setHours_sun(eElementAttributte.getElementsByTagName(Constantes.ETIQUETAS_POIS.ATTR_VALUE).item(0).getTextContent());
					}
					
				}
			}
			
		
		return poi;
	}
	
}
