package com.siugi.marketplace;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.siugi.marketplace.domain.ProductForm;
import com.siugi.marketplace.service.ProductService;

@SpringBootTest
class MarketplaceApplicationTests {

	@Test
	void contextLoads() {
		ProductForm productForm = new ProductForm();
		productForm.setProductName("test1");
		productForm.setPrice(1000);
		productForm.setShippingFee(0);
		productForm.setImagePath(null);

		ProductService productService = new ProductService(null, null);
		
	}
}
