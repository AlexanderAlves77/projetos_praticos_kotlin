package tssti.fullstack.backend_kotlin_rest_api.dto

import tssti.fullstack.backend_kotlin_rest_api.entity.Cliente

data class ClienteDTO(
    val clienteID: Long,
    var nome: String,
    var email: String
)
{
    fun toEntity() : Cliente = Cliente(
        clienteID = this.clienteID,
        nome = this.nome,
        email = this.email
    )
}