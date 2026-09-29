package sv.edu.uees.programacion2.empleado;

import sv.edu.uees.programacion2.comision.EstrategiaComision;

/** Clase base para los distintos tipos de empleados. */
public abstract class Empleado {
    protected String nombre;
    protected double ventasMes;
    protected EstrategiaComision estrategia;

    protected Empleado(String nombre, double ventasMes, EstrategiaComision estrategia) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (estrategia == null) {
            throw new IllegalArgumentException("La estrategia es obligatoria");
        }

        this.nombre = nombre;
        this.ventasMes = ventasMes;
        this.estrategia = estrategia;
    }

    /** Permite cambiar el calculo de comision durante la ejecucion. */
    public void cambiarEstrategia(EstrategiaComision nueva) {
        if (nueva == null) {
            throw new IllegalArgumentException("La nueva estrategia es obligatoria");
        }
        this.estrategia = nueva;
    }

    public abstract void mostrarDetalle();
}
