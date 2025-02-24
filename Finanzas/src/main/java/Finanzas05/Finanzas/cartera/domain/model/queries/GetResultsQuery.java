package Finanzas05.Finanzas.cartera.domain.model.queries;

import java.time.LocalDate;

public record GetResultsQuery(
        String numeroFactura,
        String cliente,
        Double monto,
        LocalDate fechaEmision,
        LocalDate fechaVencimiento,
        Double interesDescontado,
        String estado,
        Double tcea
) {
}
