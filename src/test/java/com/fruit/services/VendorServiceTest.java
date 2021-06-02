package com.fruit.services;

import com.fruit.api.v1.mapper.VendorMapper;
import com.fruit.api.v1.model.VendorDTO;
import com.fruit.api.v1.model.VendorListDTO;
import com.fruit.domain.Vendor;
import com.fruit.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class VendorServiceTest {

    public static final long ID = 1L;
    public static final String VENDOR_NAME = "Home Fruits";
    public static final String VENDOR_URL = "/api/v1/vendors/1";
    VendorService vendorService;

    @Mock
    VendorRepository vendorRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        vendorService = new VendorServiceImpl(VendorMapper.INSTANCE, vendorRepository);
    }

    @Test
    public void getAllVendors() {
        //given
        List<Vendor> vendors = Arrays.asList(new Vendor(), new Vendor());
        given(vendorRepository.findAll()).willReturn(vendors);

        //when
        VendorListDTO vendorListDTO = vendorService.getAllVendors();

        //then
        then(vendorRepository).should(times(1)).findAll();
        assertThat(vendorListDTO.getVendors().size(), is(equalTo(2)));
    }

    @Test
    public void getVendorById() {
        //given
        Vendor vendor = getVendor1();

        given(vendorRepository.findById(anyLong())).willReturn(Optional.of(vendor));

        //when
        VendorDTO vendorDTO = vendorService.getVendorById(ID);

        //then
        then(vendorRepository).should(times(1)).findById(anyLong());
        assertThat(vendorDTO.getName(), is(equalTo(VENDOR_NAME)));
        assertThat(vendorDTO.getVendorUrl(), is(equalTo(VENDOR_URL)));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getVendorByIdNotFound() throws Exception {
        //given
        given(vendorRepository.findById(anyLong())).willReturn(Optional.empty());

        //when
        VendorDTO vendorDTO = vendorService.getVendorById(ID);

        //then
        then(vendorRepository).should(times(1)).findById(anyLong());
    }

    @Test
    public void createNewVendor() {
        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(VENDOR_NAME);

        Vendor savedVendor = getVendor1();

        given(vendorRepository.save(any(Vendor.class))).willReturn(savedVendor);

        //when
        VendorDTO savedDTO = vendorService.createNewVendor(vendorDTO);

        //then
        then(vendorRepository).should().save(any(Vendor.class));
        assertThat(savedDTO.getName(), is(equalTo(vendorDTO.getName())));
        assertThat(savedDTO.getVendorUrl(), is(equalTo(VENDOR_URL)));
    }

    @Test
    public void updateVendor() {
        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(VENDOR_NAME);

        Vendor savedVendor = getVendor1();

        given(vendorRepository.save(any(Vendor.class))).willReturn(savedVendor);

        //when
        VendorDTO savedDTO = vendorService.updateVendor(ID, vendorDTO);

        //then
        then(vendorRepository).should().save(any(Vendor.class));
        assertThat(savedDTO.getName(), is(equalTo(vendorDTO.getName())));
        assertThat(savedDTO.getVendorUrl(), is(equalTo(VENDOR_URL)));
    }

    @Test
    public void patchVendor() {
        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(VENDOR_NAME);

        Vendor savedVendor = getVendor1();

        given(vendorRepository.save(any(Vendor.class))).willReturn(savedVendor);

        //when
        VendorDTO savedDTO = vendorService.updateVendor(ID, vendorDTO);

        //then
        then(vendorRepository).should().save(any(Vendor.class));
        assertThat(savedDTO.getName(), is(equalTo(vendorDTO.getName())));
        assertThat(savedDTO.getVendorUrl(), is(equalTo(VENDOR_URL)));
    }

    @Test
    public void deleteVendorById() {
        vendorRepository.deleteById(ID);

        verify(vendorRepository, times(1)).deleteById(anyLong());
    }

    private Vendor getVendor1() {
        return new Vendor(ID,VENDOR_NAME);
    }
}