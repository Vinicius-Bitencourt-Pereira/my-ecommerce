package br.com.vinicius.ecommerce.services;

import br.com.vinicius.ecommerce.dto.ProductDTO;
import br.com.vinicius.ecommerce.entities.Product;
import br.com.vinicius.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product entity = repository.findById(id).get();
        return new ProductDTO(entity);
    }

}
