package com.example.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * 데이터베이스 관련 설정
 */
@Configuration
public class DatabaseConfiguration {
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * DB 접속을 위한 DataSource 등록
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("1234");
		dataSource.setPort(3306);
		dataSource.setDatabaseName("profile");
		dataSource.setUrl("jdbc:mysql://localhost:3306/profile?characterEncoding=UTF-8");
		return dataSource();
	}
	
	/**
	 * Mybatis Session Factory 등록
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setMapperLocations(
			new PathMatchingResourcePatternResolver()
			.getResources("classpath:config/mapper/**.xml"));
		return factoryBean.getObject();
	}
	
	/**
	 * Mybatis Mapper 스캐너 등록
	 * @return
	 */
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setBasePackage("com.example");
		return configurer;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	

}
