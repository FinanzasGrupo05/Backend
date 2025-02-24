package Finanzas05.Finanzas.cartera.interfaces.rest.transformers;

import Finanzas05.Finanzas.cartera.domain.model.entities.Cartera;
import Finanzas05.Finanzas.cartera.domain.model.valueobject.Capitalizacion;
import Finanzas05.Finanzas.cartera.domain.model.valueobject.TipoTasa;
import Finanzas05.Finanzas.cartera.interfaces.rest.resources.CalculosResource;
import Finanzas05.Finanzas.factura.domain.model.entities.Factura;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class CalculoResourceFromEntityAssembler {
    public static List<CalculosResource> toResourceFromEntity(Cartera cartera) {
        return cartera.getFacturas().stream().map(factura -> {
            double tasa = cartera.getTasaDescuento();
            TipoTasa tipoTasa = cartera.getTipoTasa();
            Capitalizacion capitalizacion = cartera.getCapitalizacion();
            LocalDate fechaVencimiento = factura.getVencimiento();
            LocalDate fechaDescuento = cartera.getFechaDescuento();
            double gastosIniciales = cartera.getGastosInicio();
            double gastosFinales = cartera.getGastosFinal();
            double valorNominal = factura.getMonto();

            long diasPeriodo = ChronoUnit.DAYS.between(fechaDescuento, fechaVencimiento);
            double capitalizacionDias = capitalizacion.getDias();

            double tasaEfectiva = (tipoTasa == TipoTasa.Nominal)
                    ? Math.pow(1 + (tasa / (360.0 / capitalizacionDias)), 1) - 1
                    : tasa;

            double tasaPeriodo = Math.pow(1 + tasaEfectiva, (diasPeriodo / capitalizacionDias)) - 1;
            double tasaDescuento = tasaPeriodo / (1 + tasaPeriodo);
            double descuento = valorNominal * tasaDescuento;
            double valorNeto = valorNominal * (1 - tasaDescuento);
            double valorRecibido = valorNeto - gastosIniciales;
            double valorEntregado = valorNominal + gastosFinales;
            double tcea = Math.pow(valorEntregado / valorRecibido, 360.0 / diasPeriodo) - 1;

            return new CalculosResource(
                    factura.getFacturaName(),
                    factura.getClienteName(),
                    factura.getMonto(),
                    factura.getEmision(),
                    factura.getVencimiento(),
                    descuento,
                    cartera.getEstado(),
                    tcea
            );
        }).toList();
    }
}
