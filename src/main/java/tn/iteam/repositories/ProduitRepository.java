package tn.iteam.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iteam.entities.Produit;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    Page<Produit> findByDesignationContains(String keyword, Pageable pageable);
}
