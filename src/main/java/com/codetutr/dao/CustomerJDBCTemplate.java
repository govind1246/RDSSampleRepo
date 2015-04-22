package com.codetutr.dao;

import java.util.List;

import javax.sql.DataSource;

import com.codetutr.bo.Customer;
import com.codetutr.bo.mapper.CustomerMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerJDBCTemplate implements CustomerDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private Logger logger = LogManager.getLogger(CustomerJDBCTemplate.class);
    @Override
    public void setDataSource(DataSource ds) {
        dataSource = ds;
        jdbcTemplateObject =  new JdbcTemplate(dataSource);        
    }

    @Override
    public void create(Customer customer) {
    	logger.debug("create is executed!");
        String SQL = "insert into CUSTOMER (ID, name,address,mobile,email) values (?, ?,?,?,?)";
        
        jdbcTemplateObject.update( SQL, customer.getId(), customer.getName(),customer.getAddress(),customer.getMobile(),customer.getEmailid());           
        System.out.println("insert database database successfully");
        
    }

    @Override
    public Customer getCustomer(Integer id) {
        String SQL = "select * from CUSTOMER where id = ?";
        Customer customer = jdbcTemplateObject.queryForObject(SQL, 
                          new Object[]{id}, new CustomerMapper());
        return customer;
    }

    @Override
    public List<Customer> listCustomers() {
        String SQL = "select * from CUSTOMER";
        List <Customer> customers = jdbcTemplateObject.query(SQL, 
                                  new CustomerMapper());
        return customers;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }

	public void update(Customer customer) {
		logger.debug("create is executed!");
        String SQL = "update CUSTOMER set name=?,address=?,mobile=?,email=? where id = ?";
        
        jdbcTemplateObject.update( SQL, customer.getName(),customer.getAddress(),customer.getMobile(),customer.getEmailid(),customer.getId());           
        System.out.println("update database database successfully");
	}

}
