package com.siugi.marketplace;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SellerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void 상품목록_페이지_접근() throws Exception {
        mockMvc.perform(get("/seller/products")
                .sessionAttr("bbbbb", "bbbbb"))
                .andExpect(status().isOk())
                .andExpect(view().name("seller/products"))
                .andExpect(model().attributeExists("products"));
    }
}
