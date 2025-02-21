package Finanzas05.Finanzas.cartera.application.internal.queryServices;

import Finanzas05.Finanzas.cartera.domain.model.entities.Cartera;
import Finanzas05.Finanzas.cartera.domain.model.queries.GetAllCarteraQuery;
import Finanzas05.Finanzas.cartera.domain.services.ICarteraQueryService;
import Finanzas05.Finanzas.cartera.infrastructure.repositories.jpa.ICarteraRepository;
import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteraQueryService implements ICarteraQueryService {
    private final ICarteraRepository carteraRepository;

    public CarteraQueryService(ICarteraRepository carteraRepository) {
        this.carteraRepository = carteraRepository;
    }

    @Override
    public List<Cartera> handle(GetAllCarteraQuery query) {
        return carteraRepository.findAll();
    }
}
