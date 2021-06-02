package com.fruit.services;

import com.fruit.api.v1.model.VendorDTO;
import com.fruit.api.v1.model.VendorListDTO;

public interface VendorService {
    VendorListDTO getAllVendors();

    VendorDTO getVendorById(Long id);

    VendorDTO createNewVendor(VendorDTO vendorDTO);

    VendorDTO updateVendor(Long id, VendorDTO vendorDTO);

    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

    void deleteVendorById(Long id);
}
