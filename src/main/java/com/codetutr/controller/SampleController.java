package com.codetutr.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codetutr.bo.Customer;
import com.codetutr.dao.CustomerJDBCTemplate;

@Controller
public class SampleController {

    @RequestMapping("home")
    public String loadHomePage(Model m) {
        m.addAttribute("name", "CodeTutr");
        return "home";
    }

    @RequestMapping("customer")
    public String loadCustomerPage(Model m) {
        return "customer";
    }

    
    /**
     * curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/time -d '{"name":"govind","id":2,"address":"my home","mobile":980878,"emailid":"govind.nsit07@gmail.com"}'
     */
    @RequestMapping(value = "time", method = RequestMethod.POST)
    @ResponseBody
    public Customer create(@RequestBody  Customer customer) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerJDBCTemplate jdbcTemplate = (CustomerJDBCTemplate)applicationContext.getBean("customerJDBCTemplate");
        jdbcTemplate.create(customer);
        Customer customer2 = jdbcTemplate.getCustomer(customer.getId());
        return customer2;
    }
}
