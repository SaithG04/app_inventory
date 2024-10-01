package ucv.app_inventory.login.controlador;

import ucv.app_inventory.login.auth.AutenticacionUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ucv.app_inventory.login.dto.JwtResponse;
import ucv.app_inventory.login.dto.LoginRequest;
import ucv.app_inventory.excepciones.CredencialesInvalidas;

/**
 * Controlador REST para manejar la autenticación de usuarios.
 */
@RestController
@RequestMapping("/api/v1/auth")
public class ControladorLogin {

    private static final Logger logger = LoggerFactory.getLogger(ControladorLogin.class);

    private final AutenticacionUsuario autenticacionUsuario;

    public ControladorLogin(AutenticacionUsuario autenticacionUsuario) {
        this.autenticacionUsuario = autenticacionUsuario;
    }

    /**
     * Autentica al usuario y devuelve un token JWT.
     *
     * @param loginRequest Objeto que contiene las credenciales del usuario.
     * @return ResponseEntity con el token JWT o un mensaje de error.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            String token = autenticacionUsuario.autenticarUsuario(loginRequest.getEmail(), loginRequest.getClave());
            logger.info("Usuario autenticado: {}", loginRequest.getEmail());
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (CredencialesInvalidas e) {
            logger.error("Error de autenticación: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
        }
    }
}
