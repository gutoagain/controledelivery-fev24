package dev.wakandaacademy.controledelivery.entrega.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/entrega")
public interface EntregaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EntregaIdResponse postNovaEntrega(@RequestHeader(name = "Authorization", required = true) String token,
                                    @RequestBody @Valid EntregaRequest entregaRequest);
}
