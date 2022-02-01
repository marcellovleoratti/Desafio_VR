package br.com.desafiovr.Domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="produto", catalog="desafio_vr")
public class Produto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String Nome_produto;
    private String marca;
    private BigDecimal preco;
    private Long codigo_fabricante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_produto() {
        return Nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        Nome_produto = nome_produto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Long getCodigo_fabricante() {
        return codigo_fabricante;
    }

    public void setCodigo_fabricante(Long codigo_fabricante) {
        this.codigo_fabricante = codigo_fabricante;
    }
}
