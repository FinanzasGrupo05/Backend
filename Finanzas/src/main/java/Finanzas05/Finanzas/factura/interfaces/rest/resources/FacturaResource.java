package Finanzas05.Finanzas.factura.interfaces.rest.resources;

import java.time.LocalDate;
import java.util.Date;

public record FacturaResource(
        Long id,
        String facturaName,
        String clienteName,
        Double monto,
        LocalDate emision,
        LocalDate vencimiento
) {
}
