package com.baozi.baozistore.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity // Marca esta classe como entidade JPA (tabela)
@Table(name = "produto") // Nome da tabela no banco
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento
    private Long id;

    @Column(nullable = false) // Campo obrigatório
    private String nome;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private Boolean estoque;

    // Construtor vazio (obrigatório pelo JPA)
    public Produto() {
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Boolean getEstoque() {
        return estoque;
    }

    public void setEstoque(Boolean estoque) {
        this.estoque = estoque;
    }

}
