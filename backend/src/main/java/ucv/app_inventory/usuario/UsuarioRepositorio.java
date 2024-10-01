package ucv.app_inventory.usuario;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByStatus(String status);

    List<Usuario> findByFullname(String fullname);

    List<Usuario> findByRole(String role);

    long countByStatus(String status);

    Optional<Usuario> findByEmailAndStatus(String email, String status);

    List<Usuario> findByCreatedAtAfter(LocalDateTime date);

}
