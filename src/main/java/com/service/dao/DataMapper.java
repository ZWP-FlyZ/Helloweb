package com.service.dao;

import java.util.List;

import com.service.model.Data;
import com.service.model.ParaList;

public interface DataMapper {
	
	   public  Data selectDataByID(Integer id);
	   public  List<Data> selectDataList(ParaList para);
	   
}
