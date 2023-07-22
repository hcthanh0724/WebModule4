package com.example.demowebmodule4.controller;

import com.example.demowebmodule4.model.Account;
import com.example.demowebmodule4.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SignInController {
    @Autowired
    AccountServiceImpl accountService;
    @Autowired
    HttpSession httpSession;
    @GetMapping("/login")
    public String getLogin(){
        return "SignIn";
    }
    @PostMapping("/login")
    public String getLogin(@RequestParam String username, @RequestParam String password){
        Account account = accountService.login(username,password);
        if(account == null){
            return "SignIn";
        }
        else {
            httpSession.setAttribute("account",account);
            return "redirect:/store";
        }
    }
}
