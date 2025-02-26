package Finanzas05.Finanzas.factura.domain.services;

import Finanzas05.Finanzas.cartera.domain.model.commands.DeleteCarteraCommand;
import Finanzas05.Finanzas.factura.domain.model.commands.CreateFacturaCommand;
import Finanzas05.Finanzas.factura.domain.model.commands.DeleteFacturaCommand;
import Finanzas05.Finanzas.factura.domain.model.entities.Factura;

import java.util.Optional;

public interface IFacturaCommandService {
    Optional<Factura> handle(CreateFacturaCommand command);
    void handle(DeleteFacturaCommand command);
}
