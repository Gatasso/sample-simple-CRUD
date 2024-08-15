package com.example.crud.domain.model;

import com.example.crud.domain.response.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "product")
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    //TODO: alterar na migration e tentar usar BigDecimal
    private Integer price;

    private Boolean isActive;

    public Product(ProductDTO data) {
        this.name = data.name();
        this.price = data.price();
        isActive = true;
    }
}
