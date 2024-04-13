package dev.wakandaacademy.controledelivery.autenticacao.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class AutenticacaoController implements AutenticacaoAPI {
    @Override
    @ResponseStatus(code = HttpStatus.OK)
    public TokenResponse autentica(AutenticacaoRequest autenticacaoRequest) {
        log.info("[inicio] Iniciando Metodo autenciacao em AutenticacaoController");
        log.info("[finaliza] Retornando Token para o cliente");
        return null;
    }
}
