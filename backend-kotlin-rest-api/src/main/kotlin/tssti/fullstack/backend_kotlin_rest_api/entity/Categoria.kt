package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.*

@Entity
data class Categoria(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val categoriaId: Long? = null,

    @Column(nullable = false)
    val nome: String = "",

    @Column(nullable = false)
    val unidade: String = ""
)