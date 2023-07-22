package com.example.demowebmodule4.controller;

import com.example.demowebmodule4.model.Product;
import com.example.demowebmodule4.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductServiceImpl productService;
    @ModelAttribute("store")
    public List<Product> products(){
        return productService.showAll();
    }
    @GetMapping("/store")
    public String showAll(Model model){
        return "store";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam int id, Model model){
        model.addAttribute("product",productService.findProduct(id));
        return "detail";
    }

}
