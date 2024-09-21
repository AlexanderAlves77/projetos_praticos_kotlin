package tssti.fullstack.backend_kotlin_rest_api.dto

import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria

data class CategoriaDTO(
    val categoriaID: Long,
    var nome: String,
    var unidade: String
)
{
    fun toEntity() : Categoria = Categoria(
        id = this.categoriaID,
        nome = this.nome,
        unidade = this.unidade
    )
}
