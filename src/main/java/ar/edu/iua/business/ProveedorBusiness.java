package ar.edu.iua.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Proveedor;
import ar.edu.iua.model.ProveedorDTO;
import ar.edu.iua.model.persistence.ProveedorRepository;

@Service
public class ProveedorBusiness implements IProveedorBusiness {

	@Autowired
	private ProveedorRepository proveedorDAO; 
	
	@Override
	public Proveedor find(int id) throws BusinessException, NotFoundException {
		
		Optional<Proveedor> p;
		try {
			p = proveedorDAO.findById(id); 
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if (!p.isPresent()) {
			throw new NotFoundException("El proveedor con id " + id + " no se encuentra en la BD");
		}
		return p.get();
		
		
	}

	@Override
	public List<Proveedor> findByPrecioMayor(double precioBase) throws BusinessException, NotFoundException {
		
		 List <Proveedor> proveedores = null;
	        try {
	            
	            proveedores = proveedorDAO.findByPrecioMayor(precioBase);
	        } catch (Exception e) {
	            throw new BusinessException(e);
	        }
	        if (proveedores == null)
	            throw new NotFoundException("No se encuentra el producto con precio mayor a " + precioBase);
	       
	        return proveedores; 
	}

	@Override
	public List<ProveedorDTO> findAllProveedores() throws BusinessException {
		
		try {
			return proveedorDAO.findAllProveedores();
		} catch ( Exception e) {
			throw new BusinessException(e);
		}
		
	}
	

	

}
