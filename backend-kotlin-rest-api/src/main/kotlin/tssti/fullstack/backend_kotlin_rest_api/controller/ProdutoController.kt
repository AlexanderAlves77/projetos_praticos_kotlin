package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tssti.fullstack.backend_kotlin_rest_api.dto.PedidoDTO
import tssti.fullstack.backend_kotlin_rest_api.dto.ProdutoDTO
import tssti.fullstack.backend_kotlin_rest_api.entity.Pedido
import tssti.fullstack.backend_kotlin_rest_api.entity.Produto
import tssti.fullstack.backend_kotlin_rest_api.view.ProdutoView
import tssti.fullstack.backend_kotlin_rest_api.service.impl.ProdutoService
import java.util.stream.Collectors

@RestController
@RequestMapping("api/produto")
class ProdutoController(
    private val produtoService: ProdutoService
)
{
    @GetMapping
    fun findAll() : ResponseEntity<List<ProdutoView>> {
        val lista: List<ProdutoView> =
            this.produtoService.findAll().stream().map {
                objDTO: Produto -> ProdutoView(objDTO)
            }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(lista)
    }

    @PostMapping
    fun save(@RequestBody dto: ProdutoDTO) : ResponseEntity<String> {
        val objDTO = this.produtoService.save(dto.toEntity())
        val mensagem = "POST: Novo Produto ${objDTO.nome} salvo com sucesso!"
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) : ResponseEntity<String> {
        val objDTO : Produto = this.produtoService.getById(id)
        val mensagem = "*** Produto ${objDTO.nome} recuperado com sucesso! ***"
        return ResponseEntity.ok(mensagem)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<String> {
        this.produtoService.delete(id)
        return ResponseEntity.noContent().build()
    }
}