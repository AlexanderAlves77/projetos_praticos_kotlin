package tssti.fullstack.backend_kotlin_rest_api.controller

import jakarta.validation.Valid
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
    fun getAllClientes() : ResponseEntity<List<ClienteView>> {
        val clientes: List<ClienteView> =
            this.clienteService.findAllClientes().stream().map {
                cliente: Cliente -> ClienteView(cliente)
            }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(clientes)
    }

    @PostMapping
    fun salvarCliente(@RequestBody dto: ClienteDTO) : String {
        val objDTO = this.clienteService.salvarCliente(dto.toEntity())
        return "*** POST: Novo Cliente ${objDTO.nome} salvo com sucesso! ***"
    }

    @GetMapping("/{id}")
    fun getClienteById(@PathVariable id: Long) : ClienteView {
        val objDTO : Cliente = this.clienteService.getClienteById(id)
        return ClienteView(objDTO)
    }

    @DeleteMapping("/{id}")
    fun deleteCliente(@PathVariable id: Long) = this.clienteService.deleteCliente(id)
}