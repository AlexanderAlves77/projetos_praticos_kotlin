package tssti.fullstack.backend_kotlin_rest_api.service.impl

import org.springframework.stereotype.Service
import tssti.fullstack.backend_kotlin_rest_api.entity.Pedido
import tssti.fullstack.backend_kotlin_rest_api.repository.PedidoRepository
import tssti.fullstack.backend_kotlin_rest_api.service.IPedidoService


@Service
class PedidoService(
    private val pedidoRepository: PedidoRepository
) : IPedidoService
{
    override fun salvarPedido(pedido: Pedido): Pedido =
        this.pedidoRepository.save(pedido)

    override fun findAllPedidos(): List<Pedido> {
        return this.pedidoRepository.findAll()
    }

    override fun getPedidoById(pedidoId: Long): Pedido {
        return this.pedidoRepository.getReferenceById(pedidoId)
    }

    override fun deletePedido(pedidoId: Long) {
        this.pedidoRepository.deleteById(pedidoId)
    }
}