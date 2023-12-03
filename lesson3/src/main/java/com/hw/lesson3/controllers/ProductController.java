package com.hw.lesson3.controllers;

import com.hw.lesson3.dto.Product;
import com.hw.lesson3.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model){
        model.addAttribute("products", productService.getFullProductList());
        return "fullProductList";
    }

    @GetMapping("/productInfo")
    public String getProductInfo(@RequestParam Integer id, Model model){
        model.addAttribute("product", productService.getOneProduct(id));
        return  "productInfo";
    }

    @GetMapping("/add")
    public String getProductAddForm(){

        return "productForm";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam Integer id,
                             @RequestParam String title,
                             @RequestParam Integer cost
                             ){
        productService.addProductToRepo(new Product(id, title, cost));
        return "redirect:all";
    }
}
