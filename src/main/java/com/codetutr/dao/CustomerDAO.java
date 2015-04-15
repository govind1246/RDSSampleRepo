package com.codetutr.dao;

import java.util.List;

import javax.sql.DataSource;

import com.codetutr.bo.Customer;

public interface CustomerDAO {

    public void setDataSource(DataSource ds);

    public void create(Customer customer);

    public Customer getCustomer(Long id);

    public List<Customer> listCustomers();

    public void delete(Long id);

}
