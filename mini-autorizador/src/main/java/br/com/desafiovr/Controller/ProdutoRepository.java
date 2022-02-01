package br.com.desafiovr.Controller;

import br.com.desafiovr.Domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}
