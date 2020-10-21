package ar.edu.iua.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ventas")

@NamedNativeQuery(name = "Venta.findByElProducto", 
	query = "select v.total from productos as p\n"
			+ "inner join producto_venta_detalle as pvd\n" + 
			"on p.id = pvd.producto_id inner join ventas as v on v.id = pvd.venta_id\n" + 
			"where p.nombre = ?1", 
	resultSetMapping = "ventamap")

@SqlResultSetMapping(
        name="ventamap",
		classes = { @ConstructorResult(columns = { @ColumnResult(name = "v.total", type = Double.class)},
		targetClass = VentaDTO.class) })

public class Venta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(mappedBy = "ventaList")
	@JsonBackReference
	private List<Producto> productoList;
	
	private double total;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Producto> getProductoList() {
		return productoList;
	}

	public void setProductoList(List<Producto> productoList) {
		this.productoList = productoList;
	}


	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}


	
	
}
