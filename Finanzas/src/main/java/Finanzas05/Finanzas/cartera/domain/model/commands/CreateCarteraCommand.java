package Finanzas05.Finanzas.cartera.domain.model.commands;

import Finanzas05.Finanzas.cartera.domain.model.valueobject.Capitalizacion;
import Finanzas05.Finanzas.cartera.domain.model.valueobject.TipoTasa;
import Finanzas05.Finanzas.factura.domain.model.entities.Factura;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public record CreateCarteraCommand(
        String nombreCartera,
        LocalDate fechaDescuento,
        Float tasaDescuento,
        TipoTasa tipoTasa,
        Capitalizacion capitalizacion,
        Double gastosInicio,
        Double gastosFinal,
        List<Long> facturasIds
) {

//    public static double calcularTasaDescuento(Float tasaDescuento, TipoTasa tipoTasa, Capitalizacion capitalizacion) {
//        double i = calcularTasaEfectiva(tasaDescuento, tipoTasa, capitalizacion);
//        return i / (1 + i);
//    }
//    private static double calcularTasaEfectiva(Float tasaDescuento, TipoTasa tipoTasa, Capitalizacion capitalizacion) {
//        if (tipoTasa == TipoTasa.Efectiva) {
//            return tasaDescuento / 100;
//        }
//        int n = capitalizacion.getPeriodosPorAnio();
//        return Math.pow(1 + (tasaDescuento / (100 * n)), n) - 1;
//    }


}
