package com.ebuy.shared.dataclass.requestDTO;

import com.ebuy.shared.database.entity.Category;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class ProductRequestDto {
    private long id;
    private String name;
    private double price;
    private int quantity;
    private double size;
    private String color;
    private String images;
    private long category;

}
