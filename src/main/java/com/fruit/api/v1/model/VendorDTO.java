package com.fruit.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "VendorEntry")
public class VendorDTO {
    @ApiModelProperty(position = 1, required = true, value = "Name of the vendor")
    private String name;
    @ApiModelProperty(position = 2)
    @JsonProperty("vendor_url")
    private String vendorUrl;
}
