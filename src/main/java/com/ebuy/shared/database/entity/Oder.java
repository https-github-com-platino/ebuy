package com.ebuy.shared.database.entity;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @created 11/12/2020 - 6:40 PM
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
@Table(name = "oder")
public class Oder extends BaseEntity{
}
