package Finanzas05.Finanzas.factura.application.internal.commandServices;

import Finanzas05.Finanzas.factura.domain.model.commands.CreateFacturaCommand;
import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import Finanzas05.Finanzas.factura.domain.services.IFacturaCommandService;
import Finanzas05.Finanzas.factura.infrastructure.repositories.jpa.IFacturaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacturaCommandService implements IFacturaCommandService {

    private final IFacturaRepository facturaRepository;

    public FacturaCommandService(IFacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public Optional<Factura> handle(CreateFacturaCommand command) {
        Factura factura = new Factura(command);
        try{
            var response = facturaRepository.save(factura);
            return Optional.of(response);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
}
