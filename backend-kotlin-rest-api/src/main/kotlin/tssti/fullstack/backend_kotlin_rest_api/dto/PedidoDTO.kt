package tssti.fullstack.backend_kotlin_rest_api.dto

import tssti.fullstack.backend_kotlin_rest_api.entity.Pedido
import java.util.*

data class PedidoDTO(
    val pedidoId: Long,
    val codigoPedido: UUID
)
{
    fun toEntity() : Pedido = Pedido(
        pedidoId = this.pedidoId,
        codigoPedido = this.codigoPedido
    )
}
