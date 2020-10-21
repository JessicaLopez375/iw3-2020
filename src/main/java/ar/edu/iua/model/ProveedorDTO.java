package ar.edu.iua.model;

import java.io.Serializable;


public class ProveedorDTO  implements Serializable{

	private String nombre;
	
	

	public ProveedorDTO(String nombre) {
	
		this.nombre = "proveedor_"+nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
