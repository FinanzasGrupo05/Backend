package Finanzas05.Finanzas.cartera.interfaces.rest.transformers;

import Finanzas05.Finanzas.cartera.domain.model.entities.Cartera;
import Finanzas05.Finanzas.cartera.interfaces.rest.resources.CarteraResource;
import Finanzas05.Finanzas.factura.interfaces.rest.resources.FacturaResource;

import java.util.List;
import java.util.stream.Collectors;

public class CarteraResourceFromEntityAssembler {
    public static CarteraResource toResourceFromEntity(Cartera entity){
        List<FacturaResource> facturaResources = entity.getFacturas().stream()
                .map(factura -> new FacturaResource(factura.getId(), factura.getFacturaName(), factura.getClienteName(), factura.getMonto(),factura.getEmision(),factura.getVencimiento()))
                .collect(Collectors.toList());
        return new CarteraResource(entity.getId(), entity.getNombreCartera(),entity.getFechaDescuento(),entity.getTasaDescuento(),entity.getTipoTasa(),entity.getCapitalizacion(), entity.getGastosInicio(), entity.getGastosFinal(), facturaResources);
    }
}
