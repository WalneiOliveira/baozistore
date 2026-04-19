package com.baozi.baozistore.controller;

import com.baozi.baozistore.model.Produto;
import com.baozi.baozistore.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Indica que é um controlador REST
@RequestMapping("/produtos") // caminho base: localhost:8080/produtos
public class ProdutoController {

    @Autowired // injeta o repositório automaticamente
    private ProdutoRepository produtoRepository;

    // POST /produtos | Cria um novo produto
    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    // GET /produtos | Retorna todos os produtos
    @GetMapping
    public List<Produto> listaTodos() {
        return produtoRepository.findAll();
    }

    // GET /produtos/{id} → Buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /produtos/{id} → Apagar produto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id) {
        if (!produtoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
