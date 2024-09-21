package tssti.fullstack.backend_kotlin_rest_api.view

import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria

data class CategoriaView(
    val categoriaId: Long?,
    val nome: String,
    val unidade: String
)
{
    constructor(categoria: Categoria) : this(
        categoriaId = categoria.categoriaId,
        nome = categoria.nome,
        unidade = categoria.unidade
    )
}