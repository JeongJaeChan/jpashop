package jpabook.jpashop.repository.order.simplequery;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderSimpleQueryDto {

    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderSataus;
    private Address adress;

    public OrderSimpleQueryDto(Long orderId, String name, LocalDateTime orderDate, OrderStatus orderSataus, Address adress) {
        this.orderId = orderId;
        this.name = name;
        this.orderDate = orderDate;
        this.orderSataus = orderSataus;
        this.adress = adress;
    }
}
