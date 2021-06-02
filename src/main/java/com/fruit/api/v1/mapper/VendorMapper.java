package com.fruit.api.v1.mapper;

import com.fruit.api.v1.model.VendorDTO;
import com.fruit.domain.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendorMapper {

    String BASE_URL = "/api/v1/vendors/";
    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    @Mapping(target = "vendorUrl", expression = "java(BASE_URL + vendor.getId())")
    VendorDTO vendorToVendorDTO(Vendor vendor);

    @Mapping(target = "id", source = "")
    Vendor vendorDTOToVendor(VendorDTO vendorDTO);
}
