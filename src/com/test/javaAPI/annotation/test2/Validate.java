package com.test.javaAPI.annotation.test2;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解：
 * 
 * 参考：
 * http://www.cnblogs.com/liangweiping/p/3837332.html
 * @author Wei
 * @time  2017年4月10日 下午5:14:59
 */
@Documented
@Inherited
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {

	public int min() default 1;
	
	public int max() default 10;
	
	public boolean isNotNull() default true;
	
}
