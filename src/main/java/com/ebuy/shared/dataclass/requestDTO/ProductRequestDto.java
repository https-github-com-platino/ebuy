package com.ebuy.shared.dataclass.requestDTO;

import com.ebuy.shared.database.entity.Category;
import lombok.Data;
import org.springframework.stereotype.Component;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @created 14/12/2020 - 8:33 PM
 * @project ebuy
 * @author Nazim Uddin Asif
 */
@Data
public class ProductRequestDto {
    private long id;
    @NotBlank(message = "Title is mandatory")
    private String name;
    @NotNull(message = "price must not be empty")
    private Double price;
    @NotNull(message = "quantity must not be empty")
    private Integer quantity;
    @NotBlank(message = "size must not be empty")
    private String size;
    @NotNull(message = "color must not be empty")
    private String color;
    private String images;
//    @NotNull(message= "category must not be empty")
    private CategoryRequestDto category;
}
