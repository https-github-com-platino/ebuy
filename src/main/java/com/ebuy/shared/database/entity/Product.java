package com.ebuy.shared.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @Column(name= "name",unique = true)
    private String name;
    private Double price;
    private Integer quantity;
    private String size;
    private String color;

//    @ElementCollection
//    @CollectionTable(name = "image", joinColumns = @JoinColumn(name = "product_id"))
//    @Column(name = "file_name")
//    private Set<String> images = new HashSet<>();

    private String images;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
