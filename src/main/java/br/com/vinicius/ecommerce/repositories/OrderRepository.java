package br.com.vinicius.ecommerce.repositories;

import br.com.vinicius.ecommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
