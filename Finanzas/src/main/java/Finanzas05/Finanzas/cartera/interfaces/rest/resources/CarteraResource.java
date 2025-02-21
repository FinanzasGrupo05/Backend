package Finanzas05.Finanzas.cartera.interfaces.rest.resources;

import Finanzas05.Finanzas.cartera.domain.model.valueobject.Capitalizacion;
import Finanzas05.Finanzas.cartera.domain.model.valueobject.TipoTasa;
import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import Finanzas05.Finanzas.factura.interfaces.rest.resources.FacturaResource;

import java.time.LocalDate;
import java.util.List;

public record CarteraResource(
        Long id,
        String nombreCartera,
        LocalDate fechaDescuento,
        Float tasaDescuento,
        TipoTasa tipoTasa,
        Capitalizacion capitalizacion,
        Double gastosInicio,
        Double gastosFinal,
        List<FacturaResource> facturasIds
) {
}
