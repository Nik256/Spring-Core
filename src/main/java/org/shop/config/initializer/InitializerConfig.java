package org.shop.config.initializer;

import org.shop.*;
import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.shop.common.Sellers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class InitializerConfig {

    @Bean
    public Map<Long, String> sellerMap() {
        Map<Long, String> sellerMap = new HashMap<>();
        sellerMap.put(1L, Sellers.AMAZON);
        sellerMap.put(2L, Sellers.SAMSUNG);
        return sellerMap;
    }

    @Bean
    public SellerInitializer sellerInitializer(Map<Long, String> sellerMap) {
        return new SellerInitializer(sellerMap);
    }

    @Bean
    public ProposalInitializer proposalInitializer() {
        return new ProposalInitializer();
    }

    @Bean
    public UserInitializer userInitializer(UserService userService) {
        return new UserInitializer(userService);
    }

    @Bean
    public ProductInitializer productInitializer(ProductService productService) {
        return new ProductInitializer(productService);
    }

    @Bean(initMethod = "initData")
    public DataInitializer dataInitializer() {
        return new DataInitializer();
    }
}
