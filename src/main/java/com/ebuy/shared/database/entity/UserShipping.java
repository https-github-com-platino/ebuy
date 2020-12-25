package com.ebuy.shared.database.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author user
 * @created 22/12/2020 - 11:11 AM
 * @project demo
 */
@Entity
public class UserShipping extends BaseEntity {
    private String userShippingName;
    private String userShippingStreet1;
    private String userShippingStreet2;
    private String userShippingCity;
    private String userShippingState;
    private String userShippingCountry;
    private String userShippingZipcode;
    private boolean userShippingDefault;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
