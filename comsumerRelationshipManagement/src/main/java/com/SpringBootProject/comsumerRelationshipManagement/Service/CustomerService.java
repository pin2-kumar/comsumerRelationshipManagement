package com.SpringBootProject.comsumerRelationshipManagement.Service;

import com.SpringBootProject.comsumerRelationshipManagement.Entity.Customer;
import java.util.List;

public interface CustomerService {
    String insertCustomer(Customer customer);

    List<Customer> getCustomerList();

    Customer getCustomerById(int id);

    String customerUpdate(Customer customer);

    String customerDeleteById(int id);

   // String getInsertMultipleCustomer(List<Customer> customers);

    String insertMultipleCustomer(List<Customer> customers);

    //finding the customer by first name

    List<Customer>getCustomerByfirstname(String firstname );

    List <Customer>getCustomerBYLessThanage(int age);

    List <Customer> getCustomerByMoreThanage(int age);

    List <Customer> getCustomerByage(int age);


    //List <Customer> getCustomerByAgeRange( int min-age ,int max-age);

    List <Customer>getCustomerByemail(String email);


    List<Customer> getCustumerBylastname(String lastname);


    List<Customer>getCustomerBYmobile(long mobile);

    String updatefirsname(int id , String firstname);


    String updatelastname(int id ,String lastname);

    String updatemobile(int id, String mobile);

    int updateAge (int id ,int age);
}
