package com.service.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.dao.DataMapper;
import com.service.model.Data;
import com.service.model.ParaList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	
private static ApplicationContext ctx;  
    

//    private static SqlSessionFactory sqlSessionFactory;
//    private static Reader reader; 
//
//    static{
//        try{
//            reader = Resources.getResourceAsReader("conf/mybatis-config.xml");
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public static SqlSessionFactory getSession(){
//        return sqlSessionFactory;
//    }
    
    public static void main(String[] args) {
    //  SqlSession session = sqlSessionFactory.openSession();
        
        try {
        	
     //   Data data = (Data) session.selectOne("com.service.dao.DataMapper.selectDataByID", 1);
        
     //     DataMapper dm = session.getMapper(DataMapper.class);
        	
       	@SuppressWarnings("resource")
        	ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
//        	      
        	
        	DataMapper dm = (DataMapper)ac.getBean("dataMapper");
        	
        	
        	List<Data> datas = dm.selectDataList(new ParaList(0, 10));
        	
        for(Data data:datas){
        	
        	System.out.println(data.getAltitude());
            System.out.println(data.getLongitude());
            System.out.println(data.getLatitude());
            System.out.println(data.getDensity());
            System.out.println(" ------------- ");
        }	
        
        } finally {
        //session.close();
        }
    }
}
