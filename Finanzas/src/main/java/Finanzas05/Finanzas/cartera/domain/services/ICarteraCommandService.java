package Finanzas05.Finanzas.cartera.domain.services;

import Finanzas05.Finanzas.cartera.domain.model.commands.CreateCarteraCommand;
import Finanzas05.Finanzas.cartera.domain.model.commands.DeleteCarteraCommand;
import Finanzas05.Finanzas.cartera.domain.model.entities.Cartera;

import java.util.Optional;

public interface ICarteraCommandService {
    Optional<Cartera> handle(CreateCarteraCommand command);
    void handle(DeleteCarteraCommand command);
}
