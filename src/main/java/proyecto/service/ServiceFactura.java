package proyecto.service;

import java.util.List;

import proyecto.model.factura;



public interface ServiceFactura {
	factura saveFactura(factura factura);
	List<factura> getAllFactura();
	factura getFacturaById(long id);
	factura updateFactura(factura factura, long id);
	void deleteFactura(long id);
}
