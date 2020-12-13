package com.ebuy.shared.database.entity;

import lombok.*;
import javax.persistence.*;
/**
 * @created 11/12/2020 - 6:33 PM
 * @project ebuy
 * @author Nazim Uddin Asif
 * @author Abdur Rahim Nishad
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
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

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

}
