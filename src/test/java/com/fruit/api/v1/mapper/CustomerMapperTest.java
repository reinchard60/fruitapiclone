package com.fruit.api.v1.mapper;

import com.fruit.api.v1.model.CustomerDTO;
import com.fruit.domain.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerMapperTest {

    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Doe";
    private static final Long ID = 1L;
    private static final String BASE_URL = "/api/v1/customers/";
    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() {

        //given
        Customer customer = new Customer(ID, FIRST_NAME, LAST_NAME);

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        assertEquals(FIRST_NAME, customerDTO.getFirstName());
        assertEquals(LAST_NAME, customerDTO.getLastName());
        assertEquals(BASE_URL + ID, customerDTO.getCustomerUrl());

    }
}