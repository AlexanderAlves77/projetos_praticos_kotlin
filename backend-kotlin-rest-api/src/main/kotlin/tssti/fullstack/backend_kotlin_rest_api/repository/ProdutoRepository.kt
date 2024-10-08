package tssti.fullstack.backend_kotlin_rest_api.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import tssti.fullstack.backend_kotlin_rest_api.entity.Produto


@Repository
interface ProdutoRepository : JpaRepository<Produto, Long> {

    @Query(value = "SELECT * FROM produto", nativeQuery = true)
    fun getAll() : List<Produto>
}