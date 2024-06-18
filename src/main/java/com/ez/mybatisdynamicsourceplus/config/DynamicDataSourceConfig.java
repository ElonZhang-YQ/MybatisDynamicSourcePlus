package com.ez.mybatisdynamicsourceplus.config;

import com.ez.mybatisdynamicsourceplus.datasource.DynamicDataSource;
import com.ez.mybatisdynamicsourceplus.type.DataSourceType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname DynamicDataSourceConfig
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/18
 */
@Configuration
@MapperScan(basePackages = "com.ez.mybatisdynamicsourceplus.mapper", sqlSessionFactoryRef = "SqlSessionFactory")
public class DynamicDataSourceConfig {

	@Bean(name = "MasterDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.master")
	public DataSource getMasterDataSource() {

		return DataSourceBuilder.create().build();
	}

	@Bean(name = "SlaveDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.slave")
	public DataSource getSlaveDataSource() {

		return DataSourceBuilder.create().build();
	}

	@Bean(name = "dynamicDataSource")
	public DynamicDataSource DataSource(@Qualifier("MasterDataSource") DataSource masterDataSource,
										@Qualifier("SlaveDataSource") DataSource slaveDataSource) {

		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(DataSourceType.DataBaseType.Master, masterDataSource);
		targetDataSources.put(DataSourceType.DataBaseType.Slave, slaveDataSource);
		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(targetDataSources);
		// 设置默认对象
		dataSource.setDefaultTargetDataSource(masterDataSource);
		return dataSource;
	}

	@Bean(name = "SqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) throws Exception {

		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dynamicDataSource);
		return bean.getObject();
	}

}
