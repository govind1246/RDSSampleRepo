package com.codetutr.bo.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.codetutr.bo.Customer;

public class CustomerMapper  implements RowMapper<Customer> {
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getLong("id"));
        customer.setName(rs.getString("name"));
        customer.setAddress(rs.getString("address"));
        customer.setMobile(rs.getLong("mobile"));
        customer.setEmailid(rs.getString("email"));
        return customer;
     }
}
