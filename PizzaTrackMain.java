import java.util.Locale;
import java.util.Scanner;

public class PizzaTrackMain {
    public static void main(String[] args) {
        PilaPizza bandeja = new PilaPizza();

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        int opc = -1;

        do {
            System.out.println("\n--- Bienvenido a la pizzería Pizza-Track!! ---");
            System.out.println(" PILA (bandeja de solicitudes)");
            System.out.println("   1. Ingresar una pizza     (push)");
            System.out.println("   2. Sacar una pizza        (pop)");
            System.out.println("   3. Ver pizza siguiente    (peek)");
            System.out.println("   4. hay pizzas en espera?  (isEmpty)");
            System.out.println("   5. Mostrar las pizzas en espera.");
            System.out.println(" 0. Salir");
            System.out.print("Opción: ");

            try {
                opc = sc.nextInt();

                sc.nextLine();

                switch (opc) {
                    case 1:
                        bandeja.push(leer(sc));
                        System.out.println("Ingresó una pizza: quedó ARRIBA de las demás.");
                        break;

                    case 2: {
                        Pizza salio = bandeja.pop();
                        if (salio != null)
                            System.out.println("Salió de la bandeja: " + salio);
                        else
                            System.out.println("La bandeja de pizzas esta vacía.");
                        break;
                    }

                    case 3: {
                        Pizza arriba = bandeja.peek();
                        if (arriba != null)
                            System.out.println("La primera pizza es: " + arriba);
                        else
                            System.out.println("La bandeja de pizzas esta vacía.");
                        break;
                    }

                    case 4:
                        if (bandeja.isEmpty())
                            System.out.println("Sí, la bandeja de pizzas está vacía.");
                        else
                            System.out.println("No, todavía hay pizzas en la bandeja.");
                        break;

                    case 5:
                        bandeja.mostrar();
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
        sc.nextLine();
        System.out.println("Ahora ingresa los ingredientes de la pizza (solo 3):");
        String[] ejemplos = { "Cebolla", "Pimientos", "Tomate" };
        String[] ingredientes = new String[3];

        for (int i = 1; i <= 3; i++) {
            System.out.print("  ingrediente " + i + " (ej. " + ejemplos[i] + "): ");
            ingredientes[i] = sc.nextLine();
        }

        return new Pizza(ingredientes, nombre);
    }
}
