package dev.wakandaacademy.controledelivery.usuario.application.repository;

import dev.wakandaacademy.controledelivery.usuario.domain.Usuario;

import java.util.UUID;

public interface UsuarioRepository {
    Usuario salva(Usuario usuario);
    Usuario buscaUsuarioPorId(UUID idUsuario);
}
