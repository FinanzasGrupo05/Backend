package Finanzas05.Finanzas.cartera.domain.model.valueobject;

public enum Capitalizacion {

    Quincenal(1),
    Mensual(30),
    Bimestral(60),
    Trimestral(90),
    Cuatrimestral(40),
    Semestral(180),
    Anual(360);
    private final int dias;
    Capitalizacion(int dias) {
        this.dias = dias;
    }
    public int getDias() {
        return dias;
    }
}
