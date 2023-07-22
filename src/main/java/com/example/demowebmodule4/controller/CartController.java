package com.example.demowebmodule4.controller;

import com.example.demowebmodule4.model.Invoice;
import com.example.demowebmodule4.model.InvoiceDetail;
import com.example.demowebmodule4.model.Product;
import com.example.demowebmodule4.service.impl.InvoiceDetailServiceImpl;
import com.example.demowebmodule4.service.impl.InvoiceServiceImpl;
import com.example.demowebmodule4.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    InvoiceDetailServiceImpl invoiceDetailService;
    @Autowired
    InvoiceServiceImpl invoiceService;

    @GetMapping("/showCart")
    public String showCart(Model model) {
        List<Product> products = (List<Product>) httpSession.getAttribute("products");
        model.addAttribute("products", products);
        model.addAttribute("total", httpSession.getAttribute("total"));
        return "cart";
    }

    @GetMapping("/addCart")
    public String addCart(@RequestParam int id) {
        Product product = productService.findProduct(id);
        product.setQuantity(1);
        List<Product> products = (List<Product>) httpSession.getAttribute("products");
        if (products == null) {
            products = new ArrayList<>();
        }
        boolean check = false;
        double total = 0;
        for (Product p : products) {
            if (p.getId() == id) {
                check = true;
                p.setQuantity(p.getQuantity() + 1);
            }
            total += (p.getPrice() * p.getQuantity());
        }
        if (!check) {
            products.add(product);
            total += (product.getPrice() * product.getQuantity());
        }
        httpSession.setAttribute("products", products);
        httpSession.setAttribute("total", total);
        return "redirect:/showCart";
    }

    @GetMapping("/invoice")
    public String invoice(Model model) {
        model.addAttribute("invoice", new Invoice());
        return "userForm";
    }

    @PostMapping("/invoice")
    public String invoice(@RequestParam String customer_name, String customer_address, Model model) {
        List<Product> products = (List<Product>) httpSession.getAttribute("products");
        double total = (double) httpSession.getAttribute("total");
        InvoiceDetail invoiceDetail = null;
        Invoice invoice = new Invoice(0, new Date(System.currentTimeMillis()), total, customer_name, customer_address);
        invoiceService.create(invoice);
        for (Product p : products) {
            invoiceDetail = new InvoiceDetail(0, p.getQuantity(), p, invoice);
            invoiceDetailService.create(invoiceDetail);
            Product product = productService.findProduct(p.getId());
            product.setQuantity(product.getQuantity() - p.getQuantity());
            productService.update(product);
        }
        httpSession.setAttribute("products", null);
        model.addAttribute("product", products);
        model.addAttribute("invoice", invoice);
        model.addAttribute("invoiceDetail", invoiceDetail);
        return "invoice";
    }
}
