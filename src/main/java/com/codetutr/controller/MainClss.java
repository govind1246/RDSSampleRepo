package com.codetutr.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainClss {
    public static void main(String args[]) {
        Connection c = null;
        try {
           Class.forName("org.postgresql.Driver");
           c = DriverManager
              .getConnection("jdbc:postgresql://testdb.caknwy3ygfjr.ap-southeast-1.rds.amazonaws.com:5432/testdb",
              "govind1246", "admin");
        } catch (Exception e) {
           e.printStackTrace();
           System.err.println(e.getClass().getName()+": "+e.getMessage());
           System.exit(0);
        }
        
        System.out.println("Opened database successfully");
     }
}
