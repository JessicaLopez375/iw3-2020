package ar.edu.iua.business;


import java.util.List;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Proveedor;
import ar.edu.iua.model.ProveedorDTO;

public interface IProveedorBusiness {

	public Proveedor find(int id) throws BusinessException, NotFoundException;
	public  List<Proveedor> findByPrecioMayor(double precioBase) throws BusinessException, NotFoundException;
	public  List<ProveedorDTO> findAllProveedores() throws BusinessException;
}
