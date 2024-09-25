package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tssti.fullstack.backend_kotlin_rest_api.dto.CategoriaDTO
import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria
import tssti.fullstack.backend_kotlin_rest_api.service.impl.CategoriaService
import tssti.fullstack.backend_kotlin_rest_api.view.CategoriaView
import java.util.stream.Collectors

@RestController
@RequestMapping("api/categoria")
class CategoriaController(
    private val categoriaService: CategoriaService
)
{
    @GetMapping
    fun findAll() : ResponseEntity<List<CategoriaView>> {
        val lista: List<CategoriaView> =
            this.categoriaService.findAll().stream().map {
                objDTO: Categoria -> CategoriaView(objDTO)
            }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(lista)
    }

    @PostMapping
    fun save(@RequestBody dto: CategoriaDTO) : String {
        val objDTO = this.categoriaService.save(dto.toEntity())
        return "*** POST: Nova Categoria ${objDTO.nome} salva com sucesso! ***"
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) : CategoriaView {
        val objDTO : Categoria = this.categoriaService.getById(id)
        return CategoriaView(objDTO)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = this.categoriaService.delete(id)
}