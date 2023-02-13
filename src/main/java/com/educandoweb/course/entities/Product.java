package com.educandoweb.course.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.HashSet;
import java.util.Set;
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "product")
@Table(name = "tb_products")
public class Product {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String description;
    private Double price;
    private String imgUrl;
    @Transient
    private Set<Category> categories = new HashSet<>();


    public Product(Long id, String nome, String description, Double price, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
