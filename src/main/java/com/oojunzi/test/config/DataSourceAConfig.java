package com.oojunzi.test.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceAConfig {
	@Bean(name = "test1DataSource")
	@Primary
	@Autowired
	public DataSource test1DataSource(Environment env) {
		AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
		Properties prop = build(env, "spring.datasource.druid.test1.");
		ds.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
		ds.setUniqueResourceName("test1");
		ds.setPoolSize(5);
		ds.setXaProperties(prop);
		return ds;

	}
	
	
	@Primary
	@Bean(name = "test1SqlSessionFactory")
	public SqlSessionFactory test1SqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/test1/*Mapper.xml"));
		return bean.getObject();
	}
	
	/** 
	 * @Description: SqlSessionTemplate 方式调用
	 * @param sqlSessionFactory
	 * @throws Exception
	 * @return SqlSessionTemplate
	 * @author liujq-2018年9月11日
	 */
	@Primary
	@Bean(name = "test1SqlSessionTemplate")
	public SqlSessionTemplate test1SqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	

	/** 
	 * @Description: jdbc 方式调用
	 * @param  ds
	 * @return JdbcTemplate
	 * @author liujq-2018年9月11日
	 */
	@Bean("test1SqlSessionTemplate")
	public JdbcTemplate sysJdbcTemplate(@Qualifier("test1DataSource") DataSource ds) {
		return new JdbcTemplate(ds);
	}
	

	public static Properties build(Environment env, String prefix) {
		Properties prop = new Properties();
		prop.put("url", env.getProperty(prefix + "jdbcUrl"));
		prop.put("username", env.getProperty(prefix + "username"));
		prop.put("password", env.getProperty(prefix + "password"));
		prop.put("driverClassName", env.getProperty(prefix + "driverClassName", ""));
		prop.put("initialSize", env.getProperty(prefix + "initialSize", Integer.class));
		prop.put("maxActive", env.getProperty(prefix + "maxActive", Integer.class));
		prop.put("minIdle", env.getProperty(prefix + "minIdle", Integer.class));
		prop.put("maxWait", env.getProperty(prefix + "maxWait", Integer.class));
		prop.put("poolPreparedStatements", env.getProperty(prefix + "poolPreparedStatements", Boolean.class));

		prop.put("maxPoolPreparedStatementPerConnectionSize",
				env.getProperty(prefix + "maxPoolPreparedStatementPerConnectionSize", Integer.class));

		prop.put("validationQuery", env.getProperty(prefix + "validationQuery"));
		// prop.put("validationQueryTimeout", env.getProperty(prefix +
		// "validationQueryTimeout", Integer.class));
		prop.put("testOnBorrow", env.getProperty(prefix + "testOnBorrow", Boolean.class));
		prop.put("testOnReturn", env.getProperty(prefix + "testOnReturn", Boolean.class));
		prop.put("testWhileIdle", env.getProperty(prefix + "testWhileIdle", Boolean.class));
		prop.put("timeBetweenEvictionRunsMillis",
				env.getProperty(prefix + "timeBetweenEvictionRunsMillis", Integer.class));
		prop.put("minEvictableIdleTimeMillis",
				env.getProperty(prefix + "minEvictableIdleTimeMillis", Integer.class));
		prop.put("filters", env.getProperty(prefix + "filters"));

		return prop;
	}
}
