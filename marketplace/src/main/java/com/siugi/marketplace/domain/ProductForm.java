package com.siugi.marketplace.domain;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
    private String productName;
    private int price;
    private int shippingFee;
    private MultipartFile imagePath; 

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(int shippingFee) {
        this.shippingFee = shippingFee;
    }

    public MultipartFile getImagePath() {
        return imagePath;
    }

    public void setImagePath(MultipartFile imagePath) {
        this.imagePath = imagePath;
    }
}
