package com.fruit.api.v1.mapper;

import com.fruit.api.v1.model.CustomerDTO;
import com.fruit.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping( target = "customerUrl", expression = "java(\"/api/v1/customers/\" + customer.getId())")
    CustomerDTO customerToCustomerDTO(Customer customer);

    @Mapping(target = "id", source = "")
    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
