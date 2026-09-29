package sv.edu.uees.programacion2;

import sv.edu.uees.programacion2.comision.ComisionEstandar;
import sv.edu.uees.programacion2.comision.ComisionPersonalizada;
import sv.edu.uees.programacion2.comision.EstrategiaComision;
import sv.edu.uees.programacion2.empleado.Vendedor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Sistema de comisiones ===");

            String nombre = leerNombre(scanner);
            double ventasMes = leerVentas(scanner);

            // Todo vendedor utiliza inicialmente la comision estandar.
            EstrategiaComision estrategiaInicial = new ComisionEstandar();
            Vendedor vendedor = new Vendedor(nombre, ventasMes, estrategiaInicial);

            int tipoComision = leerTipoComision(scanner);
            if (tipoComision == 2) {
                vendedor.cambiarEstrategia(new ComisionPersonalizada(nombre));
            }

            System.out.println("\n=== Detalle del vendedor ===");
            vendedor.mostrarDetalle();
        }
    }

    private static String leerNombre(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese su primer nombre: ");
            String nombre = scanner.nextLine().trim();

            if (!nombre.isEmpty() && nombre.codePoints().allMatch(Character::isLetter)) {
                return nombre;
            }

            System.out.println("Error: ingrese un nombre que contenga solamente letras.");
        }
    }

    private static double leerVentas(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese el total de ventas del mes: $");
            String entrada = scanner.nextLine().trim().replace(',', '.');

            try {
                double ventas = Double.parseDouble(entrada);
                if (Double.isFinite(ventas) && ventas >= 0) {
                    return ventas;
                }
            } catch (NumberFormatException ignored) {
                // El mensaje de validacion se muestra debajo.
            }

            System.out.println("Error: ingrese un monto numerico mayor o igual a cero.");
        }
    }

    private static int leerTipoComision(Scanner scanner) {
        while (true) {
            System.out.println("\nSeleccione el tipo de comision:");
            System.out.println("1. Estandar (5 %)");
            System.out.println("2. Personalizada (5 % + cantidad de letras del nombre)");
            System.out.print("Opcion: ");

            String opcion = scanner.nextLine().trim();
            if (opcion.equals("1") || opcion.equals("2")) {
                return Integer.parseInt(opcion);
            }

            System.out.println("Error: seleccione la opcion 1 o 2.");
        }
    }
}
