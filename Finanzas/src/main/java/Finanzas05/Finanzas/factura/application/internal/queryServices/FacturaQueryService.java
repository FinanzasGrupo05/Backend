package Finanzas05.Finanzas.factura.application.internal.queryServices;

import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import Finanzas05.Finanzas.factura.domain.model.queries.GetAllFacturasQuery;
import Finanzas05.Finanzas.factura.domain.model.queries.GetFacturasByIdQuery;
import Finanzas05.Finanzas.factura.domain.services.IFacturaQueryService;
import Finanzas05.Finanzas.factura.infrastructure.repositories.jpa.IFacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaQueryService implements IFacturaQueryService {

    private final IFacturaRepository facturaRepository;

    public FacturaQueryService(IFacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public List<Factura> handle(GetAllFacturasQuery query) {
        return facturaRepository.findByCarteraIsNull();
    }

    @Override
    public Optional<Factura> handle(GetFacturasByIdQuery query) {
        return facturaRepository.findById(query.facturaid());
    }
}
