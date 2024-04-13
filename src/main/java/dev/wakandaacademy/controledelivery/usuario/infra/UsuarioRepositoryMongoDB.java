package dev.wakandaacademy.controledelivery.usuario.infra;

import dev.wakandaacademy.controledelivery.handler.APIException;
import dev.wakandaacademy.controledelivery.usuario.application.repository.UsuarioRepository;
import dev.wakandaacademy.controledelivery.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

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

    @Override
    public Usuario buscaUsuarioPorId(UUID idUsuario) {
        log.info("[inicia] UsuarioRepositoryMongoDB - buscaUsuarioPorId");
        Usuario usuario = usuarioMongoRepository.findByIdUsuario(idUsuario)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Usuario não encontrado!"));
        log.info("[finaliza] UsuarioRepositoryMongoDB - buscaUsuarioPorId");
        return usuario;
    }
}
