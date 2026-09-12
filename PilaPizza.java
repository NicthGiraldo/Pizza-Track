public class PilaPizza {
    private Pizza first_pizza;

    public PilaPizza() {
        this.first_pizza = null;
    }

    public void push(Pizza nueva) {
        nueva.siguiente = first_pizza;
        first_pizza = nueva;
    }

    public Pizza pop() {
        if (isEmpty())
            return null;
        Pizza aux = first_pizza;
        first_pizza = first_pizza.siguiente;

        aux.siguiente = null;

        return aux;
    }

    public Pizza peek() {
        if (isEmpty())
            return null;
        return first_pizza;
    }

    public boolean isEmpty() {
        return first_pizza == null;
    }

    public void mostrar() {
        if (isEmpty()) {
            System.out.println("  (bandeja vacía)");
            return;
        }

        Pizza aux = first_pizza;

        System.out.println("  Primera pizza (arriba)");
        while (aux != null) {
            System.out.println("   " + aux);
            aux = aux.siguiente;
        }
        System.out.println("  Pizza final (abajo)");
    }
}
