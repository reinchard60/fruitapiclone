package com.fruit.api.v1.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "vendors")
public class VendorListDTO {
    @ApiModelProperty(required = true)
    private List<VendorDTO> vendors;
}
