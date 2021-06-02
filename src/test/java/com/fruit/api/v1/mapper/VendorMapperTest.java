package com.fruit.api.v1.mapper;

import com.fruit.api.v1.model.VendorDTO;
import com.fruit.domain.Vendor;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendorMapperTest {

    VendorMapper vendorMapper = VendorMapper.INSTANCE;

    @Test
    public void vendorToVendorDTO() {
        //given
        Vendor vendor = new Vendor(1L, "Home Fruits");

        //when
        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);

        //then
        assertEquals("Home Fruits", vendorDTO.getName());
        assertEquals("/api/v1/vendors/1", vendorDTO.getVendorUrl());

    }

    @Test
    public void vendorDTOToVendor() {

        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName("Exotic Fruits Company");

        //when
        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);

        //then
        assertEquals("Exotic Fruits Company", vendor.getName());
    }
}