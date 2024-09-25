package tssti.fullstack.backend_kotlin_rest_api.service

import tssti.fullstack.backend_kotlin_rest_api.entity.Cliente

interface IClienteService {

    fun save(cliente: Cliente) : Cliente
    fun findAll() : List<Cliente>
    fun getById(clienteId: Long) : Cliente
    fun delete(clienteId: Long)
}