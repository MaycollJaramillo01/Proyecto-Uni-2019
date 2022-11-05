package proyecto.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import proyecto.exception.ResourceNotFoundException;
import proyecto.model.factura;
import proyecto.repository.FacturaRepository;
import proyecto.service.ServiceFactura;

@Service
public class FacturaServiceImpl implements ServiceFactura {

	private FacturaRepository facturaRepository;

	public FacturaServiceImpl(FacturaRepository facturaRepository) {
		super();
		this.facturaRepository = facturaRepository;
	}

	@Override
	public factura saveFactura(factura factura) {
		return facturaRepository.save(factura);
	}

	@Override
	public List<factura> getAllFactura() {
		return facturaRepository.findAll();
	}

	@Override
	public factura getFacturaById(long id) {
		return facturaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("factura", "ID_FACTURA", id));
	}

	@Override
	public factura updateFactura(factura fac, long id) {
		factura existFactura = facturaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("factura", "ID_FACTURA", id));

		existFactura.setFECHA(fac.getFECHA());
		existFactura.setCLIENTE(fac.getCLIENTE());
		existFactura.setTOTAL(fac.getTOTAL());

		facturaRepository.save(existFactura);

		return existFactura;
	}

	@Override
	public void deleteFactura(long id) {

		facturaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("factura", "ID_FACTURA", id));
		facturaRepository.deleteById(id);

	}

}
