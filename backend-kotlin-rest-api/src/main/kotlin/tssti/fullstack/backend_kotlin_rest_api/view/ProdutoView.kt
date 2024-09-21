package tssti.fullstack.backend_kotlin_rest_api.view

import tssti.fullstack.backend_kotlin_rest_api.entity.Produto

data class ProdutoView(
    val produtoId: Long?,
    val nome: String
)
{
    constructor(produto: Produto) : this(
        produtoId = produto.produtoId,
        nome = produto.nome
    )
}