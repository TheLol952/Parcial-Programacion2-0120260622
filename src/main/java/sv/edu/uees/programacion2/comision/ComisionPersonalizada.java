package sv.edu.uees.programacion2.comision;

/**
 * Estrategia cuya tasa es 5 % mas un punto porcentual por cada letra del
 * primer nombre del empleado.
 */
public class ComisionPersonalizada implements EstrategiaComision {
    private static final int PORCENTAJE_BASE = 5;
    private final int cantidadLetras;

    public ComisionPersonalizada(String primerNombre) {
        if (primerNombre == null || primerNombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El primer nombre es obligatorio");
        }

        this.cantidadLetras = (int) primerNombre.trim()
                .codePoints()
                .filter(Character::isLetter)
                .count();
    }

    @Override
    public double calcularComision(double montoVenta) {
        double porcentaje = (PORCENTAJE_BASE + cantidadLetras) / 100.0;
        return montoVenta * porcentaje;
    }
}
