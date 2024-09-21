package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.*
import tssti.fullstack.backend_kotlin_rest_api.common.UnidadeMedida

@Entity
data class Produto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val produtoId: Long? = null,
    val nome: String = "",

    @Column(nullable = false)
    @Enumerated
    val unidade: UnidadeMedida = UnidadeMedida.UNIDADE,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    val categoria: Categoria? = null,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    val fornecedor: List<Fornecedor> = emptyList()
)
