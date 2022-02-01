package br.com.desafiovr.Controller;

import br.com.desafiovr.Domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;



@ComponentScan(basePackages = "br.com.desafiovr.Domain")
@RestController
@RequestMapping(path = "/cadastro")
public class Controller {

    @Autowired
    ProdutoRepository rp;

    @PostMapping(value="/salvar")
    public Produto gravar(@RequestBody Produto novoProd){
        rp.save(novoProd);
        return novoProd;
    }

    @GetMapping(value="buscar/{id}")
    public ResponseEntity<Produto> getById(@PathVariable long id) {
        Optional<Produto> pr = rp.findById(id);
        if (pr.isPresent()) {
            return new ResponseEntity<>(pr.get(), HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(pr.get(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/apagar/item/{id}")
    public void apagarItem(@PathVariable Long id){
       Produto pr = new Produto();
       rp.deleteById(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Produto> updateUser(@PathVariable(value = "id") Long Id,
            @Validated @RequestBody Produto produto) throws ResourceNotFoundException {
        Produto prod = rp.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto Não encontrado:: "+ produto));

              final Produto updatedProd = rp.save(prod);
        return ResponseEntity.ok(updatedProd);
    }
}
