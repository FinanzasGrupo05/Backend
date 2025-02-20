package Finanzas05.Finanzas.factura.domain.services;

import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import Finanzas05.Finanzas.factura.domain.model.queries.GetAllFacturasQuery;

import java.util.List;

public interface IFacturaQueryService {
    List<Factura> handle(GetAllFacturasQuery query);
}
