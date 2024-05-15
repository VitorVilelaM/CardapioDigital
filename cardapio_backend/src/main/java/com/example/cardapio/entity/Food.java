package com.example.cardapio.entity;

import com.example.cardapio.dto.FoodRequest;
import com.example.cardapio.dto.FoodResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name = "foods")
@Entity(name = "foods")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Integer price;


    public Food(FoodRequest data){
        this.title = data.title();
        this.image = data.image();
        this.price = data.price();
    }
}
