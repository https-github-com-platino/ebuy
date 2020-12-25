package com.ebuy.shared.database.entity.security;

import com.ebuy.shared.database.entity.BaseEntity;
import com.ebuy.shared.database.entity.User;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Abdur Rahim Nishad
 * @created 22/12/2020 - 5:20 PM
 * @project Ebuy
 */
@Entity
public class PasswordResetToken extends BaseEntity {
    private static final int EXPIRATION = 60 * 24;

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private Date expiryDate;

    public PasswordResetToken() {
    }

    public PasswordResetToken(final String token, final User user) {
        super();
        this.token = token;
        this.user = user;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    private Date calculateExpiryDate(final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    public void updateToken(final String token) {
        this.token = token;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }
}
