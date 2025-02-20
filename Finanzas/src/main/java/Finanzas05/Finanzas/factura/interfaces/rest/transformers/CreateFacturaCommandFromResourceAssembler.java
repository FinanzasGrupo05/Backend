package Finanzas05.Finanzas.factura.interfaces.rest.transformers;

import Finanzas05.Finanzas.factura.domain.model.commands.CreateFacturaCommand;
import Finanzas05.Finanzas.factura.interfaces.rest.resources.CreateFacturaResource;

public class CreateFacturaCommandFromResourceAssembler {
    public static CreateFacturaCommand toCommandFromResource(CreateFacturaResource resource){
        return new CreateFacturaCommand(resource.facturaName(), resource.clienteName(), resource.monto(), resource.emision(),resource.vencimiento());
    }
}
