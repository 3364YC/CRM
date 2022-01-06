package com.example.crm.controller;

import com.example.crm.dao.OrdersDao;
import com.example.crm.entity.Customer;
import com.example.crm.entity.CustomerOrdersAmounts;
import com.example.crm.entity.CustomerOrdersCount;
import com.example.crm.entity.Orders;
import com.example.crm.util.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("/Orders")
public class OrdersController {
    @Autowired
    private OrdersDao ordersDao;

    @RequestMapping("/queryAll")
    @ResponseBody
    public DataTable<Orders> queryAll() {
        //调用接口中查询所有的方法
        ArrayList<Orders> list = ordersDao.queryAll();
        DataTable<Orders> dt =new DataTable<>();
        dt.setCount(list.size());
        dt.setData(list);
        return dt;
    }
    @RequestMapping("/delById")
    @ResponseBody
    public boolean delById(int ordersId){
        return ordersDao.delById(ordersId)>0;
    }
    @RequestMapping("/delByIds")
    @ResponseBody
    public boolean delByIds(String ids) {
        return ordersDao.delByIds(ids)>0;
    }
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(int ordersId,String field,String value) {
        return ordersDao.update(ordersId,field,value)>0;
    }
    @RequestMapping("/add")
    @ResponseBody
    public boolean add(Orders orders){
        return ordersDao.add(orders)>0;
    }
    @RequestMapping("/customerOrdersCount")
    @ResponseBody
    public HashMap<String ,ArrayList> customerOrdersCount(){
        ArrayList<CustomerOrdersCount> list= ordersDao.customerOrdersCount();
        ArrayList<String> nameList=new ArrayList<>();
        ArrayList<Integer> countList=new ArrayList<>();
for (CustomerOrdersCount cos : list){
        nameList.add(cos.getCustomerName());
        countList.add(cos.getOrdersCount());
}
        HashMap<String, ArrayList> hm=new HashMap<>();
        hm.put("x",nameList);
        hm.put("y",countList);
        return hm;
    }
    @RequestMapping("/customerOrdersAmounts")
    @ResponseBody
    public ArrayList<CustomerOrdersAmounts> customerOrdersAmounts(){
        return ordersDao.customerOrdersAmounts();
    }
}
