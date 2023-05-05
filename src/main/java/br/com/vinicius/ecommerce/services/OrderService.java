package br.com.vinicius.ecommerce.services;

import br.com.vinicius.ecommerce.dto.OrderDTO;
import br.com.vinicius.ecommerce.entities.Order;
import br.com.vinicius.ecommerce.repositories.OrderRepository;
import br.com.vinicius.ecommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(entity);
    }
}
