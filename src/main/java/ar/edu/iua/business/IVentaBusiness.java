package ar.edu.iua.business;

import java.util.Date;
import java.util.List;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Venta;

public interface IVentaBusiness {

	public List<Venta> findByFecha(Date fecha) throws BusinessException, NotFoundException; 
	public List<Venta> list() throws BusinessException, NotFoundException; 
}
