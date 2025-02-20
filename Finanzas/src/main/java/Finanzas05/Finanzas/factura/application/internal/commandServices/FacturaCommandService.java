package Finanzas05.Finanzas.factura.application.internal.commandServices;

import Finanzas05.Finanzas.factura.domain.model.commands.CreateFacturaCommand;
import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import Finanzas05.Finanzas.factura.domain.services.IFacturaCommandService;
import Finanzas05.Finanzas.factura.infrastructure.repositories.jpa.IFacturaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class FacturaCommandService implements IFacturaCommandService {

    private final IFacturaRepository facturaRepository;

    public FacturaCommandService(IFacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public Optional<Factura> handle(CreateFacturaCommand command) {

        double tasaDescuentoCalculada = CreateFacturaCommand.calcularTasaDescuento(
                command.tasaDescuento(),
                command.tipoTasa(),
                command.capitalizacion()
        );

        Factura nuevaFactura = new Factura(
                null,
                new Date(),
                command.monto(),
                command.fechaEmision(),
                command.fechaVencimiento(),
                (float) tasaDescuentoCalculada,
                command.tipoTasa()
        );

        Factura facturaGuardada = facturaRepository.save(nuevaFactura);

        return Optional.of(facturaGuardada);
    }
}
