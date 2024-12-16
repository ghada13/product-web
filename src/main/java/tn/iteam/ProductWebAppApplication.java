package tn.iteam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.iteam.entities.Produit;
import tn.iteam.repositories.ProduitRepository;

import java.time.LocalDate;

@SpringBootApplication

public class ProductWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductWebAppApplication.class, args);
    }

    //begin init method
    @Bean
    CommandLineRunner init(ProduitRepository produitRepository) {
        return args -> {
            //using default constructor
            Produit p1 = new Produit();
            p1.setDesignation("Imprimente Lazer");
            p1.setPrix(3000);
            p1.setQuantite(15);
            p1.setDisponible(true);
            p1.setDateCreation(LocalDate.now());
            produitRepository.save(p1);

            //using with params constructor
            Produit p2 = new Produit(null, "Ordinateur ", 5000, 12, true, LocalDate.now());
            produitRepository.save(p2);
        };
    }
    //end init main
}
