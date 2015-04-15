package com.codetutr.controller;

import java.io.IOException;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
        DataSource dataSource;
        JdbcTemplate jdbcTemplate;
        customer.setName(request.getParameter("name"));
        customer.setAddress(request.getParameter("address"));
        customer.setMobile(Long.valueOf(request.getParameter("mobile")));
        customer.setEmailid(request.getParameter("emailid"));
        model.addAttribute("cust", customer);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        dataSource = (DataSource)applicationContext.getBean("dataSource");
        jdbcTemplate =  new JdbcTemplate(dataSource);
        Connection c = null;
        Statement stmt = null;
        try {
             // http://www.tutorialspoint.com/postgresql/postgresql_java.htm
//           Class.forName("org.postgresql.Driver");
//           c = DriverManager
//              .getConnection("jdbc:postgresql://testdb.caknwy3ygfjr.ap-southeast-1.rds.amazonaws.com:5432/testdb",
//              "govind1246", "govind1246");
//           System.out.println("Opened database successfully");
//           stmt = c.createStatement();
//           String sql = "CREATE TABLE CUSTOMER " +
//                        "(ID INT PRIMARY KEY     NOT NULL," +
//                        " NAME           TEXT    NOT NULL, " +
//                        " ADDRESS        CHAR(50), " +
//                        " MOBILE       CHAR(50), " +
//                        " EMAIL         CHAR(50) )";
//           stmt.executeUpdate(sql);
//           stmt.close();
//           c.close();
            System.out.println("before insert database database ");
           String SQL = "insert into CUSTOMER (ID, name,address,mobile,email) values (?, ?,?,?,?)";
           
           jdbcTemplate.update( SQL, 1, "govind","150, marudhar","87878787","govind.soni");           
           System.out.println("insert database database successfully");
           
        } catch (Exception e) {
           e.printStackTrace();
           System.err.println(e.getClass().getName()+": "+e.getMessage());
           System.exit(0);
        }
        System.out.println("Table created successfully");
        return "welcome";
    }
 
}