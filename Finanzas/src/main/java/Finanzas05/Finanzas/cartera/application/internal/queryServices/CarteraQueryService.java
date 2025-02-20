package Finanzas05.Finanzas.cartera.application.internal.queryServices;

import Finanzas05.Finanzas.cartera.domain.model.entities.Cartera;
import Finanzas05.Finanzas.cartera.domain.model.queries.GetAllCarteraQuery;
import Finanzas05.Finanzas.cartera.domain.services.ICarteraQueryService;
import Finanzas05.Finanzas.cartera.infrastructure.repositories.jpa.ICarteraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteraQueryService implements ICarteraQueryService {

    private final ICarteraRepository facturaRepository;

    public CarteraQueryService(ICarteraRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public List<Cartera> handle(GetAllCarteraQuery query) {
        return facturaRepository.findAll();
    }
}
