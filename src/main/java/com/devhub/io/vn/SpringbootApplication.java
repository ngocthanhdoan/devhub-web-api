package com.devhub.io.vn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.devhub.io.vn.plugins.CodeMap;
import com.devhub.io.vn.plugins.DataSet;

//import com.devhub.mv.jdbc.DataSet;
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@Configuration
public class SpringbootApplication implements WebMvcConfigurer {

	@Value("${database_name}")
	private String database_name;

	@Value("${database_host}")
	private String database_host;

	@Value("${database_ports}")
	private String database_posts;

	@Value("${database_username}")
	private String database_username;

	@Value("${database_password}")
	private String database_password;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("*")
				.allowedHeaders("*")
				.exposedHeaders("*")
				.allowCredentials(false)
				.maxAge(3600); // Max age of the CORS pre-flight request
	}

	@Bean
	public DataSet dataSet() {
		if (database_host == null || database_name == null || database_password == null || database_username == null) {
			return null;
		}
		DataSet ds = new DataSet();
		ds.setDB_DATABASE_NAME(database_name);
		ds.setHOSTNAME(database_host);
		ds.setDB_USERNAME(database_username);
		ds.setDB_PASSWORD(database_password);
		try {

			CodeMap.reNewData(ds);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
