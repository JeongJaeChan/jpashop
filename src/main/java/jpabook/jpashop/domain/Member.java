package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue //Generated -> 시퀀스값같은거
    @Column(name = "member_id") //없으면 컬럼이 그냥 id가 되버림
    private Long id;

    @NotEmpty
    private String name;

    @Embedded //내장타입
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "member") // 한명의 멤버가 여러개의 주문 가능, mappedBy는 읽기전용 값을넣어도 값이 변경되지 않음
    private List<Order> orders = new ArrayList<>();


}
