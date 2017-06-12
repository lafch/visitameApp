package pe.com.bbva.visitame.service;

import pe.com.bbva.visitame.dominio.dto.cuenta.CustomerDetail;
import pe.com.bbva.visitame.exception.NegocioException;

public interface AccountService {

	CustomerDetail getCustomer( String documentNumber , String documentType) throws NegocioException;
}
