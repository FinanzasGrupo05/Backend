package Finanzas05.Finanzas.factura.domain.services;

import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import Finanzas05.Finanzas.factura.domain.model.queries.GetAllFacturaQuery;

import java.util.List;

public interface IFacturaQueryService {

    List<Factura> handle(GetAllFacturaQuery query);
}
