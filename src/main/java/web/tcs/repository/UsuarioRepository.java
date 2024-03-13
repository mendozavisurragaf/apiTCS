package web.tcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.tcs.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findOneByEmail(String email);
}
