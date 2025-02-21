package Finanzas05.Finanzas.cartera.domain.model.entities;

import Finanzas05.Finanzas.cartera.domain.model.commands.CreateCarteraCommand;
import Finanzas05.Finanzas.cartera.domain.model.valueobject.Capitalizacion;
import Finanzas05.Finanzas.cartera.domain.model.valueobject.Status;
import Finanzas05.Finanzas.cartera.domain.model.valueobject.TipoMoneda;
import Finanzas05.Finanzas.cartera.domain.model.valueobject.TipoTasa;
import Finanzas05.Finanzas.factura.domain.model.entities.Factura;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Setter
@Table(name = "Cartera")
public class Cartera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCartera;
    private LocalDate fechaDescuento;
    private Float tasaDescuento;
    @Enumerated(EnumType.STRING)
    private TipoTasa tipoTasa;
    @Enumerated(EnumType.STRING)
    private Capitalizacion capitalizacion;
    private Double gastosInicio;
    private Double gastosFinal;
    @Enumerated(EnumType.STRING)
    private Status estado;

    @OneToMany(mappedBy = "cartera", cascade = CascadeType.ALL)
    private List<Factura> facturas;

    public Cartera(){}

    public Long getId() {
        return id;
    }

    public String getNombreCartera() {
        return nombreCartera;
    }

    public LocalDate getFechaDescuento() {
        return fechaDescuento;
    }

    public Float getTasaDescuento() {
        return tasaDescuento;
    }

    public TipoTasa getTipoTasa() {
        return tipoTasa;
    }

    public Capitalizacion getCapitalizacion() {
        return capitalizacion;
    }

    public Double getGastosInicio() {
        return gastosInicio;
    }

    public Double getGastosFinal() {
        return gastosFinal;
    }

    public Status getEstado() {
        return estado;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setNombreCartera(String nombreCartera) {
        this.nombreCartera = nombreCartera;
    }

    public void setFechaDescuento(LocalDate fechaDescuento) {
        this.fechaDescuento = fechaDescuento;
    }

    public void setTasaDescuento(Float tasaDescuento) {
        this.tasaDescuento = tasaDescuento;
    }

    public void setTipoTasa(TipoTasa tipoTasa) {
        this.tipoTasa = tipoTasa;
    }

    public void setCapitalizacion(Capitalizacion capitalizacion) {
        this.capitalizacion = capitalizacion;
    }

    public void setGastosInicio(Double gastosInicio) {
        this.gastosInicio = gastosInicio;
    }

    public void setGastosFinal(Double gastosFinal) {
        this.gastosFinal = gastosFinal;
    }

    public void setEstado(Status estado) {
        this.estado = estado;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
}
