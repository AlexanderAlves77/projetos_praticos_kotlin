package tssti.fullstack.backend_kotlin_rest_api.dto

import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria

data class CategoriaDTO(
    val categoriaId: Long,
    var nome: String,
    var unidade: String
)
{
    fun toEntity() : Categoria = Categoria(
        id = this.categoriaId,
        nome = this.nome,
        unidade = this.unidade
    )
}
