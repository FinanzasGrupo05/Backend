package Finanzas05.Finanzas.factura.infrastructure.repositories.jpa;

import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacturaRepository extends JpaRepository<Factura,Long> {
}
