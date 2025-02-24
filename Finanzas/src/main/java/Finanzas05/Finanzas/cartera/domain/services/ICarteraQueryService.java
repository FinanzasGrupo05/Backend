package Finanzas05.Finanzas.cartera.domain.services;

import Finanzas05.Finanzas.cartera.domain.model.entities.Cartera;
import Finanzas05.Finanzas.cartera.domain.model.queries.GetAllCarteraQuery;
import Finanzas05.Finanzas.cartera.domain.model.queries.GetResultsQuery;
import Finanzas05.Finanzas.cartera.interfaces.rest.resources.CalculosResource;
import Finanzas05.Finanzas.factura.domain.model.entities.Factura;

import java.util.List;
import java.util.Optional;

public interface ICarteraQueryService {
    List<Cartera> handle(GetAllCarteraQuery query);
}
