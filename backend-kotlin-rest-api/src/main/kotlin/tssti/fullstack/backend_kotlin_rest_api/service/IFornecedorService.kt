package tssti.fullstack.backend_kotlin_rest_api.service

import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor

interface IFornecedorService {

    fun save(categoria: Fornecedor) : Fornecedor
    fun findAll() : List<Fornecedor>
    fun getById(fornecedorId: Long) : Fornecedor
    fun delete(fornecedorId: Long)
}