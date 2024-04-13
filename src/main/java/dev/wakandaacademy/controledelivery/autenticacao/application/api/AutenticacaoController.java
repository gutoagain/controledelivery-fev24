package dev.wakandaacademy.controledelivery.autenticacao.application.api;

import dev.wakandaacademy.controledelivery.autenticacao.application.service.AutenticacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class AutenticacaoController implements AutenticacaoAPI {
    private AutenticacaoService autenticacaoAppplicationService;

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    public TokenResponse autentica(AutenticacaoRequest autenticacaoRequest) {
        log.info("[inicio] Iniciando Metodo autenciacao em AutenticacaoController");
        var token = autenticacaoAppplicationService.autentica(autenticacaoRequest.getUserPassToken());
        log.info("[finaliza] Retornando Token para o cliente");
        return new TokenResponse(token);
    }
}
