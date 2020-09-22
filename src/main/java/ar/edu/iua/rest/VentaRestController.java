package ar.edu.iua.rest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import ar.edu.iua.business.IVentaBusiness;
import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Venta;

@RestController
@RequestMapping(value = Constantes.URL_VENTAS)

public class VentaRestController {
	
	@Autowired
	private IVentaBusiness ventaBusiness;
	
	    // curl "http://localhost:8080/api/v1/venta/2020-09-16" -v
		@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Venta>>list(
				@RequestParam(name = "total", required = false, defaultValue = "0") double total) {

			try {
				if(total == 0)
				{
					return new ResponseEntity<List<Venta>>(ventaBusiness.list(), HttpStatus.OK);
				}
				else
				{
					return new ResponseEntity<List<Venta>>(ventaBusiness.findByTotal(total), HttpStatus.OK);
				}
							
			} catch (BusinessException e) {
				return new ResponseEntity<List<Venta>>(HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (NotFoundException e) {
				return new ResponseEntity<List<Venta>>(HttpStatus.NOT_FOUND);
			}
		}

	
}
