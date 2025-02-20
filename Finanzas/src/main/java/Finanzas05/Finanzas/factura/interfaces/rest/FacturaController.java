package Finanzas05.Finanzas.factura.interfaces.rest;

import Finanzas05.Finanzas.factura.application.internal.commandServices.FacturaCommandService;
import Finanzas05.Finanzas.factura.application.internal.queryServices.FacturaQueryService;
import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import Finanzas05.Finanzas.factura.domain.model.queries.GetAllFacturaQuery;
import Finanzas05.Finanzas.factura.interfaces.rest.resources.CreateFacturaResource;
import Finanzas05.Finanzas.factura.interfaces.rest.transformers.CreateFacturaCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/facturas")
public class FacturaController {

    private final FacturaCommandService facturaCommandService;
    private final FacturaQueryService facturaQueryService;

    public FacturaController(FacturaCommandService facturaCommandService, FacturaQueryService facturaQueryService) {
        this.facturaCommandService = facturaCommandService;
        this.facturaQueryService = facturaQueryService;
    }

    @GetMapping
    public ResponseEntity<List<Factura>> getAllFacturas(){
        var getAllFacturaQuery = new GetAllFacturaQuery();
        var facturaList = facturaQueryService.handle(getAllFacturaQuery);
        return new ResponseEntity<>(facturaList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Factura> createFactura(@RequestBody CreateFacturaResource createFacturaResource) {
        var createFacturaCommand = CreateFacturaCommandFromResourceAssembler.toCommandFromResource(createFacturaResource);

        var factura = facturaCommandService.handle(createFacturaCommand);

        return factura.map(r -> new ResponseEntity<>(r, HttpStatus.CREATED)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
