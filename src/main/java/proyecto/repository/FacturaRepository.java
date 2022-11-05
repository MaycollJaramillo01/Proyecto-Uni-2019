package proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proyecto.model.factura;

public interface FacturaRepository extends JpaRepository<factura, Long> {

}
