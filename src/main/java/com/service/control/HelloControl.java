package com.service.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.dao.DataMapper;
import com.service.model.Data;
import com.service.model.ParaList;

  
 @Controller
 @RequestMapping("/hello")
public class HelloControl  extends BaseControl {
 
	 @RequestMapping("/index")
	 String  index(Integer id,ModelMap map){
	
		 List<Data> datas = dataService.getDataList(0, 10);
	        for(Data data:datas){
	        	System.out.println(data.getAltitude());
	            System.out.println(data.getLongitude());
	            System.out.println(data.getLatitude());
	            System.out.println(data.getDensity());
	            System.out.println(" ------------- ");
	        }	 
		
		 return "index";
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/list.json",method=RequestMethod.GET)
	   public List<Data>  getDataList(){
		 
		 return  dataService.getDataList(0, 1000);
		 
	 }
	 
	 @ResponseBody
	 @RequestMapping(value="/{num}.json",method=RequestMethod.GET)
	   public Data  getData(@PathVariable("num")Integer num){
		 
		 System.out.println("num = " + num);
		 return  dataService.getDataById(num);
	 }
	 
	 
	 @RequestMapping("/map")
	 String  map(Integer id,ModelMap map){
		 map.put("data", "mydata");
		 return "map";
	 }
	  
}
