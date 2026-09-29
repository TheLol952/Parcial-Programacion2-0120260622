package sv.edu.uees.programacion2.comision;

/** Estrategia que aplica una comision fija del 5 %. */
public class ComisionEstandar implements EstrategiaComision {
    private static final double PORCENTAJE_COMISION = 0.05;

    @Override
    public double calcularComision(double montoVenta) {
        return montoVenta * PORCENTAJE_COMISION;
    }
}
