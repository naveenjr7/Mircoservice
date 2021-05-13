package com.learn.mircroservice.product.controller;

import com.learn.mircroservice.product.Model.Coupon;
import com.learn.mircroservice.product.Model.Product;
import com.learn.mircroservice.product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @Value("${spring.couponurl}")
    String couponUrl;

    @PostMapping("/products")
    public Product save(@RequestBody Product product) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("couponurl " + couponUrl);
        Coupon coupon = restTemplate.getForObject(couponUrl + product.getCoupon(), Coupon.class);
        product.setPrice(product.getPrice() - coupon.getDiscount());
        return productService.save(product);
    }

    @GetMapping("/getProduct/{name}")
    public Product getProduct(@PathVariable String name) {
        return productService.get(name);
    }
}
