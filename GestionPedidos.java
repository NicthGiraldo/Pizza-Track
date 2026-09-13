public class GestionPedidos {
    private PilaPizza pilaPrincipal;
    private PilaPizza pilaDeshechos;

    public GestionPedidos() {
        pilaPrincipal = new PilaPizza();
        pilaDeshechos = new PilaPizza();
    }

    public void ingresarPedido(Pizza pedido) {
        pilaPrincipal.push(pedido);
    }

    public Pizza deshacerPedido() {
        Pizza pedido = pilaPrincipal.pop();
        if (pedido != null) {
            pilaDeshechos.push(pedido);
        }
        return pedido;
    }

    public Pizza rehacerPedido() {
        Pizza pedido = pilaDeshechos.pop();
        if (pedido != null) {
            pilaPrincipal.push(pedido);
        }
        return pedido;
    }

    public Pizza recuperarPedido() {
        return rehacerPedido();
    }

    public Pizza verSiguientePedido() {
        return pilaPrincipal.peek();
    }

    public boolean noHayPedidosPendientes() {
        return pilaPrincipal.isEmpty();
    }

    public boolean noHayPedidosDeshechos() {
        return pilaDeshechos.isEmpty();
    }

    public void mostrarPedidosPendientes() {
        pilaPrincipal.mostrar();
    }

    public void mostrarPedidosDeshechos() {
        pilaDeshechos.mostrar();
    }
}
