package com.operations.ratnaCrud.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@NamedQuery(name = "Customer.findAll", query = "SELECT a FROM Customer a")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name="customer_id")
    private Long id;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="contact_name")
    private String contactName;

    @Column(name="customer_address")
    private String address;

    @Column(name="customer_city")
    private String city;

    @Column(name="customer_postalCode")
    private int postalCode;

    @Column(name="customer_country")
    private String country;

}
