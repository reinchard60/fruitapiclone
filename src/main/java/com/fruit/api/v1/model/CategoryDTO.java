package com.fruit.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "CategoryEntry")
public class CategoryDTO {

    @ApiModelProperty(hidden = true)
    private Long id;
    @ApiModelProperty(required = true, position = 1)
    private String name;
    @ApiModelProperty(position = 2)
    @JsonProperty("category_url")
    private String categoryUrl;
}
