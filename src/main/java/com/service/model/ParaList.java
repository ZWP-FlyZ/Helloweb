package com.service.model;

public class ParaList {
       Integer iddata ;
       Integer staff;
       Integer len;
       
       public ParaList(Integer staff,Integer len){
    	   
    	   this.staff = staff;
    	   this.len = len;
       }
       
	public Integer getIddata() {
		return iddata;
	}
	public void setIddata(Integer iddata) {
		this.iddata = iddata;
	}
	public Integer getStaff() {
		return staff;
	}
	public void setStaff(Integer staff) {
		this.staff = staff;
	}
	public Integer getLen() {
		return len;
	}
	public void setLen(Integer len) {
		this.len = len;
	}
	  
}
