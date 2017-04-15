package in.ideative;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Real magic begins here
 *
 * Main class for Ideative Application
 *
 * Created by harshit on 28/3/17.
 */
@MapperScan("in.ideative.dao")
@SpringBootApplication
public class ApiApplication extends SpringBootServletInitializer {

  ApiApplication() {}

  /**
   * This binds the database properties from yml properties named as database
   *
   * @return
   */
  @Bean
  @ConfigurationProperties("database")
  public DataSource ideativeDataSource() {
    return DataSourceBuilder.create().build();
  }

  /**
   * This Bind our data source with spring transaction manager
   * @return
   */
  @Bean
  public PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(ideativeDataSource());
  }

  /**
   * This method create Sqlsession factory out of datasource and register mybatis type alias package </br>
   * also it tells the location of mybatis mappers file in the classpath
   * @return
   * @throws Exception
   */
  @Bean
  public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(ideativeDataSource());
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
    sqlSessionFactoryBean.setTypeAliasesPackage("in.ideative.model");
    return sqlSessionFactoryBean.getObject();
  }

  /**
   * Main method to start the application
   * @param args command line arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(ApiApplication.class, args);
  }

}