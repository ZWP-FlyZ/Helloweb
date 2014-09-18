package com.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.dao.*;
import com.service.model.Data;
import com.service.model.ParaList;

@Service
public class DataService {
	
      @Autowired
        private   DataMapper DataMapper;
      
      
      public DataService(){}
//      public DataService(DataMapper dm){
//    	  this.DataMapper = dm;
//      }
      
      public Data getDataById(Integer id){
    	  return DataMapper.selectDataByID(id);
      }
      
      public List<Data> getDataList(Integer staff , Integer len){
    	 return  DataMapper.selectDataList(new ParaList(staff, len));
      }
}
