package dev.wakandaacademy.controledelivery.pedido.domain;

import dev.wakandaacademy.controledelivery.entrega.domain.Entrega;
import dev.wakandaacademy.controledelivery.pedido.application.api.EditaPedidoRequest;
import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoRequest;
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
@Document(collection = "Pedido")
public class Pedido {
    @Id
    private UUID idPedido;
    @NotBlank
    private String nomeProduto;
    @Indexed
    private UUID idCliente;
    @Builder.Default
    private StatusPedido status = StatusPedido.AGUARDANDO_CONFIRMACAO;
    @Setter
    private int posicao;

    public Pedido(PedidoRequest pedidoRequest, int posicaoDoNovoPedido) {
        this.idPedido = UUID.randomUUID();
        this.nomeProduto = pedidoRequest.getNomeProduto();
        this.idCliente = pedidoRequest.getIdCliente();
        this.status = StatusPedido.AGUARDANDO_CONFIRMACAO;
        this.posicao = posicaoDoNovoPedido;
    }

    public void altera(EditaPedidoRequest pedidoRequest) {
        this.nomeProduto = pedidoRequest.getNomeProduto();
    }

    public void mudaStatusParaEnviado() {
        log.info("[inicia] Pedido - mudaStatusParaEnviado");
        this.status = StatusPedido.ENVIADO;
        log.info("[finaliza] Pedido - mudaStatusParaEnviado");
    }
}
