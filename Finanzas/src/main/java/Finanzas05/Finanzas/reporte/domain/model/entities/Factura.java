package Finanzas05.Finanzas.reporte.domain.model.entities;

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

    private String tipoMoneda;
    private Double monto;
    private Date fechaDescuento;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private Float tasaDescuento;
    private String tipoTasa;
    private String tipoCapital;

    public Factura(Long id, String tipoMoneda, Double monto, Date fechaDescuento, Date fechaEmision, Date fechaVencimiento, Float tasaDescuento, String tipoTasa, String tipoCapital){
        this.id= id;
        this.tipoMoneda= tipoMoneda;
        this.monto= monto;
        this.fechaDescuento= fechaDescuento;
        this.fechaEmision= fechaEmision;
        this.fechaVencimiento= fechaVencimiento;
        this.tasaDescuento= tasaDescuento;
        this.tipoTasa= tipoTasa;
        this.tipoCapital= tipoCapital;
    }

}
