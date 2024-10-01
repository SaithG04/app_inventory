package ucv.app_inventory.login.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import ucv.app_inventory.excepciones.CredencialesInvalidas;

/**
 * Servicio que maneja la autenticación de usuarios y generación de tokens JWT.
 */
@Service
public class AutenticacionUsuario {

    private final AuthenticationManager authenticationManager;
    private final TokenUsuario jwtTokenUsuario;

    @Autowired
    public AutenticacionUsuario(AuthenticationManager authenticationManager, TokenUsuario jwtTokenUsuario) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUsuario = jwtTokenUsuario;
    }

    /**
     * Autentica un usuario y genera un token JWT si las credenciales son
     * correctas.
     *
     * @param email Nombre de usuario.
     * @param clave Contraseña del usuario.
     * @return Token JWT generado.
     */
    public String autenticarUsuario(String email, String clave) {
        if (email == null || clave == null || email.isEmpty() || clave.isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario y la contraseña no deben estar vacíos");
        }

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, clave));
            return jwtTokenUsuario.generarToken(email);
        } catch (AuthenticationException e) {
            throw new CredencialesInvalidas("Usuario o contraseña incorrectos");
        }
    }
}
