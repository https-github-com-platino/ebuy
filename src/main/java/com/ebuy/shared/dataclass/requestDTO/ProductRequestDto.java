package com.ebuy.shared.dataclass.requestDTO;

import com.ebuy.shared.database.entity.Category;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @created 14/12/2020 - 8:33 PM
 * @project ebuy
 * @author Nazim Uddin Asif
 */
@Data
public class ProductRequestDto {
    private long id;
    private String name;
    private Double price;
    private Integer quantity;
    private String size;
    private String color;
    private String images;
    private Category category;
}
