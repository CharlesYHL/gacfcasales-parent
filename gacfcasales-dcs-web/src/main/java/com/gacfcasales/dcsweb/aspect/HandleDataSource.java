package com.gacfcasales.dcsweb.aspect;

public class HandleDataSource {
	 /** 
     * 保存当前线程使用的数据源名称 
     */  
    public static final ThreadLocal<String> holder = new ThreadLocal<String>();    
    /**   
     * 绑定当前线程数据源路由的key      
     * @param key   
     */    
    public static void putDataSource(String datasource) {    
        holder.set(datasource);  
  
  
        System.out.println(java.text.MessageFormat.format("线程[{0}],设置使用的数据源={1}"  
                ,Thread.currentThread().getName()  
                ,datasource));  
    }    
        
    /**   
     * 获取当前线程的数据源路由的key   
     * @return   
     */    
    public static String getDataSource() {    
        System.out.println(java.text.MessageFormat.format("线程[{0}],获取使用的数据源={1}"  
                ,Thread.currentThread().getName()  
                ,holder.get()));  
        return holder.get();    
    }     
}
