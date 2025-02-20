package Finanzas05.Finanzas.factura.interfaces.rest;

import Finanzas05.Finanzas.factura.application.internal.commandServices.FacturaCommandService;
import Finanzas05.Finanzas.factura.application.internal.queryServices.FacturaQueryService;
import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import Finanzas05.Finanzas.factura.domain.model.queries.GetAllFacturasQuery;
import Finanzas05.Finanzas.factura.interfaces.rest.resources.CreateFacturaResource;
import Finanzas05.Finanzas.factura.interfaces.rest.resources.FacturaResource;
import Finanzas05.Finanzas.factura.interfaces.rest.transformers.CreateFacturaCommandFromResourceAssembler;
import Finanzas05.Finanzas.factura.interfaces.rest.transformers.FacturaResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/factura")
public class FacturaController {

    private final FacturaQueryService facturaQueryService;
    private final FacturaCommandService facturaCommandService;

    public FacturaController(FacturaQueryService facturaQueryService, FacturaCommandService facturaCommandService) {
        this.facturaQueryService = facturaQueryService;
        this.facturaCommandService = facturaCommandService;
    }

    @GetMapping
    public ResponseEntity<List<FacturaResource>> getAllFactura(){
        var getAllFacturaQuery = new GetAllFacturasQuery();
        var factura = facturaQueryService.handle(getAllFacturaQuery);
        var facturaResources= factura.stream().map(FacturaResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(facturaResources);
    }

    @PostMapping
    public ResponseEntity<Factura> createFactura(@RequestBody CreateFacturaResource createFacturaResource){
        var createFacturaCommand = CreateFacturaCommandFromResourceAssembler.toCommandFromResource(createFacturaResource);
        var factura = facturaCommandService.handle(createFacturaCommand);
        return factura.map(u->new ResponseEntity<>(u, HttpStatus.CREATED)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
