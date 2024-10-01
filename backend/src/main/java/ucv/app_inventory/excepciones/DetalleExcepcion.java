package ucv.app_inventory.excepciones;

public class DetalleExcepcion {

    private String mensaje;
    private String detalles;

    public DetalleExcepcion(String mensaje, String detalles) {
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getDetalles() {
        return detalles;
    }
}
