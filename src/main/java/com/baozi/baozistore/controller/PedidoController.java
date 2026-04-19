package com.baozi.baozistore.controller;

import com.baozi.baozistore.model.Pedido;
import com.baozi.baozistore.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Indica que é um controlador REST
@RequestMapping("/pedidos") // caminho base: localhost:8080/pedidos
public class PedidoController {

    @Autowired // injeta o repositório automaticamente
    private PedidoRepository pedidoRepository;

    // POST /pedidos | Cria um novo pedido
    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // GET /pedidos | Retorna todos os produtos
    @GetMapping
    public List<Pedido> listaTodos() {
        return pedidoRepository.findAll();
    }

    // GET /pedidos/{id} → Buscar pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /pedidos/{id} → Apagar pedido por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id) {
        if (!pedidoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pedidoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

