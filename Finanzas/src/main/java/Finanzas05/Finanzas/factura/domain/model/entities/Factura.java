package Finanzas05.Finanzas.factura.domain.model.entities;

import Finanzas05.Finanzas.factura.domain.model.valueobject.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Fuera
    private String tipoMoneda;
    private Date fechaDescuento;
    private Status estado;

    //Datos para crear una nueva factura
    private Double monto;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private Float tasaDescuento;
    private String tipoTasa;
    private String tipoCapital;
    private Double gastosInicio;
    private Double gastosFinal;

    public Factura(Long id, String tipoMoneda, Date fechaDescuento, Double monto, Date fechaEmision, Date fechaVencimiento, Float tasaDescuento, String tipoTasa, String tipoCapital){
        this.id= id;
        this.tipoMoneda= tipoMoneda;
        this.fechaDescuento= fechaDescuento;
        this.estado = Status.Pendiente;

        this.monto= monto;
        this.fechaEmision= fechaEmision;
        this.fechaVencimiento= fechaVencimiento;
        this.tasaDescuento= tasaDescuento;
        this.tipoTasa= tipoTasa;
        this.tipoCapital= tipoCapital;
    }

}
