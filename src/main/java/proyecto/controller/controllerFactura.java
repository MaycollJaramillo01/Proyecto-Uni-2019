package proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.model.factura;
import proyecto.service.ServiceFactura;

@RestController
@RequestMapping("/api/facturas")

public class controllerFactura {
	
	@Autowired
	private ServiceFactura facturaService;
	
	
	public controllerFactura(ServiceFactura facturaService) {
		super();
		this.facturaService = facturaService;
	}

	@PostMapping
	public ResponseEntity<factura> saveFactura(@RequestBody factura factura) {
		return new ResponseEntity<factura>(facturaService.saveFactura(factura), HttpStatus.CREATED);
	}

	@GetMapping
	public List<factura> getAllFactura() {
		return facturaService.getAllFactura();
	}

	// http://localhost:8080/api/facturas/id
	@GetMapping("{id}")
	public ResponseEntity<factura> getFacturaById(@PathVariable("id") long facturaId) {
		return new ResponseEntity<factura>(facturaService.getFacturaById(facturaId), HttpStatus.CREATED);
	}

	// http://localhost:8080/api/facturas/id
	@PutMapping("{id}")
	public ResponseEntity<factura> updateFactura(@PathVariable("id") long id, @RequestBody factura fac) {
		return new ResponseEntity<factura>(facturaService.updateFactura(fac, id), HttpStatus.OK);
	}

	// http://localhost:8080/api/facturas/id
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		facturaService.deleteFactura(id);
		return new ResponseEntity<String>("La factura fue eliminada correctamente.", HttpStatus.OK);
	}

}
