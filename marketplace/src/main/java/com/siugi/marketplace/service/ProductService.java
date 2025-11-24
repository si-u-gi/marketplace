package com.siugi.marketplace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siugi.marketplace.domain.ProductForm;
import com.siugi.marketplace.domain.Products;
import com.siugi.marketplace.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final FileUploadService fileUploadService;

    public ProductService(ProductRepository productRepository, FileUploadService fileUploadService) {
        this.productRepository = productRepository;
        this.fileUploadService = fileUploadService;
    }

    public Long enroll(Products product) {
        productRepository.save(product);
        return product.getProduct_id();
    }

    public List<Products> findAllProducts() {
        return productRepository.findAll();
    }

    public List<Products> findProductsBySellerName(String sellerName) {
        return productRepository.findBySellerName(sellerName);
    }

    @Transactional
    public void create(ProductForm form, String seller) {

        Products p = new Products();

        p.setProduct_name(form.getProductName());
        p.setPrice(form.getPrice());
        p.setShipping_fee(form.getShippingFee());
        p.setSeller_name(seller);
        p.setRating(0);
        p.setReview_count(0);

        // 🔥 업로드 서비스 호출
        String imagePath = fileUploadService.save(form.getImagePath());

        p.setImage_path(imagePath);

        productRepository.save(p);
    }
}
