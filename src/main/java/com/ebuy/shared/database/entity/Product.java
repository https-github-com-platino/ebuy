package com.ebuy.shared.database.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @created 11/12/2020 - 6:33 PM
 * @project ebuy
 * @author Nazim Uddin Asif
 */

@Entity
@Data
public class Product extends BaseEntity{
    private String name;
    private double price;
    private int quantity;
    private double size;
    private String color;

//    @ElementCollection
//    @CollectionTable(name = "image", joinColumns = @JoinColumn(name = "product_id"))
//    @Column(name = "file_name")
//    private Set<String> images = new HashSet<>();
    private String images;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;
}
