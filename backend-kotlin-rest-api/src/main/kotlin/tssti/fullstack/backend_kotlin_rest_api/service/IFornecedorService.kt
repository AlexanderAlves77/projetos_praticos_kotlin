package tssti.fullstack.backend_kotlin_rest_api.service

import tssti.fullstack.backend_kotlin_rest_api.entity.Fornecedor

interface IFornecedorService {

    fun salvarFornecedor(categoria: Fornecedor) : Fornecedor
    fun findAllFornecedores() : List<Fornecedor>
    fun getFornecedorById(fornecedorId: Long) : Fornecedor
    fun deleteFornecedor(fornecedorId: Long)
}