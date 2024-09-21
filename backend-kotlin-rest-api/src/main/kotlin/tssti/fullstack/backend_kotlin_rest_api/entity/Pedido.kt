package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
data class Pedido(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val pedidoId: Long? = null,
    val codigoPedido: UUID = UUID.randomUUID(),
    val quantidade: Int = 0,

    @Column(nullable = false)
    var preco: BigDecimal = BigDecimal.ZERO,

    @ManyToOne
    val cliente: Cliente? = null,

    @ManyToOne
    var produto: Produto? = null
)
