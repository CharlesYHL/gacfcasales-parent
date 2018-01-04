package com.gacfcasales.dmsweb.aspect;

import java.lang.reflect.Method;  
import org.aspectj.lang.JoinPoint;  
  
  
import org.aspectj.lang.reflect.MethodSignature;  
  
  

public class DataSourceAspect {
	/** 
     * 在dao层方法之前调用，获取  @DataSource 注解标记的数据源名称 
     */  
    public void before(JoinPoint point) {  
        Object target = point.getTarget();  
        String methodName = point.getSignature().getName();  
        MethodSignature methodSignature = (MethodSignature) point.getSignature();    
        Method method = methodSignature.getMethod();    
        //获取方法上的 @DataSource 注解  
        DataSourceAnnotation annotation = (DataSourceAnnotation) method.getAnnotation(DataSourceAnnotation.class);  
        String dataSourceName = null;  
        if (annotation != null) {  
            //获得注解标记的数据源名称  
            dataSourceName = annotation.value();  
            HandleDataSource.putDataSource(dataSourceName);  
        }  
        printMsg("方法={0};使用数据源={1}",methodName,annotation);  
          
    }  
      
    void printMsg(String pattern, Object... arguments){  
        System.out.println(java.text.MessageFormat.format(pattern,arguments));  
    }  
}
