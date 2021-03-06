package com.fruit.api.v1.mapper;

import com.fruit.api.v1.model.CustomerDTO;
import com.fruit.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    String BASE_URL = "/api/v1/customers/";
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "customerUrl", expression = "java(BASE_URL + customer.getId())")
    CustomerDTO customerToCustomerDTO(Customer customer);

    @Mapping(target = "id", source = "")
    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
