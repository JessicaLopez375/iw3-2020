package ar.edu.iua.business;

import java.util.List;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Producto;


public interface IProductoBusiness {

	public Producto load(Long id) throws NotFoundException, BusinessException;

	public List<Producto> list() throws BusinessException;
	
	public List<Producto> list(String parte) throws BusinessException, NotFoundException;

	public Producto add(Producto producto) throws BusinessException;
	
	public Producto update(Producto producto) throws NotFoundException, BusinessException;

	public void delete(Long id) throws NotFoundException, BusinessException;
	
	public List<Producto> list(double precio, String busqueda) throws NotFoundException, BusinessException;
	
	public List<Producto> list(char firstLetter ) throws BusinessException, NotFoundException;
	
	public void updateByElId(Long id) throws NotFoundException, BusinessException;
	public void updateByLaDescripcion(String descripcion) throws NotFoundException, BusinessException;
	
	

}
