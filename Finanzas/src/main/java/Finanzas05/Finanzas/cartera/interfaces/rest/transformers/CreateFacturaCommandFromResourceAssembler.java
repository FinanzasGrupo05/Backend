package Finanzas05.Finanzas.cartera.interfaces.rest.transformers;

import Finanzas05.Finanzas.cartera.domain.model.commands.CreateCarteraCommand;
import Finanzas05.Finanzas.cartera.interfaces.rest.resources.CreateFacturaResource;

public class CreateFacturaCommandFromResourceAssembler {

    public static CreateCarteraCommand toCommandFromResource(CreateFacturaResource resource){
        return new CreateCarteraCommand(resource.monto(),
                resource.fechaEmision(),
                resource.fechaVencimiento(),
                resource.tasaDescuento(),
                resource.tipoTasa(),
                resource.capitalizacion(),
                resource.gastosInicio(),
                resource.gastosFinal());
    }
}
