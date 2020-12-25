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
@Getter
@Setter
@Table(name = "order")
public class Order extends BaseEntity{
}
