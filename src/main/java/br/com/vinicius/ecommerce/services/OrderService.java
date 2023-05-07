package br.com.vinicius.ecommerce.services;

import br.com.vinicius.ecommerce.dto.OrderDTO;
import br.com.vinicius.ecommerce.dto.OrderItemDTO;
import br.com.vinicius.ecommerce.entities.Order;
import br.com.vinicius.ecommerce.entities.OrderItem;
import br.com.vinicius.ecommerce.entities.OrderStatus;
import br.com.vinicius.ecommerce.entities.Product;
import br.com.vinicius.ecommerce.repositories.OrderItemRepository;
import br.com.vinicius.ecommerce.repositories.OrderRepository;
import br.com.vinicius.ecommerce.repositories.ProductRepository;
import br.com.vinicius.ecommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(entity);
    }

    @Transactional(readOnly = true)
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        order.setClient(userService.authenticated());
        for (OrderItemDTO itemDto : dto.getItems()){
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
            order.getItems().add(item);
        }
        repository.save(order);
        orderItemRepository.saveAll(order.getItems());
        return new OrderDTO(order);
    }
}
