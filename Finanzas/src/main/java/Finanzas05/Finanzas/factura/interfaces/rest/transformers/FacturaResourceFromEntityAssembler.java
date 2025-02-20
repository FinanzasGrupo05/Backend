package Finanzas05.Finanzas.factura.interfaces.rest.transformers;

import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import Finanzas05.Finanzas.factura.interfaces.rest.resources.FacturaResource;

public class FacturaResourceFromEntityAssembler {
    public static FacturaResource toResourceFromEntity(Factura entity){
        return new FacturaResource(entity.getId(), entity.getFacturaName(),entity.getClienteName(), entity.getMonto(), entity.getEmision(),entity.getVencimiento());
    }
}
