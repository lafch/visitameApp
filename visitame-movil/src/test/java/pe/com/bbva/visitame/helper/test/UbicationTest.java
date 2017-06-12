package pe.com.bbva.visitame.helper.test;
import java.net.ConnectException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.bbva.visitame.dominio.dto.zic.ZicResult;
import pe.com.bbva.visitame.helper.geolocalizacion.GoogleMapsServiceHelper;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-Service.xml"})
public class UbicationTest {

	@Autowired
	private GoogleMapsServiceHelper GoogleMapsServiceHelper;
	
	@Test
	public void ubicacion() throws InterruptedException, ExecutionException {
		Future<ZicResult> tsec = null;
		try {
			tsec = GoogleMapsServiceHelper.obtenerDatosUbicacion("-12.1481427", "-77.0223221", "-12.142867", "-77.015037");

			System.out.println("-----");
			System.out.println(tsec.get().getEntidad().toString());
			System.out.println("-----");
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
