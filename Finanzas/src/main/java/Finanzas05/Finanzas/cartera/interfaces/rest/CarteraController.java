package Finanzas05.Finanzas.cartera.interfaces.rest;

import Finanzas05.Finanzas.cartera.application.internal.commandServices.CarteraCommandService;
import Finanzas05.Finanzas.cartera.application.internal.queryServices.CarteraQueryService;
import Finanzas05.Finanzas.cartera.domain.model.entities.Cartera;
import Finanzas05.Finanzas.cartera.domain.model.queries.GetAllCarteraQuery;
import Finanzas05.Finanzas.cartera.interfaces.rest.resources.CreateFacturaResource;
import Finanzas05.Finanzas.cartera.interfaces.rest.transformers.CreateFacturaCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/cartera")
public class CarteraController {

    private final CarteraCommandService carteraCommandService;
    private final CarteraQueryService carteraQueryService;

    public CarteraController(CarteraCommandService carteraCommandService, CarteraQueryService carteraQueryService) {
        this.carteraCommandService = carteraCommandService;
        this.carteraQueryService = carteraQueryService;
    }

    @GetMapping
    public ResponseEntity<List<Cartera>> getAllFacturas(){
        var getAllFacturaQuery = new GetAllCarteraQuery();
        var facturaList = carteraQueryService.handle(getAllFacturaQuery);
        return new ResponseEntity<>(facturaList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cartera> createFactura(@RequestBody CreateFacturaResource createFacturaResource) {
        var createFacturaCommand = CreateFacturaCommandFromResourceAssembler.toCommandFromResource(createFacturaResource);

        var factura = carteraCommandService.handle(createFacturaCommand);

        return factura.map(r -> new ResponseEntity<>(r, HttpStatus.CREATED)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
