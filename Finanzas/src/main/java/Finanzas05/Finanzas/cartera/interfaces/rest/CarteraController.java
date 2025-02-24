package Finanzas05.Finanzas.cartera.interfaces.rest;

import Finanzas05.Finanzas.cartera.application.internal.commandServices.CarteraCommandService;
import Finanzas05.Finanzas.cartera.application.internal.queryServices.CarteraQueryService;
import Finanzas05.Finanzas.cartera.domain.model.entities.Cartera;
import Finanzas05.Finanzas.cartera.domain.model.queries.GetAllCarteraQuery;
import Finanzas05.Finanzas.cartera.domain.model.queries.GetResultsQuery;
import Finanzas05.Finanzas.cartera.interfaces.rest.resources.CalculosResource;
import Finanzas05.Finanzas.cartera.interfaces.rest.resources.CarteraResource;
import Finanzas05.Finanzas.cartera.interfaces.rest.resources.CreateCarteraResource;
import Finanzas05.Finanzas.cartera.interfaces.rest.transformers.CarteraResourceFromEntityAssembler;
import Finanzas05.Finanzas.cartera.interfaces.rest.transformers.CreateCarteraCommandFromResourceAssembler;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cartera")
public class CarteraController {
    private final CarteraQueryService carteraQueryService;
    private final CarteraCommandService carteraCommandService;

    public CarteraController(CarteraQueryService carteraQueryService, CarteraCommandService carteraCommandService) {
        this.carteraQueryService = carteraQueryService;
        this.carteraCommandService = carteraCommandService;
    }

    @GetMapping
    public ResponseEntity<List<CarteraResource>> getAllCartera(){
        var getAllCarteraQuery = new GetAllCarteraQuery();
        var cartera = carteraQueryService.handle(getAllCarteraQuery);
        var carteraResources = cartera.stream().map(CarteraResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(carteraResources);
    }

    @GetMapping("/{carteraId}/resultados")
    public ResponseEntity<List<CalculosResource>> obtenerResultados(@PathVariable Long carteraId) {
        var resultados = carteraQueryService.getResultados(carteraId);
        return ResponseEntity.ok(resultados);
    }

    @PostMapping
    public ResponseEntity<Cartera> createCartera(@RequestBody CreateCarteraResource createCarteraResource){
        var createCarteraCommand = CreateCarteraCommandFromResourceAssembler.toCommandFromResource(createCarteraResource);
        var cartera = carteraCommandService.handle(createCarteraCommand);
        return cartera.map(u->new ResponseEntity<>(u, HttpStatus.CREATED)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
    @PostMapping("/id")
    public ResponseEntity<Cartera> addAnotherFactura(){
        return null;
    }

}
