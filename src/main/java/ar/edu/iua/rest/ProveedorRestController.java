package ar.edu.iua.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.iua.business.IProveedorBusiness;
import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Proveedor;
import ar.edu.iua.model.ProveedorDTO;

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

	@GetMapping(value = "/precio")
		    public ResponseEntity<List<Proveedor>> findByPrecioMayor(@RequestParam("precioBase") double precioBase) {
		        try {
		            return new ResponseEntity<List<Proveedor>>(proveedorBusiness.findByPrecioMayor(precioBase), HttpStatus.OK);
		        } catch (BusinessException e) {
		            return new ResponseEntity<List<Proveedor>>(HttpStatus.INTERNAL_SERVER_ERROR);
		        } catch (NotFoundException e) {
		            return new ResponseEntity<List<Proveedor>>(HttpStatus.NOT_FOUND);
		            }
	}
	
	@GetMapping(value = "/nombreProveedor")
    public ResponseEntity<List<ProveedorDTO>> listProveedores() {
        try {
            return new ResponseEntity<List<ProveedorDTO>>(proveedorBusiness.findAllProveedores(), HttpStatus.OK);
        } catch (BusinessException e) {
            return new ResponseEntity<List<ProveedorDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
        } 
}
}
