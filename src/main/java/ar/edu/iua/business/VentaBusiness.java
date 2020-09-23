package ar.edu.iua.business;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Venta;
import ar.edu.iua.model.persistence.VentaRepository;

@Service
public class VentaBusiness implements IVentaBusiness {
	
	@Autowired
	private VentaRepository ventaDAO; 

	
	@Override
	public List<Venta> findByTotal(double total) throws BusinessException, NotFoundException {
		List<Venta> v; 
		
		try {
			v = ventaDAO.findByTotal(total); 
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
		if(v.isEmpty())
		{
			throw new NotFoundException("No se registran ventas en la fecha "+total);
		}
		
		return v; 
	}

	@Override
	public List<Venta> list() throws BusinessException, NotFoundException {
		
		List<Venta> v; 
				
		try {
			v = ventaDAO.findAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
		if(v.isEmpty())
		{
			throw new NotFoundException("No se registran ventas");
		}
		
		return v; 
	}

	@Override
	public List<Venta> findByProductoListNombre(String nombre) throws BusinessException, NotFoundException {

		List<Venta> v; 
				
		try {
			v = ventaDAO.findByProductoListNombre(nombre);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
		if(v.isEmpty())
		{
			throw new NotFoundException("No se registran ventas de ese producto");
		}
		
		return v; 
	}

	


	
}
