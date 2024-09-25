package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tssti.fullstack.backend_kotlin_rest_api.dto.ClienteDTO
import tssti.fullstack.backend_kotlin_rest_api.entity.Cliente
import tssti.fullstack.backend_kotlin_rest_api.view.ClienteView
import tssti.fullstack.backend_kotlin_rest_api.service.impl.ClienteService
import java.util.stream.Collectors

@RestController
@RequestMapping("api/cliente")
class ClienteController(
    private val clienteService: ClienteService
)
{
    @GetMapping
    fun findAll() : ResponseEntity<List<ClienteView>> {
        val lista: List<ClienteView> =
            this.clienteService.findAll().stream().map {
                objDTO: Cliente -> ClienteView(objDTO)
            }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(lista)
    }

    /*
    @PostMapping
    fun save(@RequestBody dto: ClienteDTO) : String {
        val objDTO = this.clienteService.save(dto.toEntity())
        return "*** POST: Novo Cliente ${objDTO.nome} salvo com sucesso! ***"
    } */

    @PostMapping
    fun save(@RequestBody dto: ClienteDTO) : ResponseEntity<String> {
        val objDTO = this.clienteService.save(dto.toEntity())
        val mensagem = "*** POST: Novo Cliente ${objDTO.nome} salvo com sucesso! ***"
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem)
    }

    /*
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) : ClienteView {
        val objDTO : Cliente = this.clienteService.getById(id)
        return ClienteView(objDTO)
    } */

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) : ResponseEntity<String> {
        val objDTO : Cliente = this.clienteService.getById(id)
        val mensagem = "*** Cliente ${objDTO.nome} recuperado com sucesso! ***"
        return ResponseEntity.ok(mensagem)
    }

    /*
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = this.clienteService.delete(id) */

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<String> {
        this.clienteService.delete(id)
        return ResponseEntity.noContent().build()
    }
}