package Finanzas05.Finanzas.cartera.application.internal.commandServices;

import Finanzas05.Finanzas.cartera.domain.model.commands.CreateCarteraCommand;
import Finanzas05.Finanzas.cartera.domain.model.entities.Cartera;
import Finanzas05.Finanzas.cartera.domain.services.ICarteraCommandService;
import Finanzas05.Finanzas.cartera.infrastructure.repositories.jpa.ICarteraRepository;
import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import Finanzas05.Finanzas.factura.infrastructure.repositories.jpa.IFacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarteraCommandService implements ICarteraCommandService {
    private final ICarteraRepository carteraRepository;
    private final IFacturaRepository facturaRepository;

    public CarteraCommandService(ICarteraRepository carteraRepository, IFacturaRepository facturaRepository) {
        this.carteraRepository = carteraRepository;
        this.facturaRepository = facturaRepository;
    }

    @Override
    public Optional<Cartera> handle(CreateCarteraCommand command) {
        Cartera cartera = new Cartera();
        cartera.setNombreCartera(command.nombreCartera());
        cartera.setFechaDescuento(command.fechaDescuento());
        cartera.setTasaDescuento(command.tasaDescuento());
        cartera.setTipoTasa(command.tipoTasa());
        cartera.setCapitalizacion(command.capitalizacion());
        cartera.setGastosInicio(command.gastosInicio());
        cartera.setGastosFinal(command.gastosFinal());

        if (command.facturasIds() != null && !command.facturasIds().isEmpty()) {
            List<Factura> facturas = facturaRepository.findAllById(command.facturasIds());
            for (Factura factura : facturas) {
                factura.setCartera(cartera);
            }
            cartera.setFacturas(facturas);
        }

        Cartera savedCartera = carteraRepository.save(cartera);
        return Optional.of(savedCartera);
    }
}
