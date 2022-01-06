package com.example.crm.dao;


import com.example.crm.entity.Record;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface RecordDao {
    ArrayList<Record> queryAll();

    int delById(int recordId);

    int delByIds(String ids);

    int update(@Param("recordId") int recordId,@Param("field") String field,@Param("value") String value);

    int change(Record record);

    int add(Record record);
}

