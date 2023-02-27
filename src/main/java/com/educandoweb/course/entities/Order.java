package com.educandoweb.course.entities;

import com.educandoweb.course.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity(name = "orders")
@Table(name = "tb_order")
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 'T' HH:mm:ss 'Z'" , timezone = "GMT")
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "client_id") //Foreign key
    private User client;


    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> item = new HashSet<>();
    private Integer orderStatus;

   public Order(Long id, Instant moment, OrderStatus orderStatus, User client)
   {
       this.id = id;
       this.moment = moment;
       this.client = client;
      setOrderStatus(orderStatus);
   }

   public OrderStatus getOrderStatus(){
       return OrderStatus.valueOf(orderStatus);
   }
   public void setOrderStatus(OrderStatus orderStatus) {
       if (orderStatus != null) {
           this.orderStatus = orderStatus.getCode();
       }
   }

    public Set<OrderItem> getItem() {
        return item;
    }

}
