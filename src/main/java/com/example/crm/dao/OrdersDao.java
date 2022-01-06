package com.example.crm.dao;


import com.example.crm.entity.CustomerOrdersAmounts;
import com.example.crm.entity.CustomerOrdersCount;
import com.example.crm.entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface OrdersDao {
    ArrayList<Orders> queryAll();
    int add(Orders orders);

    int delById(int ordersId);

    int delByIds(String ids);

    int update(@Param("ordersId") int ordersId,@Param("field")  String field,@Param("value") String value);

    ArrayList<CustomerOrdersCount> customerOrdersCount();
    ArrayList<CustomerOrdersAmounts> customerOrdersAmounts();
}
