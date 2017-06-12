package pe.com.bbva.visitame.service.impl;

import java.net.ConnectException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import pe.com.bbva.visitame.dominio.dto.cuenta.CustomerDetail;
import pe.com.bbva.visitame.dominio.dto.zic.ZicResult;
import pe.com.bbva.visitame.dominio.util.Constantes;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.helper.cuenta.ZICServiceAccountHelper;
import pe.com.bbva.visitame.service.AccountService;

@Service
public class AccountServiceImpl extends BaseServiceImpl implements AccountService {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ZICServiceAccountHelper zicServiceAccountHelper;
	
	@Autowired
	private MessageSource messageSource;

	@Override
	public CustomerDetail getCustomer(String documentNumber, String documentType) throws NegocioException {

		CustomerDetail customerDetail = null;
		try {
			
			ZicResult result =  zicServiceAccountHelper.getListCustomers(documentNumber, documentType);
			if(result.getCodeError() != null){
				lanzarExcepcionLeve(result.getCodeError(), new Object[]{}, result.getMessageError(), null);
			}
			customerDetail = (CustomerDetail)result.getEntidad();
			return customerDetail;
		} catch (ConnectException e) {
			throw new NegocioException(messageSource.getMessage(Constantes.MENSAJE.ERROR_ZIC_SERVICIO_DEFAULT, null, "", new Locale("es")));
		}
		
		
	}

}
