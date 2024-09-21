package tssti.fullstack.backend_kotlin_rest_api.entity

import jakarta.persistence.*

@Entity
data class Categoria(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var nome: String = "",
    var unidade: String = ""
    //var listaDeObjetos: List<Object> = mutableListOf()
)