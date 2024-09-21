package tssti.fullstack.backend_kotlin_rest_api.service

import tssti.fullstack.backend_kotlin_rest_api.entity.Pedido

interface IPedidoService {

    fun salvarPedido(pedido: Pedido) : Pedido
    fun findAllPedidos() : List<Pedido>
    fun getPedidoById(pedidoId: Long) : Pedido
    fun deletePedido(pedidoId: Long)
}