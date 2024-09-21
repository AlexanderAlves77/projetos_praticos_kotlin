package tssti.fullstack.backend_kotlin_rest_api.dto

import tssti.fullstack.backend_kotlin_rest_api.entity.Cliente

data class ClienteDTO(
    val clienteId: Long,
    var nome: String,
    var email: String
)
{
    fun toEntity() : Cliente = Cliente(
        clienteId = this.clienteId,
        nome = this.nome,
        email = this.email
    )
}