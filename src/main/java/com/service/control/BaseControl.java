package com.service.control;

import org.springframework.beans.factory.annotation.Autowired;

import com.service.service.DataService;

public class BaseControl {
  
	@Autowired
	protected DataService dataService;
	
	
}
