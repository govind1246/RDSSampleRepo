package com.codetutr.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codetutr.bo.Customer;
import com.codetutr.dao.CustomerJDBCTemplate;
@Controller
public class InsertCustomerServlet {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    CustomerJDBCTemplate jdbcTemplate = (CustomerJDBCTemplate)applicationContext.getBean("customerJDBCTemplate");

    @RequestMapping(value="/insertCustomer")
    public String insertCustomer(HttpServletRequest request, Model model) {
        Customer customer=new Customer();
        customer.setName(request.getParameter("name"));
        customer.setAddress(request.getParameter("address"));
        customer.setMobile(Long.valueOf(request.getParameter("mobile")));
        customer.setEmailid(request.getParameter("emailid"));
        Random randomGenerator = new Random();
        customer.setId(randomGenerator.nextInt(2000000));
        jdbcTemplate.create(customer);
        model.addAttribute("cust", jdbcTemplate.getCustomer(customer.getId()));
        return "welcome";
    }
 
}