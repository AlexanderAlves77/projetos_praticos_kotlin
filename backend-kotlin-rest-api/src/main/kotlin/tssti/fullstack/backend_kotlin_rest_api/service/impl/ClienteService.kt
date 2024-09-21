package tssti.fullstack.backend_kotlin_rest_api.service.impl

import org.springframework.stereotype.Service
import tssti.fullstack.backend_kotlin_rest_api.entity.Cliente
import tssti.fullstack.backend_kotlin_rest_api.repository.ClienteRepository
import tssti.fullstack.backend_kotlin_rest_api.service.IClienteService

@Service
class ClienteService(
    private val clienteRepository: ClienteRepository
) : IClienteService
{
    override fun salvarCliente(cliente: Cliente): Cliente =
        this.clienteRepository.save(cliente)

    override fun findAllClientes(): List<Cliente> {
        return this.clienteRepository.findAll()
    }

    override fun getClienteById(clienteId: Long): Cliente {
        return this.clienteRepository.getReferenceById(clienteId)
    }

    override fun deleteCliente(clienteId: Long) {
        this.clienteRepository.deleteById(clienteId)
    }


}