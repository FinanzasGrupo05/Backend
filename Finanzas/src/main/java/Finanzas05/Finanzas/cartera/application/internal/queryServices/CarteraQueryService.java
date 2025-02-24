package Finanzas05.Finanzas.cartera.application.internal.queryServices;

import Finanzas05.Finanzas.cartera.domain.model.entities.Cartera;
import Finanzas05.Finanzas.cartera.domain.model.queries.GetAllCarteraQuery;
import Finanzas05.Finanzas.cartera.domain.model.queries.GetResultsQuery;
import Finanzas05.Finanzas.cartera.domain.services.ICarteraQueryService;
import Finanzas05.Finanzas.cartera.infrastructure.repositories.jpa.ICarteraRepository;
import Finanzas05.Finanzas.cartera.interfaces.rest.resources.CalculosResource;
import Finanzas05.Finanzas.cartera.interfaces.rest.transformers.CalculoResourceFromEntityAssembler;
import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import Finanzas05.Finanzas.factura.infrastructure.repositories.jpa.IFacturaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    public List<CalculosResource> getResultados(Long carteraId) {
        Cartera cartera = carteraRepository.findById(carteraId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartera no encontrada"));

        return CalculoResourceFromEntityAssembler.toResourceFromEntity(cartera);
    }


//    private double calcularInteresDescontado(Factura factura) {
//        long diasPeriodo = ChronoUnit.DAYS.between(factura.getEmision(), factura.getVencimiento());
//        double tasaPeriodo = Math.pow(1 + 0.12, (diasPeriodo / 30.0)) - 1;
//        double tasaDescuento = tasaPeriodo / (1 + tasaPeriodo);
//        return factura.getMonto() * tasaDescuento;
//    }
//
//    private double calcularTCEA(Factura factura, double interesDescontado) {
//        long diasPeriodo = ChronoUnit.DAYS.between(factura.getEmision(), factura.getVencimiento());
//        double valorNeto = factura.getMonto() - interesDescontado;
//        double valorEntregado = factura.getMonto();
//        return Math.pow(valorEntregado / valorNeto, 360.0 / diasPeriodo) - 1;
//    }
//    @Override
//    public List<GetResultsQuery> handle(GetResultsQuery query, Long carteraId) {
//        return carteraRepository.findById(carteraId)
//                .map(cartera -> {
//                    List<Factura> facturas = facturaRepository.findByCarteraId(carteraId);
//                    return facturas.stream().map(factura -> {
//                        double interesDescontado = calcularInteresDescontado(factura);
//                        double tcea = calcularTCEA(factura, interesDescontado);
//
//                        return new GetResultsQuery(
//                                factura.getFacturaName(),
//                                factura.getClienteName(),
//                                factura.getMonto(),
//                                factura.getEmision(),
//                                factura.getVencimiento(),
//                                interesDescontado,
//                                "Descontada",
//                                tcea
//                        );
//                    }).toList();
//                }).orElse(Collections.emptyList());
//    }
}
