package ar.edu.iua.model.persistence;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.iua.model.Producto;


//https://docs.spring.io/spring-data/jpa/docs/2.3.2.RELEASE/reference/html/#repositories.query-methods.details

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	public List<Producto> findByNombreContainingOrDescripcionContainingOrderByNombreDesc(String nombre, String descripcion);
	
	public List<Producto> findByPrecioListaGreaterThan(double precio);
	
	public List<Producto> findByPrecioListaLessThan(double precio);
	
	public List<Producto> findAllByOrderByPrecioListaAsc(); 
	
	public List<Producto> findAllByNombreStartingWith(char firstLetter ); 
	
	@Query(value = "UPDATE productos set en_stock = 1 where id = ?1", nativeQuery = true)
	public void updateByElId(Long id);
	
	@Query(value = "UPDATE productos set en_stock = 1 where descripcion = ?1", nativeQuery = true)
	public void updateByLaDescripcion(String descripcion);
	
}

