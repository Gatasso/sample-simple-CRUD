package com.example.crud.controller;

import com.example.crud.domain.model.Product;
import com.example.crud.domain.repository.ProductRepository;
import com.example.crud.domain.response.ProductDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    public ResponseEntity<Product> createNewProduct(@RequestBody @Valid ProductDTO data){
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.status(201).build();
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        var allProducts = repository.findAllByIsActiveTrue();
        return ResponseEntity.ok(allProducts);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody @Valid ProductDTO newData){
        Optional<Product> product= repository.findById(newData.id());
        if (product.isPresent()){
            Product updatedProduct = product.get();
            updatedProduct.setName(newData.name());
            updatedProduct.setPrice(newData.price());

            this.repository.save(updatedProduct);
            return ResponseEntity.ok(updatedProduct);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Integer> deleteProduct(@PathVariable String id){
        Optional<Product> product= repository.findById(id);
        if(product.isPresent()){
            Product productToDelete = product.get();
            productToDelete.setIsActive(false);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
