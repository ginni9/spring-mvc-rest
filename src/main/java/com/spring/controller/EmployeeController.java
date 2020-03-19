package com.spring.controller;

import com.spring.model.Employee;
import com.spring.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class EmployeeController {
    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping(value="/addEmp",method = RequestMethod.POST)
    public Employee addEmployee(@RequestBody Employee emp)
    {
        userRepository.save(emp);
        return emp;
    }

    @ResponseBody
    @RequestMapping(value="/findEmp",method = RequestMethod.GET)
    public List<Employee> FindAllEmployee()
    {
       return userRepository.findAll();

    }

    @ResponseBody
    @RequestMapping(value="/findByID/{id}")
    public Employee getUserById(@PathVariable int id) {
        return userRepository.getOne(id);
    }

}


