package tssti.fullstack.backend_kotlin_rest_api.view

import tssti.fullstack.backend_kotlin_rest_api.entity.Cliente

data class ClienteView(
    val clienteId: Long?,
    val nome: String
)
{
    constructor(cliente: Cliente) : this(
        clienteId = cliente.clienteId,
        nome = cliente.nome
    )
}