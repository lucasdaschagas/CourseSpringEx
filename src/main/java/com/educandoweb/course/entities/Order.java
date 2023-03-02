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
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_orders")
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
    private Set<OrderItem> items = new HashSet<>();
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;
    private Integer orderStatus;

   public Order(Long id, Instant moment, OrderStatus orderStatus, User client, Payment payment)
   {    super();
       this.id = id;
       this.moment = moment;
       setOrderStatus(orderStatus);
       this.client = client;
       this.payment = payment;

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
        return items;
    }

    public Instant getMoment() {
        return moment;
    }


    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }
    public Double getTotal(){
       double sum = 0.0;
        for (OrderItem x : items) {
            sum += x.getSubTotal();
        }
        return  sum;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
