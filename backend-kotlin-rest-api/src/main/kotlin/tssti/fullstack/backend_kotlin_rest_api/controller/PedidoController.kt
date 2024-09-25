package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tssti.fullstack.backend_kotlin_rest_api.dto.PedidoDTO
import tssti.fullstack.backend_kotlin_rest_api.entity.Pedido
import tssti.fullstack.backend_kotlin_rest_api.view.PedidoView
import tssti.fullstack.backend_kotlin_rest_api.service.impl.PedidoService
import java.util.stream.Collectors

@RestController
@RequestMapping("api/pedido")
class PedidoController(
    private val pedidoService: PedidoService
)
{
    @GetMapping
    fun getAllPedidos() : ResponseEntity<List<PedidoView>> {
        val pedidos: List<PedidoView> =
            this.pedidoService.findAll().stream().map {
                pedido: Pedido -> PedidoView(pedido)
            }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(pedidos)
    }

    @PostMapping
    fun salvarPedido(@RequestBody dto: PedidoDTO) : String {
        val objDTO = this.pedidoService.save(dto.toEntity())
        return "*** POST: Novo Pedido ${objDTO.codigoPedido} salvo com sucesso! ***"
    }

    @GetMapping("/{id}")
    fun getPedidoById(@PathVariable id: Long) : PedidoView {
        val objDTO : Pedido = this.pedidoService.getById(id)
        return PedidoView(objDTO)
    }

    @DeleteMapping("/{id}")
    fun deletePedido(@PathVariable id: Long) = this.pedidoService.delete(id)
}