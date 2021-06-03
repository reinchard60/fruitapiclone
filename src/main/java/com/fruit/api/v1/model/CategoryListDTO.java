package com.fruit.api.v1.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@ApiModel(value = "categories")
public class CategoryListDTO {
    @ApiModelProperty(required = true)
    private List<CategoryDTO> categories;
}
