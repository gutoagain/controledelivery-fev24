package dev.wakandaacademy.controledelivery.autenticacao.application.api;

import dev.wakandaacademy.controledelivery.autenticacao.domain.Token;
import lombok.Value;

@Value
public class TokenResponse {
    private String token;
    private String tipo;

    public TokenResponse(Token token) {
        this.token = token.getToken();
        this.tipo = token.getTipo();
    }
}
