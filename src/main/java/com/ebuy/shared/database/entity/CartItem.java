package com.ebuy.shared.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Abdur Rahim Nishad
 * @created 22/12/2020 - 11:19 AM
 * @project Ebuy
 */
public class CartItem extends BaseEntity{
    private int qty;
    private BigDecimal subtotal;

    @OneToOne
    private Product product;

    @OneToMany(mappedBy = "cartItem")
    @JsonIgnore
    private List<ProductToCardItem> bookToCartItemList;
//
//    @ManyToOne
//    @JoinColumn(name="shopping_cart_id")
//    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;
}
