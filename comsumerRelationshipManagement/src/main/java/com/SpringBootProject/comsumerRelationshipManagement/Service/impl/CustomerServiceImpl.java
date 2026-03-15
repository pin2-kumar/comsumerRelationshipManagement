package com.SpringBootProject.comsumerRelationshipManagement.Service.impl;

import com.SpringBootProject.comsumerRelationshipManagement.Entity.Customer;
import com.SpringBootProject.comsumerRelationshipManagement.Service.CustomerService;
import com.SpringBootProject.comsumerRelationshipManagement.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao){

        this.customerDao = customerDao;
    }

    @Override
    public String insertCustomer(Customer customer){
        return customerDao.insertCustomer(customer);
    }

    @Override
    public List getCustomerList() {
        return (List) customerDao.getCustomerList();
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDao.getcustomeById(id);
    }

    @Override
    public String customerUpdate(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public String customerDeleteById(int id) {
        return customerDao.deleteCustomerById(id);
    }

    @Override
    public String insertMultipleCustomer(List<Customer> customers) {
        return customerDao.insertMultipleCustomer(customers);
    }

    @Override
    public List<Customer> getCustomerByfirstname(String firstname){
        return customerDao.getCustomerByfirstname(firstname);

    }

    @Override
    public List<Customer> getCustomerBYLessThanage(int age) {
        return customerDao.getCustomerBYLessThanage(age);

    }

    @Override
    public List<Customer> getCustomerByMoreThanage(int age) {
        return customerDao.getCustomerByMoreThanage(age);
    }

    @Override
    public List<Customer> getCustomerByage(int age) {
        return customerDao.getCustomerByage(age);
    }

//    @Override
//    public List<Customer> getCustomerByAgeRange(int min, int max) {
//        return customerDao.getCustomerByAgeRange(min, max);
//    }

    @Override
    public List<Customer> getCustomerByemail(String email) {
        return customerDao.getCustomerByemail(email);
    }

    @Override
    public List<Customer> getCustumerBylastname(String lastname) {
        return customerDao.getCustumerBylastname(lastname);
    }

    @Override
    public List<Customer> getCustomerBYmobile(long mobile) {
        return customerDao.getCustomerBYmobile(mobile);
    }

    @Override
    public String updatefirsname(int id, String firstname) {
        return customerDao.updatefirsname(id ,firstname);
    }

    @Override
    public String updatelastname(int id, String lastname) {
        return customerDao.updatelastname (id ,lastname);
    }

    @Override
    public String updatemobile(int id, String mobile) {
        return customerDao.updatemobile(id,mobile);
    }

    @Override
    public int updateAge(int id, int age) {
        return customerDao.updateAge(id ,age);
    }


}
