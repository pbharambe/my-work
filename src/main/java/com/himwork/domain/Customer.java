package com.himwork.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer{

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="age")
    private Integer age;
    @Column(name="phone_number")
    private String phoneNumber;

    public Customer() {
    }
    public Customer(String name, Integer age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
}
