package com.educandoweb.course.entities;

import com.educandoweb.course.entities.pk.OrderItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity(name = "orderItem" )
@Table(name = "tb_order_item")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class OrderItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();
    private Integer quantity;
    private Double price;

    public OrderItem(Order order, Product product,Integer quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
        id.setOrder(order);
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }
    public void setOrder(Order order){
        id.setOrder(order);
    }
    public Product getProduct(){
        return id.getProduct();
    }
    public void setProduct(Product product){
        id.setProduct(product);
    }

}
