package tssti.fullstack.backend_kotlin_rest_api.view

import tssti.fullstack.backend_kotlin_rest_api.entity.Pedido

data class PedidoView(
    val pedidoId: Long?,
    val nomeCliente: String,
    val nomeProduto: String
)
{
    constructor(pedido: Pedido) : this(
        pedidoId = pedido.pedidoId,
        nomeCliente = pedido.cliente?.nome.toString(),
        nomeProduto = pedido.produto?.nome.toString()
    )
}