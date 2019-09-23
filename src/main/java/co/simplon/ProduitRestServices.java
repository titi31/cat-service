package co.simplon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitRestServices {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping(value="/listProduits")
    public List<Produit> listProduits(){
        return productRepository.findAll();
    }
    @GetMapping(value="/listProduits/{id}")
    public Produit listProduits(@PathVariable(name="id") Long id){
        return productRepository.findById(id).get();
    }
    @PutMapping(value="/listProduits/{id}")
    public Produit update(@PathVariable(name="id") Long id, @RequestBody Produit p){
       p.setId(id);
        return productRepository.save(p);
    }
    @PostMapping(value="/listProduits/{id}")
    public Produit save(@RequestBody Produit p){
        return productRepository.save(p);
    }
    @DeleteMapping(value="/listProduits/{id}")
    public void delete(@PathVariable(name="id") Long id){
        productRepository.deleteById(id);
    }
}
