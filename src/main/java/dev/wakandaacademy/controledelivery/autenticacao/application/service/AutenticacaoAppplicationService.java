package dev.wakandaacademy.controledelivery.autenticacao.application.service;

import dev.wakandaacademy.controledelivery.autenticacao.domain.Token;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class AutenticacaoAppplicationService implements AutenticacaoService {

    @Override
    public Token autentica(UsernamePasswordAuthenticationToken userCredentials) {
        log.info("[inicio] AutenticacaoAppplicationService - autentica");
        log.info("[inicio] AutenticacaoAppplicationService - autentica");
        return null;
    }
}
