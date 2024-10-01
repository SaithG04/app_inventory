package ucv.app_inventory.login.dto;

/**
 * Clase que representa una solicitud de autenticación basada en un token JWT.
 *
 * Se utiliza para encapsular el token JWT enviado en solicitudes de
 * autenticación o validación de usuarios.
 */
public class JwtRequest {

    /**
     * Token JWT que se envía en la solicitud.
     */
    private String token;

    /**
     * Constructor para inicializar el objeto {@code JwtRequest} con un token
     * específico.
     *
     * @param token El token JWT que se envía en la solicitud.
     */
    public JwtRequest(String token) {
        this.token = token;
    }

    /**
     * Obtiene el token JWT de la solicitud.
     *
     * @return El token JWT actual.
     */
    public String getToken() {
        return token;
    }

    /**
     * Establece un nuevo token JWT para la solicitud.
     *
     * @param token El nuevo token JWT.
     */
    public void setToken(String token) {
        this.token = token;
    }
}
