package com.fruit.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "CustomerEntry")
public class CustomerDTO {

    @ApiModelProperty(required = true, position = 1)
    @JsonProperty("firstname")
    private String firstName;
    @ApiModelProperty(required = true, position = 2)
    @JsonProperty("lastname")
    private String lastName;
    @ApiModelProperty(position = 3)
    @JsonProperty("customer_url")
    private String customerUrl;
}
