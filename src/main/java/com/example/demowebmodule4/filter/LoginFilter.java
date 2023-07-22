package com.example.demowebmodule4.filter;

import com.example.demowebmodule4.model.Account;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/showCart","/addCart","/store"})
public class LoginFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession httpSession = req.getSession();
        Account account = (Account) httpSession.getAttribute("account");
        if(account != null){
            chain.doFilter(req,res);
        }
        else {
            res.sendRedirect("/login");
        }
    }
}
