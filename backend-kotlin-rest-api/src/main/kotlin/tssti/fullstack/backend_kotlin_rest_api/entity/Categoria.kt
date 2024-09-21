package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.*

@Entity
data class Categoria(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val categoriaId: Long? = null,

    @Column(nullable = false)
    var nome: String = "",

    @Column(nullable = false)
    var unidade: String = ""
)