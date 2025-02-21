package Finanzas05.Finanzas.factura.domain.services;

import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import Finanzas05.Finanzas.factura.domain.model.queries.GetAllFacturasQuery;
import Finanzas05.Finanzas.factura.domain.model.queries.GetFacturasByIdQuery;

import java.util.List;
import java.util.Optional;

public interface IFacturaQueryService {
    List<Factura> handle(GetAllFacturasQuery query);
    Optional<Factura> handle(GetFacturasByIdQuery query);
}
