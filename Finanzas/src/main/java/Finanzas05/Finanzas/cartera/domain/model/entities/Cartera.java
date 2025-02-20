package Finanzas05.Finanzas.cartera.domain.model.entities;

import Finanzas05.Finanzas.cartera.domain.model.commands.CreateCarteraCommand;
import Finanzas05.Finanzas.cartera.domain.model.valueobject.Capitalizacion;
import Finanzas05.Finanzas.cartera.domain.model.valueobject.Status;
import Finanzas05.Finanzas.cartera.domain.model.valueobject.TipoMoneda;
import Finanzas05.Finanzas.cartera.domain.model.valueobject.TipoTasa;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Cartera")
public class Cartera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Fuera
    private TipoMoneda tipoMoneda;
    private Date fechaDescuento;
    private Status estado;

    //Datos para crear una nueva factura
    private Double monto;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private Float tasaDescuento;
    private TipoTasa tipoTasa;
    private Capitalizacion capitalizacion;
    private Double gastosInicio;
    private Double gastosFinal;

    public Cartera(){}

    public Cartera(Long id, Date fechaDescuento, Double monto, Date fechaEmision, Date fechaVencimiento, Float tasaDescuento, TipoTasa tipoTasa){
        this.id= id;
        this.tipoMoneda= TipoMoneda.Soles;
        this.fechaDescuento= fechaDescuento;
        this.estado = Status.Pendiente;

        this.monto= monto;
        this.fechaEmision= fechaEmision;
        this.fechaVencimiento= fechaVencimiento;
        this.tasaDescuento= tasaDescuento;
        this.tipoTasa= TipoTasa.Nominal;
        this.capitalizacion= Capitalizacion.Anual;
    }

    public Cartera(CreateCarteraCommand command){
        this.monto = command.monto();
        this.fechaEmision = command.fechaEmision();
        this.fechaVencimiento = command.fechaVencimiento();
        this.gastosInicio = command.gastosInicio();
        this.gastosFinal = command.gastosFinal();
        this.tasaDescuento = (float) CreateCarteraCommand.calcularTasaDescuento(
                command.tasaDescuento(),
                command.tipoTasa(),
                command.capitalizacion()
        );

        this.tipoTasa = command.tipoTasa();
        this.capitalizacion = command.capitalizacion();
    }

}
