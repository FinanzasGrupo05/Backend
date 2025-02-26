package Finanzas05.Finanzas.factura.infrastructure.repositories.jpa;

import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFacturaRepository extends JpaRepository<Factura,Long> {
    List<Factura> findByCarteraId(Long carteraId);
    List<Factura> findByCarteraIsNull();
}
