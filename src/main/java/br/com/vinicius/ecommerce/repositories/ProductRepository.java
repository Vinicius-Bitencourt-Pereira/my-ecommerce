package br.com.vinicius.ecommerce.repositories;

import br.com.vinicius.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
