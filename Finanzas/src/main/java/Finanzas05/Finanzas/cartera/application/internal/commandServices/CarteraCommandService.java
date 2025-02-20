package Finanzas05.Finanzas.cartera.application.internal.commandServices;

import Finanzas05.Finanzas.cartera.domain.model.commands.CreateCarteraCommand;
import Finanzas05.Finanzas.cartera.domain.model.entities.Cartera;
import Finanzas05.Finanzas.cartera.domain.services.ICarteraCommandService;
import Finanzas05.Finanzas.cartera.infrastructure.repositories.jpa.ICarteraRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarteraCommandService implements ICarteraCommandService {

    private final ICarteraRepository facturaRepository;

    public CarteraCommandService(ICarteraRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public Optional<Cartera> handle(CreateCarteraCommand command) {

        Cartera nuevaCartera = new Cartera(command);
        try {
            Cartera carteraGuardada = facturaRepository.save(nuevaCartera);
            return Optional.of(carteraGuardada);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
}
