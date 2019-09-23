package co.simplon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;


@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    
    public static void main(String[] args) {
        SpringApplication.run(CatServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Produit.class);
        productRepository.save(new Produit(null,"macboook pro",1200,5));
        productRepository.save(new Produit(null,"pc hp",300,3));
        productRepository.save(new Produit(null,"parfum",40,6));
        productRepository.findAll().forEach(p->{
            System.out.println(p.toString());
        });

    }
}
