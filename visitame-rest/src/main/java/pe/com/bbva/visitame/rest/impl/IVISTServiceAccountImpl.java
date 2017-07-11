package pe.com.bbva.visitame.rest.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.com.bbva.visitame.dominio.dto.cuenta.CustomerDetail;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.exception.ValidacionException;
import pe.com.bbva.visitame.rest.IVISTServiceAccount;
import pe.com.bbva.visitame.service.AccountService;

@Component
public class IVISTServiceAccountImpl implements IVISTServiceAccount {

	@Autowired
	private AccountService accountService;
	
	@Override
	public Map<String, Object> validarUsuario(String documentNumber, String documentType , String desDocumentType , String captchaResponse , String ipRemote, String codOficina)
			throws ValidacionException, NegocioException {
		return accountService.validarUsuario(documentNumber,documentType,desDocumentType , captchaResponse , ipRemote, codOficina);
	}

	@Override
	public CustomerDetail getCustomer(String documentNumber, String documentType, String test)
			throws ValidacionException, NegocioException {
		CustomerDetail customerDetail  = accountService.getCustomer(documentNumber, documentType,test);
		return customerDetail;
	}

	@Override
	public Map<String, Object>  actualizarDatosContacto(String documentNumber, String documentType, String email, String telefono,
			String tipoOperador)
			throws ValidacionException, NegocioException {
		return accountService.actualizarDatosContacto(documentNumber,documentType,email,telefono, tipoOperador);
	}
	
}
