package com.ebuy.shared.dataclass.responseDTO;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private long id;
    private String name;
    private double price;
    private int quantity;
    private double size;
    private String color;
    private String images;
    private long category;
}
