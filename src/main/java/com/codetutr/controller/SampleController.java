package com.codetutr.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codetutr.bo.Customer;
import com.codetutr.dao.CustomerJDBCTemplate;

@Controller
public class SampleController {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    CustomerJDBCTemplate jdbcTemplate = (CustomerJDBCTemplate)applicationContext.getBean("customerJDBCTemplate");
    private static Logger logger = LogManager.getLogger(SampleController.class);
    @RequestMapping("home")
    public String loadHomePage(Model m) {
        m.addAttribute("name", "CodeTutr");
        return "home";
    }

    @RequestMapping("customerview")
    public String loadCustomerPage(Model m) {
    	logger.debug("In customerview");
        return "customer";
    }

    @RequestMapping("registration")
    public String registration(Model m) {
        return "registration";
    }
    
    /*
     * curl http://localhost:8080/modify/1
     * */
    @RequestMapping(value = "modify")
    public String modify(Model m, @RequestParam(value="id", required=false) Integer id) {
        Customer customer = jdbcTemplate.getCustomer(id);
        m.addAttribute("modifyCustomer", customer);
        return "modify";
    }
    
    @RequestMapping("customers")
    public String getAllCustomersWithUI(Model m) {
        return "customers";
    }

    
    /**
     * curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/customer -d '{"name":"govind","id":2,"address":"my home","mobile":980878,"emailid":"govind.nsit07@gmail.com"}'
     */
    @RequestMapping(value = "customer", method = RequestMethod.POST)
    @ResponseBody
    public Customer create(@RequestBody  Customer customer) {
        jdbcTemplate.create(customer);
        Customer customer2 = jdbcTemplate.getCustomer(customer.getId());
        return customer2;
    }
    
    /*
     * curl http://localhost:8080/customer
     * */
    @RequestMapping(value = "customer", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getAllCustomer() {
        List<Customer> listCustomers = jdbcTemplate.listCustomers();
        return listCustomers;
    }

    /*
     * curl http://localhost:8080/customer/1
     * */
    @RequestMapping(value = "customer/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomer(@PathVariable("id") Integer id) {
        Customer listCustomers = jdbcTemplate.getCustomer(id);
        return listCustomers;
    }
    
    
}
