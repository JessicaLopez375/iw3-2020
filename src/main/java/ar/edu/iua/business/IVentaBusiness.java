package ar.edu.iua.business;


import java.util.List;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Venta;

public interface IVentaBusiness {

	public List<Venta> findByTotal(double total) throws BusinessException, NotFoundException; 
	public List<Venta> list() throws BusinessException, NotFoundException; 
}
