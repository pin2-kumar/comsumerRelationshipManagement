package com.SpringBootProject.comsumerRelationshipManagement.controller;

import com.SpringBootProject.comsumerRelationshipManagement.Entity.Customer;
import com.SpringBootProject.comsumerRelationshipManagement.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class Controller {
    //http://localhost:8080/api/customers

    private final CustomerService Service;

    @Autowired
    public Controller(CustomerService service) {

        this.Service = service;

    }

    @PostMapping("/insert")
                   //          http://localhost:8080/api/customers/insert

    public String insertCustomer(@RequestBody Customer customer) {
        return Service.insertCustomer(customer);
    }

    @GetMapping("/list")
          //       http://localhost:8080/api/customers/list

    public List<Customer> getCustomerList() {
        return Service.getCustomerList();

    }

    @GetMapping("/{id}")
           //             http://localhost:8080/api/customers/5
    public Customer getCustomerById(@PathVariable int id) {
        return Service.getCustomerById(id);

    }

    /// /both or work for update data
//    @PutMapping("/update/{id}")
//    public String customerUpdate(@RequestBody Customer customer){
//       return  Service.customerUpdate(customer);
//    }
    @PutMapping("/update/{id}")
               //         http://localhost:8080/api/customers/update/3
    public String updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customer.setId(id);
        return Service.customerUpdate(customer);
    }

    @DeleteMapping("/delete/{id}")
                //            http://localhost:8080/api/customers/delete/1
    public String customerDeleteById(@PathVariable int id) {

        return Service.customerDeleteById(id);
    }

    @PostMapping("/insertmultiple")
    //            http://localhost:8080/api/customers/insertmultipl
    public String insertMultipleCustomer(@RequestBody List<Customer> customers) {
        return Service.insertMultipleCustomer(customers);
    }

    @GetMapping("/byname/{firstname}")
                  //http://localhost:8080/api/customers/byname/pintu

    public List<Customer> getCustomerByFirstname(@PathVariable String firstname) {
        return Service.getCustomerByfirstname(firstname);
    }

    @GetMapping("/bylessthanage/{age}")
    public List<Customer>getCustomerBYLessThanage(@PathVariable int age ){
        return Service.getCustomerBYLessThanage(age);
    }

    @GetMapping("/bymorethanage/{age}")
    public List<Customer>getCustomerByMoreThanage(@PathVariable int age){
        return Service.getCustomerByMoreThanage(age);
    }

    @GetMapping("/age/{age}")
   public List <Customer>getCustomerByage(@PathVariable int age) {
        return Service.getCustomerByage(age);
    }

//    @GetMapping("/max/min/{age}")
//    public List<Customer> getCustomerByAgeRange(@RequestParam int minage ,@RequestParam int maxage){
//        return Service.getCustomerByAgeRange(minage ,maxage);
//    }

    @GetMapping("/byemail/{email}")
    public List<Customer>getCustomerByEmail(@PathVariable String email){
        return Service.getCustomerByemail(email);
    }


    @GetMapping("/bylastname/{lastname}")
    public List<Customer>getCustumerBylastname(@PathVariable String lastname){
        return Service.getCustumerBylastname(lastname);
    }


    @GetMapping("/bymobile/{mobile}")
    public List<Customer>getCustomerBYmobile(@PathVariable long mobile){
        return Service.getCustomerBYmobile(mobile);
    }


    @PostMapping("/updatefirstname/{id}")
      //                  http://localhost:8080/api/customers/updatefirstname/id

    public String updatefirstname(@PathVariable int id , @RequestBody Map<String ,String> request){
       String firstname = request.get("firstname");
       return Service.updatefirsname(id, firstname);
    }



    @PostMapping("/updatelastname/{id}")
              //            http://localhost:8080/api/customers/updatelastname/id
      public String updatelastname(@PathVariable  int id ,@RequestBody Map<String ,String> request) {
      String lastname = request.get("lastname");
      return Service.updatelastname(id, lastname);

              }

      @PostMapping("/updatenumber/{id}")
    public String updatemobile(@PathVariable int id ,@RequestBody Map<String ,String> request){
          String mobile = request.get("mobile");
          return Service.updatemobile(id, mobile);

      }

      @PostMapping("/updateage/{id}")
    public  int updateAge(@PathVariable int id ,@RequestBody Map<String ,Integer> request){
        int age = request.get ("age");
        return Service.updateAge(id ,age);
      }

}
