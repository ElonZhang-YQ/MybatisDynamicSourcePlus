package com.ez.mybatisdynamicsourceplus.datasource;

import com.esotericsoftware.minlog.Log;
import com.ez.mybatisdynamicsourceplus.type.DataSourceType;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Classname DynamicDataSource
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/18
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {

		DataSourceType.DataBaseType dataBaseType = DataSourceType.getDataBaseType();
		Log.info("当前determineCurrentLookupKey类中，databBaseType：" + dataBaseType);
		return dataBaseType;
	}
}
