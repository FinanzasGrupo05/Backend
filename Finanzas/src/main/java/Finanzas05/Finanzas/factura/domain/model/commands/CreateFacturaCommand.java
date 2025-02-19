package Finanzas05.Finanzas.factura.domain.model.commands;

import java.util.Date;

public record CreateFacturaCommand(Double monto, Date fechaEmision, Date fechaVencimiento, Float tasaDescuento, String tipoTasa, String tipoCapital, Double gastosInicio, Double gastosFinal) {
}
