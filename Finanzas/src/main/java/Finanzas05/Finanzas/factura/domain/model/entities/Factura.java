package Finanzas05.Finanzas.factura.domain.model.entities;

import Finanzas05.Finanzas.cartera.domain.model.entities.Cartera;
import Finanzas05.Finanzas.factura.domain.model.commands.CreateFacturaCommand;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Factura")
@Setter
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String facturaName;
    private String clienteName;
    private Double monto;
    private LocalDate emision;
    private LocalDate vencimiento;

    @ManyToOne
    @JoinColumn(name = "cartera_id")
    private Cartera cartera;

    public Factura(){}

    public Factura(Long id, String facturaName, String clienteName, Double monto, LocalDate emision, LocalDate vencimiento, Cartera cartera) {
        this.id = id;
        this.facturaName = facturaName;
        this.clienteName = clienteName;
        this.monto = monto;
        this.emision = emision;
        this.vencimiento = vencimiento;
        this.cartera = cartera;
    }

    public Factura(CreateFacturaCommand command){
        this.facturaName = command.facturaName();
        this.clienteName = command.clienteName();
        this.monto = command.monto();
        this.emision = command.emision();
        this.vencimiento = command.vencimiento();
    }

    public Long getId() {
        return id;
    }

    public String getFacturaName() {
        return facturaName;
    }

    public String getClienteName(){
        return clienteName;
    }

    public Double getMonto() {
        return monto;
    }

    public LocalDate getEmision() {
        return emision;
    }

    public LocalDate getVencimiento() {
        return vencimiento;
    }

    public void setCartera(Cartera cartera) {
        this.cartera = cartera;
    }


}
