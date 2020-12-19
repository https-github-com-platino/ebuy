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
    @NotBlank(message = "Title is mandatory")
    @Column(name= "title",unique = true)
    private String name;

    @NotNull(message = "price must not be empty")
    private Double price;
    @NotNull(message = "quantity must not be empty")
    private Integer quantity;
    @NotBlank(message = "size must not be empty")
    private String size;
    @NotBlank(message = "color must not be empty")
    private String color;

//    @ElementCollection
//    @CollectionTable(name = "image", joinColumns = @JoinColumn(name = "product_id"))
//    @Column(name = "file_name")
//    private Set<String> images = new HashSet<>();

    private String images;

    @NotBlank(message = "category must not be empty")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
