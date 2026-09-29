package sv.edu.uees.programacion2.empleado;

import sv.edu.uees.programacion2.comision.EstrategiaComision;

/** Empleado que muestra sus ventas y calcula su comision polimorficamente. */
public class Vendedor extends Empleado {
    public Vendedor(String nombre, double ventasMes, EstrategiaComision estrategia) {
        super(nombre, ventasMes, estrategia);
    }

    @Override
    public void mostrarDetalle() {
        double comision = estrategia.calcularComision(ventasMes);

        System.out.println("Nombre: " + nombre);
        System.out.printf("Venta total: $%.2f%n", ventasMes);
        System.out.printf("Comision obtenida: $%.2f%n", comision);
    }
}
