package com.siugi.marketplace.domain;

public class CartItem {
    private Long id;
    private Long cart_id;
    private Long product_id;
    private int count;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getCart_id() {
        return cart_id;
    }
    public void setCart_id(Long cart_id) {
        this.cart_id = cart_id;
    }

    public Long getProduct_id() {
        return product_id;
    }
    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
    
    public int getcount() {
        return count;
    }
    public void setcount(int count) {
        this.count = count;
    }
}
