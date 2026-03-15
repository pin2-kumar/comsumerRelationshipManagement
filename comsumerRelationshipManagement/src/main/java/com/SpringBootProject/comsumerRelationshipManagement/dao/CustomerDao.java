package com.SpringBootProject.comsumerRelationshipManagement.dao;

import com.SpringBootProject.comsumerRelationshipManagement.Entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public String insertCustomer(Customer customer) {
        Session session = sessionFactory.openSession();

        //transaction can be use ->insert ,delete,update
        Transaction tx = session.beginTransaction();
        session.save(customer);
        tx.commit();
        session.close();
        return "Customer inserted successfully";
    }

    public List<Customer> getCustomerList() {
        Session session = sessionFactory.openSession();
        List<Customer> customers = session.createQuery("from Customer", Customer.class).list();

        session.close(); // Close session, not sessionFactory
        return customers;
    }

    public Customer getcustomeById(int id) {
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    public String updateCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(customer);
        tx.commit();
        session.close();
        return "Customer updated successfully";

    }

    public String deleteCustomerById(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
           session.delete(customer);
        tx.commit();
        session.close();
        return "customer delete successfully";

    }

    public String insertMultipleCustomer(List<Customer> customers){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        for(Customer customer : customers){
            session.save(customer);
        }
        tx.commit();
        session.close();
        return "Multiple customers inserted successfully";
    }
// find data fro firt name
    public List <Customer> getCustomerByfirstname(String firstname){
        Session session=sessionFactory.openSession();
       Query<Customer> customer = session.createQuery("from Customer c where c.firstname= :firstname",Customer.class);
       customer.setParameter("firstname", firstname);
       List <Customer> list = customer.list();
       return list;

    }

    // find the data by age like 20 and below 20 all data find

    public List<Customer> getCustomerBYLessThanage(int age){
        Session session=sessionFactory.openSession();
        Query<Customer> customer =session.createQuery("from Customer c where c.age<:age",Customer.class);
        customer.setParameter("age", age);
        List<Customer> list= customer.list();
        return list;
    }

    public List<Customer>getCustomerByMoreThanage(int age){
        Session session = sessionFactory.openSession();
        Query<Customer> customer = session.createQuery("from Customer c where c.age > :age", Customer.class);
        customer.setParameter("age",age);
        List<Customer> list = customer.list();
        return list;
    }

    public List <Customer>getCustomerByage(int age){
        Session session= sessionFactory.openSession();
        Query<Customer>customer = session.createQuery("from Customer c where c.age>=:age",Customer.class);
        customer.setParameter("age",age);
        List<Customer> list= customer.list();
        return list;
    }

//    public List<Customer> getCustomerByAgeRange(int minage, int maxage) {
//        Session session = sessionFactory.openSession();
//        Query<Customer> customer = session.createQuery("from Customer c where c.age >= :minage and c.age <= :maxage", Customer.class);
//        customer.setParameter("minage", minage);
//        customer.setParameter("maxage", maxage);
//        List<Customer> list = customer.list();
//        return list;
//
//    }

    public List <Customer>getCustomerByemail(String email){
        Session session = sessionFactory.openSession();
        Query<Customer> customer= session.createQuery("from Customer c where c.email = :email" ,Customer.class);
        customer.setParameter("email",email);
        List<Customer>list= customer.list();
        return list;

    }

    public List <Customer>getCustumerBylastname(String lastname){
        Session session = sessionFactory.openSession();
        Query<Customer> customer = session.createQuery("from Customer c where c.lastname= :lastname ",Customer.class);
        customer.setParameter("lastname",lastname);
        List<Customer>list=customer.list();
        return list;
    }

    public List <Customer> getCustomerBYmobile(long mobile){
        Session session = sessionFactory.openSession();
        Query<Customer> customer = session.createQuery("from Customer c where c.mobile = :mobile",Customer.class);
        customer.setParameter("mobile",mobile);
        List<Customer> list = customer.list();
        return list;

    }

    public String updatefirsname(int id ,String firstname ){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Customer customer= session.get(Customer.class,id);
        customer.setFirstname(firstname);
        tx.commit();
        session.close();

        return "update successfully";
    }

    public String updatelastname (int id , String lastname){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Customer customer = session.get(Customer.class,id);
        customer.setLastname(lastname);
        tx.commit();
        session.close();

        return "lastname update successfully";
    }

    public String updatemobile(int id ,String mobile){
        Session session= sessionFactory.openSession();
        Transaction tx= session.beginTransaction();
        Customer customer= session.get(Customer.class ,id);
        customer.setMobileNumber(Long.parseLong(mobile));
        tx.commit();
        session.close();
        return "mobile number update successfully";
    }

    public int updateAge(int id , int age){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Customer customer = session.get(Customer.class , id);
        customer .setAge(age);
        tx.commit();
        session.close();

        return age ;
    }

}
















