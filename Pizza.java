public class Pizza {

    String[] ingredientes = new String[3];
    String nombrePizza;

    Pizza siguiente;

    public Pizza(String[] ingredientes, String nombrePizza) {
        for (int i = 0; i < 3; i++) {
            this.ingredientes[i] = ingredientes[i];
        }
        this.nombrePizza = nombrePizza;
        this.siguiente = null;
    }

    @Override 
    public String toString(){
        String lista = "";
        for (int i = 0; i < 3; i++) {
            lista += ingredientes[i];
            if (i < 2) lista += ", ";
        }

        return "[Nombre de la pizza: " + nombrePizza 
             + " | Requisitos: " + lista + "]";
    }

}