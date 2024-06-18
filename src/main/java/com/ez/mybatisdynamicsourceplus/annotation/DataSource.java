package com.ez.mybatisdynamicsourceplus.annotation;

import java.lang.annotation.*;

/**
 * @Classname DataSource
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/18
 */
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

	String value() default "Master";
}
