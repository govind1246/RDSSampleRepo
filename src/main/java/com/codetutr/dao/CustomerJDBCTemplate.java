package com.codetutr.dao;

import java.util.List;

import javax.sql.DataSource;

import com.codetutr.bo.Customer;
import com.codetutr.bo.mapper.CustomerMapper;

import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerJDBCTemplate implements CustomerDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    @Override
    public void setDataSource(DataSource ds) {
        dataSource = ds;
        jdbcTemplateObject =  new JdbcTemplate(dataSource);        
    }

    @Override
    public void create(Customer customer) {
        String SQL = "insert into CUSTOMER (ID, name,address,mobile,email) values (?, ?,?,?,?)";
        
        jdbcTemplateObject.update( SQL, customer.getId(), customer.getName(),customer.getAddress(),customer.getMobile(),customer.getEmailid());           
        System.out.println("insert database database successfully");
        
    }

    @Override
    public Customer getCustomer(Long id) {
        String SQL = "select * from CUSTOMER where id = ?";
        Customer customer = jdbcTemplateObject.queryForObject(SQL, 
                          new Object[]{id}, new CustomerMapper());
        return customer;
    }

    @Override
    public List<Customer> listStudents() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }

}
