package com.ebuy.shared.database.entity;
import lombok.EqualsAndHashCode;
import lombok.Data;
import javax.persistence.*;
import java.util.List;
/**
 * @created 11/12/2020 - 6:34 PM
 * @project ebuy
 * @author Nazim Uddin Asif
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Category extends BaseEntity{
    private String name;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> product;
}
