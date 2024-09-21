package tssti.fullstack.backend_kotlin_rest_api.dto

import tssti.fullstack.backend_kotlin_rest_api.entity.Produto

data class ProdutoDTO(
    val produtoId: Long,
    var nome: String
)
{
    fun toEntity() : Produto = Produto(
        id = this.produtoId,
        nome = this.nome
    )
}
