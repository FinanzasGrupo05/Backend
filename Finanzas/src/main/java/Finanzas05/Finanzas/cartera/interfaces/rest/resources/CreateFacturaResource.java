package Finanzas05.Finanzas.cartera.interfaces.rest.resources;

import Finanzas05.Finanzas.cartera.domain.model.valueobject.Capitalizacion;
import Finanzas05.Finanzas.cartera.domain.model.valueobject.TipoTasa;

import java.util.Date;

public record CreateFacturaResource(
        Double monto,
        Date fechaEmision,
        Date fechaVencimiento,
        Float tasaDescuento,
        TipoTasa tipoTasa,
        Capitalizacion capitalizacion,
        Double gastosInicio,
        Double gastosFinal

) {}
