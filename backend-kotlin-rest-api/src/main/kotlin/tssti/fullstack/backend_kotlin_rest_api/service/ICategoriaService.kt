package tssti.fullstack.backend_kotlin_rest_api.service

import tssti.fullstack.backend_kotlin_rest_api.entity.Categoria

interface ICategoriaService {

    fun salvarCategoria(categoria: Categoria) : Categoria
    fun findAllCategoria() : List<Categoria>
    fun getCategoriaById(categoriaId: Long) : Categoria
    fun deleteCategoria(categoriaId: Long)
}