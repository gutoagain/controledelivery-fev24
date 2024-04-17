package dev.wakandaacademy.controledelivery.entrega.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/entrega")
public interface EntregaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EntregaIdResponse postNovaEntrega(@RequestHeader(name = "Authorization", required = true) String token,
                                      @RequestBody @Valid EntregaRequest entregaRequest);

    @GetMapping("/{idEntrega}")
    @ResponseStatus(code = HttpStatus.OK)
    EntregaDetalhadoResponse consultaEntrega(@RequestHeader(name = "Authorization", required = true) String token,
                                             @PathVariable UUID idEntrega);

    @PatchMapping("/alteraDadosEntrega/{idEntrega}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraDadosEntrega(@RequestHeader(name = "Authorization", required = true) String token,
                            @PathVariable UUID idEntrega,
                            @RequestBody @Valid EditaEntregaRequest entregaRequest);
}
