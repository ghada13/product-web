package tn.iteam.web;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tn.iteam.entities.Produit;
import tn.iteam.repositories.ProduitRepository;

import java.util.List;

@Controller
public class ProduitController {


    private final ProduitRepository produitRepository;

    public ProduitController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    // http://localhost:8090/index
    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page ,
                        @RequestParam(name = "size", defaultValue = "5")int size,
                        @RequestParam(name = "keyword", defaultValue = "")String keyword){

        Page<Produit> pageProducts = produitRepository.findByDesignationContains(keyword,PageRequest.of(page, size));
        List<Produit> produitList = pageProducts.getContent();
        model.addAttribute("dataProduits", produitList);
        model.addAttribute("pages", new int[pageProducts.getTotalPages()]);
        return "produits";
    }
}