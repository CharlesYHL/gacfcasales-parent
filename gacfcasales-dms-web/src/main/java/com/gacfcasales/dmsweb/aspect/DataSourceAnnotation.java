package com.gacfcasales.dmsweb.aspect;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;    
/**  
 * 定义 @DataSource 注解，标记当前使用的数据源 
 * @version 创建时间：2017年4月17日 上午11:02:07 
 */  
@Retention(RetentionPolicy.RUNTIME)    
@Target(ElementType.METHOD)    
public @interface  DataSourceAnnotation {
	String value();  
}
