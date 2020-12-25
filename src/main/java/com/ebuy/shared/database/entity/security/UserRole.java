package com.ebuy.shared.database.entity.security;

import com.ebuy.shared.database.entity.BaseEntity;
import com.ebuy.shared.database.entity.User;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Abdur Rahim Nishad
 * @created 22/12/2020 - 5:40 PM
 * @project Ebuy
 */
@Entity
@Data
@Table(name="user_role")
public class UserRole extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id")
    private Role role;

    public UserRole(){}

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }
}
