package ar.edu.iua.business;


import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Proveedor;

public interface IProveedorBusiness {

	public Proveedor find(int id) throws BusinessException, NotFoundException;
}
