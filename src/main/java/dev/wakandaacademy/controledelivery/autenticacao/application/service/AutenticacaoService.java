package dev.wakandaacademy.controledelivery.autenticacao.application.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import dev.wakandaacademy.controledelivery.autenticacao.domain.Token;

public interface AutenticacaoService {
    Token autentica(UsernamePasswordAuthenticationToken userCredentials);
    Token reativaToken(String tokenExpirado);
}
