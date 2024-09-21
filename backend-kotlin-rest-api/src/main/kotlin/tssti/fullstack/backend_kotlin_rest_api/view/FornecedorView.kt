package tssti.fullstack.backend_kotlin_rest_api.view

import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor

data class FornecedorView(
    val fornecedorId: Long?,
    val nome: String
)
{
    constructor(fornecedor: Fornecedor) : this(
        fornecedorId = fornecedor.fornecedorId,
        nome = fornecedor.nome
    )
}