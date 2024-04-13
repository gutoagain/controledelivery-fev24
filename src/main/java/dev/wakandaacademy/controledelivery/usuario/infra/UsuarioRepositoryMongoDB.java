package dev.wakandaacademy.controledelivery.usuario.infra;

import dev.wakandaacademy.controledelivery.usuario.application.repository.UsuarioRepository;
import dev.wakandaacademy.controledelivery.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class UsuarioRepositoryMongoDB implements UsuarioRepository {
    private final UsuarioMongoSpringRepository usuarioMongoRepository;

    @Override
    public Usuario salva(Usuario usuario) {
        log.info("[inicia] UsuarioRepositoryMongoDB - salva");
        Usuario novoUsuario = usuarioMongoRepository.save(usuario);
        log.info("[finaliza] UsuarioRepositoryMongoDB - salva");
        return novoUsuario;
    }
}
