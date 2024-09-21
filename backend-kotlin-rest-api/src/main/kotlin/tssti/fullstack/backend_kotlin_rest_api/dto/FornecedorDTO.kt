package tssti.fullstack.backend_kotlin_rest_api.dto

import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor

data class FornecedorDTO(
    val fornecedorId: Long,
    var nome: String
)
{
    fun toEntity() : Fornecedor = Fornecedor(
        fornecedorId = this.fornecedorId,
        nome = this.nome
    )
}