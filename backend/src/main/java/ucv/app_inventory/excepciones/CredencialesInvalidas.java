package ucv.app_inventory.excepciones;

public class CredencialesInvalidas extends RuntimeException {

    public CredencialesInvalidas(String mensaje) {
        super(mensaje);
    }
}
