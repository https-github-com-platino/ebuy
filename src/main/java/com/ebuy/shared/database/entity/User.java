package com.ebuy.shared.database.entity;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @created 11/12/2020 - 6:36 PM
 * @project ebuy
 * @author Abdur Rahim Nishad
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "tbl_user")
public class User extends BaseEntity{
}
