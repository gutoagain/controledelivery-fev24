package dev.wakandaacademy.controledelivery.pedido.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/pedido")
public interface PedidoAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PedidoIdResponse postNovoPedido(@RequestHeader(name = "Authorization", required = true) String token,
                                    @RequestBody @Valid PedidoRequest pedidoRequest);
}
