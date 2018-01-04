package com.gacfcasales.dmsweb.aspect;

import java.util.Map;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;  

public class ChooseDataSource extends AbstractRoutingDataSource{
	
	 protected Object determineCurrentLookupKey() {  
	        //返回当前线程使用的数据源名称  
	        return  HandleDataSource.getDataSource();    
	    }  
	      
	    public void setTargetDataSources(Map<Object, Object> targetDataSources) {  
	        super.setTargetDataSources(targetDataSources);  
	          
	        System.out.println("配置读写分离数据源：");  
	        //设置目标数据源  
	        if(targetDataSources!=null){  
	           for (Object key : targetDataSources.keySet()) {
	        	   System.out.println(java.text.MessageFormat.format("数据源：{0}={1}", key,targetDataSources.get(key)));  
	           }
	        }  
	    }  
}
