package Finanzas05.Finanzas.cartera.interfaces.rest.transformers;

import Finanzas05.Finanzas.cartera.domain.model.commands.CreateCarteraCommand;
import Finanzas05.Finanzas.cartera.interfaces.rest.resources.CreateCarteraResource;

public class CreateCarteraCommandFromResourceAssembler {
    public static CreateCarteraCommand toCommandFromResource(CreateCarteraResource resource){
        return new CreateCarteraCommand(resource.nombreCartera(), resource.fechaDescuento(), resource.tasaDescuento(), resource.tipoTasa(),resource.capitalizacion(), resource.gastosInicio(), resource.gastosFinal(), resource.facturasIds());
    }
}
