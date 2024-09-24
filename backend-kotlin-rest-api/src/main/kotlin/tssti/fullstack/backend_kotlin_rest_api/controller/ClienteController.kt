package tssti.fullstack.backend_kotlin_rest_api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
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


}