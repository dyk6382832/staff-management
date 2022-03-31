package com.jiayu.staffmanagement.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class SpringUtil implements ApplicationContextAware, EmbeddedValueResolverAware {

    private static ApplicationContext applicationContext;

    private static StringValueResolver stringValueResolver;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }
    }
    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
    	SpringUtil.stringValueResolver = stringValueResolver;
    }

    /**
     * 动态获取配置文件中的值
     * @param name
     * @return
     */
    public static String getPropertiesValue(String name) {
        try {
            if(!name.startsWith("${")){
                name = "${" + name + "}";
            }
            return stringValueResolver.resolveStringValue(name);
        } catch (Exception e) {
            // 获取失败则返回null
            return null;
        }
    }

    public static void main(String[] args) {
    }
    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取 Bean.
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    //class Bean.
    public static <T> List<T> getBeans(Class<T> clazz){
        List<T> lists = new ArrayList<T>();
        Map<String, T> map = getApplicationContext().getBeansOfType(clazz);
        for (T v : map.values()) {
            lists.add(v);
        }
        return lists;
    }
    
    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }

    
}
