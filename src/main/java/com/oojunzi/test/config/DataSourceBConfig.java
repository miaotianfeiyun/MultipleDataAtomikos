package com.oojunzi.test.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@MapperScan(basePackages = "com.oojunzi.test.dao1", sqlSessionTemplateRef  = "test2SqlSessionTemplate")
public class DataSourceBConfig {

	@Autowired
	@Bean(name = "test2DataSource")
	public AtomikosDataSourceBean test2DataSource(Environment env) {

		AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
		Properties prop = DataSourceAConfig.build(env, "spring.datasource.druid.test2.");
		ds.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
		ds.setUniqueResourceName("test2");
		ds.setPoolSize(5);
		ds.setXaProperties(prop);

		return ds;
	}
	/** 
	 * @Description: jdbc方式调用
	 * @param  ds
	 * @return JdbcTemplate
	 * @author liujq-2018年9月11日
	 */
	@Bean("test2JdbcTemplate")
	public JdbcTemplate busJdbcTemplate(@Qualifier("test2DataSource") DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	
	@Bean(name = "test2SqlSessionFactory")
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/test2/*.xml"));
		return bean.getObject();
	}

	@Bean(name = "test2SqlSessionTemplate")
	public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	
}
