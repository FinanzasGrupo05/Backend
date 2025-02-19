package Finanzas05.Finanzas.factura.application.internal.queryServices;

import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import Finanzas05.Finanzas.factura.domain.services.IFacturaQueryService;
import Finanzas05.Finanzas.factura.infrastructure.repositories.jpa.IFacturaRepository;
import Finanzas05.Finanzas.user.domain.model.queries.GetAllUsersQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaQueryService implements IFacturaQueryService {

    private final IFacturaRepository facturaRepository;

    public FacturaQueryService(IFacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public List<Factura> handle(GetAllUsersQuery query) {
        return facturaRepository.findAll();
    }
}
