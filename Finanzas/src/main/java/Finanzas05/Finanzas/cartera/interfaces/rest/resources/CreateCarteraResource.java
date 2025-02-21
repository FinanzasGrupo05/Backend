package Finanzas05.Finanzas.cartera.interfaces.rest.resources;

import Finanzas05.Finanzas.cartera.domain.model.valueobject.Capitalizacion;
import Finanzas05.Finanzas.cartera.domain.model.valueobject.TipoTasa;

import java.time.LocalDate;
import java.util.List;

public record CreateCarteraResource(String nombreCartera,
                                    LocalDate fechaDescuento,
                                    Float tasaDescuento,
                                    TipoTasa tipoTasa,
                                    Capitalizacion capitalizacion,
                                    Double gastosInicio,
                                    Double gastosFinal,
                                    List<Long> facturasIds) {
}
