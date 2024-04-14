package dev.wakandaacademy.controledelivery.cliente.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/cliente")
public interface ClienteAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteIdResponse postNovoCliente(@RequestHeader(name = "Authorization", required = true) String token,
                                      @RequestBody @Valid ClienteRequest clienteRequest);
}
