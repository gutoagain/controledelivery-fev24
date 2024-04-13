package dev.wakandaacademy.controledelivery.autenticacao.application.service;

import dev.wakandaacademy.controledelivery.autenticacao.domain.Token;
import dev.wakandaacademy.controledelivery.config.security.service.TokenService;
import dev.wakandaacademy.controledelivery.credencial.application.service.CredencialService;
import dev.wakandaacademy.controledelivery.credencial.domain.Credencial;
import dev.wakandaacademy.controledelivery.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class AutenticacaoAppplicationService implements AutenticacaoService {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final CredencialService credencialService;

    @Override
    public Token autentica(UsernamePasswordAuthenticationToken userCredentials) {
        log.info("[inicio] AutenticacaoAppplicationService - autentica");
        var authentication = authenticationManager.authenticate(userCredentials);
        Token token = Token.builder()
                .tipo("Bearer")
                .token(tokenService.gerarToken(authentication))
                .build();
        log.info("[inicio] AutenticacaoAppplicationService - autentica");
        return token;
    }

    @Override
    public Token reativaToken(String tokenExpirado) {
        log.info("[inicio] service - reativaAutenticacao");
        var usuario = extraiUsuario(tokenExpirado);
        Credencial credencial = credencialService.buscaCredencialPorUsuario(usuario);
        log.info("[finaliza] service - reativaAutenticacao");
        return Token.builder().tipo("Bearer")
                .token(tokenService.gerarToken(credencial))
                .build();
    }

    private String extraiUsuario(String tokenExpirado){
        return tokenService.getUsuario(tokenExpirado)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Token Invalido!"));
    }
}
