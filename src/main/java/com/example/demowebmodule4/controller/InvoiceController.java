package com.example.demowebmodule4.controller;

import com.example.demowebmodule4.model.Invoice;
import com.example.demowebmodule4.model.Product;
import com.example.demowebmodule4.service.impl.InvoiceDetailServiceImpl;
import com.example.demowebmodule4.service.impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class InvoiceController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    InvoiceServiceImpl invoiceService;
    @Autowired
    InvoiceDetailServiceImpl invoiceDetailService;
//    @GetMapping("/invoice")
//    public String showInvoice(Model model){
//        model.addAttribute("invoice",new Invoice());
//        return "/invoice";
//    }
}
