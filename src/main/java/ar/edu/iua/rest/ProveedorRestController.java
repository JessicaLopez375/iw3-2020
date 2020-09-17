package ar.edu.iua.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.iua.business.IProveedorBusiness;
import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Proveedor;


@RestController
@RequestMapping(value = Constantes.URL_PROVEEDORES)
public class ProveedorRestController {
	
	@Autowired
	private IProveedorBusiness proveedorBusiness;
	
	// curl "http://localhost:8080/api/v1/proveedores/1" -v
		@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Proveedor> find(@PathVariable("id") int id) {

			try {
				return new ResponseEntity<Proveedor>(proveedorBusiness.find(id), HttpStatus.OK);
			} catch (BusinessException e) {
				return new ResponseEntity<Proveedor>(HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (NotFoundException e) {
				return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
			}
		}

}
