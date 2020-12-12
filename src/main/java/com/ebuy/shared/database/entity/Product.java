package com.ebuy.shared.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @created 11/12/2020 - 6:33 PM
 * @project ebuy
 * @author Nazim Uddin Asif
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity{
    private String name;
    private Double price;
    private Integer quantity;
    private String size;
    private Double weight;
    private String color;

//    @ElementCollection
//    @CollectionTable(name = "image", joinColumns = @JoinColumn(name = "product_id"))
//    @Column(name = "file_name")
//    private Set<String> images = new HashSet<>();
    private String images;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY
//            cascade = {
//                    CascadeType.MERGE,
//                    CascadeType.DETACH,
//                    CascadeType.REFRESH}
                    )
//    @JoinColumn(name = "category_id")
    
    private Category category;

}
