import java.util.Locale;
import java.util.Scanner;

public class PizzaTrackMain {
    public static void main(String[] args) {
        GestionPedidos gestion = new GestionPedidos();

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        int opc = -1;

        do {
            System.out.println("\n--- Bienvenido a la pizzería Pizza-Track!! ---");
            System.out.println("  1. Registrar una Pizza (Escribir)");
            System.out.println("  2. Deshacer un pedido (Undo)");
            System.out.println("  3. Rehacer un pedido (Redo)");
            System.out.println("  4. Mostrar el Pedido Actual");
            System.out.println("  5. Verificar si hay pedidos pendientes");
            System.out.println("  6. Mostrar los pedidos pendientes");
            System.out.println("  7. Mostrar los pedidos deshechos");
            System.out.println("  0. Salir");
            System.out.print("Opción: ");

            try {
                opc = sc.nextInt();

                sc.nextLine();

                switch (opc) {
                    case 1:
                        gestion.ingresarPedido(leer(sc));
                        System.out.println("Ingresó una pizza a la pila principal.");
                        break;

                    case 2: {
                        Pizza salio = gestion.deshacerPedido();
                        if (salio != null)
                            System.out.println("Pedido deshecho y enviado a la pila secundaria: " + salio);
                        else
                            System.out.println("No hay pedidos pendientes para deshacer.");
                        break;
                    }

                    case 3: {
                        Pizza rehecha = gestion.rehacerPedido();
                        if (rehecha != null)
                            System.out.println("Pedido rehecho y devuelto a la pila principal: " + rehecha);
                        else
                            System.out.println("No hay pedidos deshechos para recuperar.");
                        break;
                    }

                    case 4:
                        Pizza actual = gestion.verSiguientePedido();
                        if (actual != null)
                            System.out.println("El pedido actual listo para producción es: " + actual);
                        else
                            System.out.println("No hay pedidos pendientes.");
                        break;

                    case 5:
                        if (gestion.noHayPedidosPendientes())
                            System.out.println("No, la pila de pedidos esta vacía.");
                        else
                            System.out.println("Si, aún hay pedidos pendientes.");
                        break;

                    case 6:
                        gestion.mostrarPedidosPendientes();
                        break;

                    case 7:
                        gestion.mostrarPedidosDeshechos();
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (Exception e) {
                System.out.println("Entrada no válida.");
                sc.nextLine();
            }

        } while (opc != 0);

        sc.close();

    }

    public static Pizza leer(Scanner sc) {
        System.out.print("Nombre de la pizza (ej. Pepperoni): ");
        String nombre = sc.nextLine();
        System.out.println("Ahora ingresa los ingredientes de la pizza (solo 3):");
        String[] ejemplos = { "Cebolla", "Pimientos", "Tomate" };
        String[] ingredientes = new String[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("  ingrediente " + (i + 1) + " (ej. " + ejemplos[i] + "): ");
            ingredientes[i] = sc.nextLine();
        }

        return new Pizza(ingredientes, nombre);
    }
}
