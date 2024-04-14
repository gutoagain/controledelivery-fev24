package dev.wakandaacademy.controledelivery.cliente.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/cliente")
public interface ClienteAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteIdResponse postNovoCliente(@RequestHeader(name = "Authorization", required = true) String token,
                                      @RequestBody @Valid ClienteRequest clienteRequest);

    @GetMapping("/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteDetalhadoResponse consultaCliente(@RequestHeader(name = "Authorization", required = true) String token,
                                          @PathVariable UUID idCliente);
}
