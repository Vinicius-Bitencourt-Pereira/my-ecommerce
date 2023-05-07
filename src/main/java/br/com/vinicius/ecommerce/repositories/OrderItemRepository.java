package br.com.vinicius.ecommerce.repositories;

import br.com.vinicius.ecommerce.entities.OrderItem;
import br.com.vinicius.ecommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
