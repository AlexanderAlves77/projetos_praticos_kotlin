package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.*

@Entity
data class Fornecedor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val fornecedorId: Long? = null,
    var nome: String = "",
)
