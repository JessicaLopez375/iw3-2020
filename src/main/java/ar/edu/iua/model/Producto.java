package ar.edu.iua.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="produtos")
public class Producto implements Serializable {

	private static final long serialVersionUID = 5081791146397214235L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String nombre;
	
	@Column(length = 200)
	private String descripcion;
	
	
	private double precioLista;
	
	
	@Column(columnDefinition = "TINYINT DEFAULT 0")
	private boolean enStock;
	
	@OneToOne(cascade =  CascadeType.ALL)
	private ProductoDetalle productoDetalle;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="producto_venta_detalle",
			   joinColumns = @JoinColumn(name ="producto_id"),
			   inverseJoinColumns = @JoinColumn(name = "venta_id"))
	
	private List<Venta> ventaList; 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioLista() {
		return precioLista;
	}

	public void setPrecioLista(double precioLista) {
		this.precioLista = precioLista;
	}

	public boolean isEnStock() {
		return enStock;
	}

	public void setEnStock(boolean enStock) {
		this.enStock = enStock;
	}

	public List<Venta> getVentasList() {
		return ventasList;
	}

	public void setVentasList(List<Venta> ventasList) {
		this.ventasList = ventasList;
	}

	

	

}
