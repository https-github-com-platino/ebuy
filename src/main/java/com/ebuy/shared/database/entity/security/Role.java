package com.ebuy.shared.database.entity.security;

import com.ebuy.shared.database.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Abdur Rahim Nishad
 * @created 22/12/2020 - 5:47 PM
 * @project Ebuy
 */
@Entity
@Data
@Table(name = "role")
public class Role extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();
}
