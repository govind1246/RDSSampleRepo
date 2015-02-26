package com.codetutr.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codetutr.bo.Customer;
@Controller
public class InsertCustomerServlet {
     
    @RequestMapping(value="/insertCustomer")
    public String insertCustomer(HttpServletRequest request, Model model) {
        Customer customer=new Customer();
        customer.setName(request.getParameter("name"));
        customer.setAddress(request.getParameter("address"));
        customer.setMobile(Long.valueOf(request.getParameter("mobile")));
        customer.setEmailid(request.getParameter("emailid"));
        model.addAttribute("cust", customer);
        return "welcome";
    }
 
}