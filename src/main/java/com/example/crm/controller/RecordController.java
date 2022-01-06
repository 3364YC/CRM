package com.example.crm.controller;

import com.example.crm.dao.OrdersDao;
import com.example.crm.dao.RecordDao;
import com.example.crm.entity.Orders;
import com.example.crm.entity.Record;
import com.example.crm.util.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@Controller
    @RequestMapping("/Record")
    public class RecordController {
        @Autowired
        private RecordDao recordDao;
        @Autowired
        private OrdersDao ordersDao;
    @RequestMapping("/queryAll")
        @ResponseBody
        public DataTable<Record> queryAll() {
            //调用接口中查询所有的方法
            ArrayList<Record> list = recordDao.queryAll();
            DataTable<Record> dt=new DataTable<>();
            dt.setCount(list.size());
            dt.setData(list);
            return dt;
        }
        @RequestMapping("/delById")
        @ResponseBody
        public boolean delById(int recordId){
            return recordDao.delById(recordId)>0;
        }
        @RequestMapping("/delByIds")
        @ResponseBody
        public boolean delByIds(String ids) {
            return recordDao.delByIds(ids)>0;
        }
        @RequestMapping("/update")
        @ResponseBody
        public boolean update(int recordId,String field,String value) {
            return recordDao.update(recordId,field,value)>0;
        }
        @RequestMapping("/change")
        @ResponseBody
        public boolean change(Record record){

            Orders orders = new Orders();
            orders.setCustomerId(record.getCustomerId());
            orders.setGoods(record.getNote());
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            orders.setOrdersDate(sdf.format(date));
            return recordDao.change(record) > 0 && ordersDao.add(orders) > 0;
        }
        @RequestMapping("/add")
        @ResponseBody
        public boolean add(Record record){
        if(record.getState()==1){
            Orders orders = new Orders();
            orders.setGoods(record.getNote());
            orders.setCustomerId(record.getCustomerId());
            orders.setOrdersDate(record.getRecordDate());
            ordersDao.add(orders);
        }
            return recordDao.add(record)>0;
        }
}
