package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
data class Pedido(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val codigoPedido: UUID = UUID.randomUUID(),
    val quantidade: Int = 0,
    val preco: BigDecimal = BigDecimal.ZERO,
    // val cliente: Cliente? = null
    // val produto: Produto? = null
)
