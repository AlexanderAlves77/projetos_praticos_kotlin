package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tssti.fullstack.backend_kotlin_rest_api.dto.FornecedorDTO
import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor
import tssti.fullstack.backend_kotlin_rest_api.view.FornecedorView
import tssti.fullstack.backend_kotlin_rest_api.service.impl.FornecedorService
import java.util.stream.Collectors

@RestController
@RequestMapping("api/fornecedor")
class FornecedorController(
    private val fornecedorService: FornecedorService
)
{
    @GetMapping
    fun getAllClientes() : ResponseEntity<List<FornecedorView>> {
        val fornecedores: List<FornecedorView> =
            this.fornecedorService.findAll().stream().map {
                fornecedor: Fornecedor -> FornecedorView(fornecedor)
            }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(fornecedores)
    }

    @PostMapping
    fun salvarFornecedor(@RequestBody dto: FornecedorDTO) : String {
        val objDTO = this.fornecedorService.save(dto.toEntity())
        return "*** POST: Novo Fornecedor ${objDTO.nome} salvo com sucesso! ***"
    }

    @GetMapping("/{id}")
    fun getFornecedorById(@PathVariable id: Long) : FornecedorView {
        val objDTO : Fornecedor = this.fornecedorService.getById(id)
        return FornecedorView(objDTO)
    }

    @DeleteMapping("/{id}")
    fun deleteFornecedor(@PathVariable id: Long) = this.fornecedorService.delete(id)
}