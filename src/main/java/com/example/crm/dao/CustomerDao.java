package com.example.crm.dao;

import com.example.crm.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface CustomerDao {
    ArrayList<Customer> queryAll();
    int add(Customer customer);
    int delById(int customerId);
    int delByIds(String ids);
    int update(@Param("customerId") int customerId, @Param("field") String field, @Param("value") String value);


}
