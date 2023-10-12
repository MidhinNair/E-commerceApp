package dev.midhin.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private  String image;
    private double price;
//    P:C
//    1:1 => L to R
//    M:1 => R to L
//    M:1 => ans
    @ManyToOne
    private Category category;

}
