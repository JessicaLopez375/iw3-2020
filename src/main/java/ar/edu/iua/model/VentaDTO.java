package ar.edu.iua.model;

import java.io.Serializable;

public class VentaDTO implements Serializable {
	
	private double total;
	
	public VentaDTO(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	} 
	
	

}
