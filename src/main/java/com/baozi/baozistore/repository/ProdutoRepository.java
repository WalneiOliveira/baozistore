package com.baozi.baozistore.repository;

import com.baozi.baozistore.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // JPA fornece: save, findById, findAll, deleteById etc.
}
