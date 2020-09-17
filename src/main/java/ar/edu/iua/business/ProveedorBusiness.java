package ar.edu.iua.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Proveedor;
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

}
