package com.siugi.marketplace.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.siugi.marketplace.domain.ProductForm;

@SpringBootTest
@Transactional
class ProductServiceTest {
	@Autowired ProductService productService;

    @Test
    void 상품등록() {
        ProductForm productForm = new ProductForm();
		productForm.setProductName("test1");
		productForm.setPrice(1000);
		productForm.setShippingFee(0);
		productForm.setImagePath(null);

		productService.create(productForm, "test");
    }
}
