package com.ez.mybatisdynamicsourceplus.aspect;

import com.esotericsoftware.minlog.Log;
import com.ez.mybatisdynamicsourceplus.annotation.DataSource;
import com.ez.mybatisdynamicsourceplus.type.DataSourceType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Classname DataSourceAspect
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/18
 */
@Aspect
@Component
public class DataSourceAspect {

	@Before("@annotation(dataSource)")
	public void setDataSource(JoinPoint joinPoint, DataSource dataSource) throws Throwable {

		String value = dataSource.value();
		if (value.equals("Master")){
			DataSourceType.setDataBaseType(DataSourceType.DataBaseType.Master);
		}else if (value.equals("Slave")){
			DataSourceType.setDataBaseType(DataSourceType.DataBaseType.Slave);
		}else {
			DataSourceType.setDataBaseType(DataSourceType.DataBaseType.Master);//默认使用主数据库
		}
		Log.info("Befrore，当前数据源为：" + String.valueOf(DataSourceType.getDataBaseType()));
	}

	@After("@annotation(dataSource)") //清除数据源的配置
	public void restoreDataSource(JoinPoint joinPoint, DataSource dataSource) {

		DataSourceType.clearDataBaseType();
		Log.info("After，当前数据源为：" + String.valueOf(DataSourceType.getDataBaseType()));
	}
}
