package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tssti.fullstack.backend_kotlin_rest_api.dto.FornecedorDTO
import tssti.fullstack.backend_kotlin_rest_api.dto.PedidoDTO
import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor
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
    fun findAll() : ResponseEntity<List<PedidoView>> {
        val lista: List<PedidoView> =
            this.pedidoService.findAll().stream().map {
                objDTO: Pedido -> PedidoView(objDTO)
            }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(lista)
    }

    @PostMapping
    fun save(@RequestBody dto: PedidoDTO) : ResponseEntity<String> {
        val objDTO = this.pedidoService.save(dto.toEntity())
        val mensagem = "POST: Novo Pedido ${objDTO.codigoPedido} salvo com sucesso!"
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) : ResponseEntity<String> {
        val objDTO : Pedido = this.pedidoService.getById(id)
        val mensagem = "*** Pedido ${objDTO.codigoPedido} recuperado com sucesso! ***"
        return ResponseEntity.ok(mensagem)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<String> {
        this.pedidoService.delete(id)
        return ResponseEntity.noContent().build()
    }
}