package ar.edu.iua.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Producto;
import ar.edu.iua.model.persistence.ProductoRepository;

@Service
public class ProductoBusiness implements IProductoBusiness {

	@Autowired
	private ProductoRepository productoDAO;

	@Override
	public Producto load(Long id) throws NotFoundException, BusinessException {
		Optional<Producto> op;
		try {
			op = productoDAO.findById(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if (!op.isPresent()) {
			throw new NotFoundException("El producto con id " + id + " no se encuentra en la BD");
		}
		return op.get();
	}

	@Override
	public List<Producto> list() throws BusinessException {
		try {
			return productoDAO.findAllByOrderByPrecioListaAsc(); //findAll()
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Producto add(Producto producto) throws BusinessException {
		try {
			return productoDAO.save(producto);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void delete(Long id) throws NotFoundException, BusinessException {
		try {
			productoDAO.deleteById(id);
		} catch (EmptyResultDataAccessException e1) {
			throw new NotFoundException("No se encuentra el producto id=" + id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public Producto update(Producto producto) throws NotFoundException, BusinessException {

		load(producto.getId());
		return add(producto);
		/*
		 * Optional<Producto> op; try { op = productoDAO.findById(producto.getId()); }
		 * catch(Exception e) { throw new BusinessException(); }
		 * 
		 * if(!op.isPresent()) { throw new
		 * NotFoundException("No se encontro el producto con id "+ producto.getId()); }
		 * return productoDAO.save(producto);
		 */
	}

	@Override
	public List<Producto> list(String parte) throws BusinessException, NotFoundException {
		List<Producto> p = null; 
		try {
			p = productoDAO.findByNombreContainingOrDescripcionContainingOrderByNombreDesc(parte, parte);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
		if(p.isEmpty())
		{
			throw new NotFoundException("No se encontraron productos que contengan " + parte + " en su descripcion");
		}
		
		return p; 
	}

	@Override
	public List<Producto> list(double precio, String busqueda) throws NotFoundException, BusinessException {
		List<Producto> op= null;

		try {
			if (busqueda.equalsIgnoreCase("mayor")) {
				op = productoDAO.findByPrecioListaGreaterThan(precio);
			}
			if (busqueda.equalsIgnoreCase("menor")) {
				op = productoDAO.findByPrecioListaLessThan(precio);
			}

		} catch (Exception e) {
			throw new BusinessException(e);
		}
		
		if(op.isEmpty())
		{
			throw new NotFoundException("No existen productos con precio "+ busqueda + precio); 
		}
		return op;
	}

	@Override
	public List<Producto> list(char firstLetter) throws BusinessException, NotFoundException {
		List<Producto> p = null; 
		
		try {
			p = productoDAO.findAllByNombreStartingWith(firstLetter);
		} catch(Exception e) {
			throw new BusinessException(e);
		}
		
		if(p.isEmpty())
		{
			throw new NotFoundException("No existen productos cuyo nombre empiece con " + firstLetter);
		}
		return p;
	}
	

}

//@Autowired
//private IProductoBusiness productoBusiness
