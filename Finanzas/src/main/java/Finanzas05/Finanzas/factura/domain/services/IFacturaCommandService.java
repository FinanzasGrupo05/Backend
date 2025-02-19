package Finanzas05.Finanzas.factura.domain.services;

import Finanzas05.Finanzas.factura.domain.model.commands.CreateFacturaCommand;
import Finanzas05.Finanzas.factura.domain.model.entities.Factura;

import java.util.Optional;

public interface IFacturaCommandService {
    Optional<Factura> handle(CreateFacturaCommand command);
}
