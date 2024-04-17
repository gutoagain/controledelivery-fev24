package dev.wakandaacademy.controledelivery.entrega.domain;

import dev.wakandaacademy.controledelivery.entrega.application.api.EntregaRequest;
import dev.wakandaacademy.controledelivery.pedido.domain.StatusPedido;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Log4j2
@Document(collection = "Entrega")
public class Entrega {
    @Id
    private UUID idEntrega;
    @NotBlank
    private String endereco;
    @Indexed
    private UUID idPedido;
    @Builder.Default
    private StatusEntrega status = StatusEntrega.A_FAZER;

    public Entrega(EntregaRequest entregaRequest) {
        this.idEntrega = UUID.randomUUID();
        this.endereco = entregaRequest.getEndereco();
        this.idPedido = entregaRequest.getIdPedido();
        this.status = StatusEntrega.A_FAZER;
    }
}
