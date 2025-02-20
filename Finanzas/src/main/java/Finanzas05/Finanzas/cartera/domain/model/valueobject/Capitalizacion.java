package Finanzas05.Finanzas.cartera.domain.model.valueobject;

public enum Capitalizacion {

    Quincenal(15),
    Mensual(12),
    Bimestral(6),
    Trimestral(4),
    Cuatrimestral(3),
    Semestral(2),
    Anual(360);
    private final int periodosPorAnio;

    Capitalizacion(int periodosPorAnio) {
        this.periodosPorAnio = periodosPorAnio;
    }

    public int getPeriodosPorAnio() {
        return periodosPorAnio;
    }
}
