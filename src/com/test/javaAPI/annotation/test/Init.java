package com.test.javaAPI.annotation.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 参考自：
 * http://www.cnblogs.com/liangweiping/p/3837332.html
 * http://www.cnblogs.com/absfree/p/5295861.html
 * 第1步：
 * 自定义注解
 * @author Wei
 * @time  2017年4月10日 下午4:38:57
 */
@Documented
@Inherited
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {
	
	public String value() default "i am weiyongle annotaion";
	
	public int valueInt() default 0;
}
