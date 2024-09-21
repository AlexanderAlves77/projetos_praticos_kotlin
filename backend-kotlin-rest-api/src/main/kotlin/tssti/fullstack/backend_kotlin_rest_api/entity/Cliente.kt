package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.*

@Entity
data class Cliente(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val clienteId: Long? = null,
    var nome: String = "",
    var email: String = ""
    //var listaDeObjetos: List<Object> = mutableListOf()
)