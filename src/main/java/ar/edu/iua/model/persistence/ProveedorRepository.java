package ar.edu.iua.model.persistence;


import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.iua.model.Proveedor;
import ar.edu.iua.model.ProveedorDTO;
import ar.edu.iua.model.VentaDTO;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
	
	@Query(value = "select pro.id, pro.nombre from productos as p inner join proveedor as pro \n" + 
	"on p.proveedor_id = pro.id where p.precio_lista >=?1", nativeQuery = true)
	public List<Proveedor> findByPrecioMayor(double precio);
	public List<ProveedorDTO> findAllProveedores();
	

}
