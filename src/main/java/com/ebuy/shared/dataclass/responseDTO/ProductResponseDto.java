package com.ebuy.shared.dataclass.responseDTO;

import com.ebuy.shared.database.entity.Category;
import com.ebuy.shared.dataclass.requestDTO.CategoryRequestDto;
import lombok.Data;

/**
 * @created 14/12/2020 - 10:36 PM
 * @project ebuy
 * @author Nazim Uddin Asif
 */

@Data
public class ProductResponseDto {
    private long id;
    private String name;
    private Double price;
    private Integer quantity;
    private String size;
    private String color;
    private String images;
    private CategoryResponseDto category;
}
