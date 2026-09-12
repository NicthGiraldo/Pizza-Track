public class Pizza {

    String[] ingredientes = new String[3];
    String nombrePizza;

    public Pizza(String[] ingredientes, String nombrePizza) {
        for (int i = 0; i < 3; i++) {
            this.ingredientes[i] = ingredientes[i];
        }
        this.nombrePizza = nombrePizza;
    }

}