package tssti.fullstack.backend_kotlin_rest_api.controller

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tssti.fullstack.backend_kotlin_rest_api.dto.ProdutoDTO
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
    fun getAllProdutos() : ResponseEntity<List<ProdutoView>> {
        val produtos: List<ProdutoView> =
            this.produtoService.findAllProdutos().stream().map {
                produto: Produto -> ProdutoView(produto)
            }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(produtos)
    }

    @PostMapping
    fun salvarProduto(@RequestBody dto: ProdutoDTO) : String {
        val objDTO = this.produtoService.salvarProduto(dto.toEntity())
        return "*** POST: Novo Produto ${objDTO.nome} salvo com sucesso! ***"
    }

    @GetMapping("/{id}")
    fun getProdutoById(@PathVariable id: Long) : ProdutoView {
        val objDTO : Produto = this.produtoService.getProdutoById(id)
        return ProdutoView(objDTO)
    }

    @DeleteMapping("/{id}")
    fun deleteProduto(@PathVariable id: Long) = this.produtoService.deleteProduto(id)
}