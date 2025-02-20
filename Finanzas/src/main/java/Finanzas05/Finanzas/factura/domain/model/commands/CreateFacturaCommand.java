package Finanzas05.Finanzas.factura.domain.model.commands;

import java.time.LocalDate;
import java.util.Date;

public record CreateFacturaCommand(String facturaName, String clienteName, Double monto, LocalDate emision, LocalDate vencimiento) {
}
