package ucv.app_inventory.login.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO para recibir las credenciales de inicio de sesión.
 */
public class LoginRequest {

    @NotBlank(message = "El email es obligatorio")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    private String clave;

    // Getters y Setters

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getClave() {
        return clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
}
