package com.example.crm.controller;


import com.example.crm.dao.CustomerDao;
import com.example.crm.entity.Customer;
import com.example.crm.util.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("Customer")
public class CustomerController {
    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("/queryAll")
    @ResponseBody
    public DataTable<Customer> queryAll() {
        //调用接口中查询所有的方法
        ArrayList<Customer> list = customerDao.queryAll();
        DataTable<Customer> dt=new DataTable<>();
        dt.setCount(list.size());
        dt.setData(list);
        return dt;
    }
    @RequestMapping("/add")
    @ResponseBody
    public boolean add(Customer customer){
       return customerDao.add(customer)>0;
    }
    @RequestMapping("/delById")
    @ResponseBody
    public boolean delById(int customerId){
        return customerDao.delById(customerId)>0;
    }
    @RequestMapping("/delByIds")
    @ResponseBody
    public boolean delByIds(String ids) {
        return customerDao.delByIds(ids)>0;
    }
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(int customerId,String field,String value) {
        return customerDao.update(customerId,field,value)>0;
    }
}