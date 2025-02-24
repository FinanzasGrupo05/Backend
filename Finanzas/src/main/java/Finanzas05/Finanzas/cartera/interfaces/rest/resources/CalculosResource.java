package Finanzas05.Finanzas.cartera.interfaces.rest.resources;

import Finanzas05.Finanzas.cartera.domain.model.valueobject.Status;

import java.time.LocalDate;

public record CalculosResource(
        String facturaName,
        String clienteName,
        Double monto,
        LocalDate fechaEmision,
        LocalDate fechaVencimiento,
        Double interesDescontado,
        Status estado,
        Double tcea
) {
}
