package com.operations.ratnaCrud.Dto;

import lombok.Data;

@Data
public class CustomerResponseDto {


    private Long id;


    private String customerName;


    private String contactName;


    private String address;


    private String city;


    private int postalCode;


    private String country;
}
