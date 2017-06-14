package pe.com.bbva.visitame.rest.impl;

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
	public CustomerDetail getCustomer(String documentNumber, String documentType)
			throws ValidacionException, NegocioException {
		CustomerDetail customerDetail = accountService.getCustomer(documentNumber, documentType);
		return customerDetail;
	}

}