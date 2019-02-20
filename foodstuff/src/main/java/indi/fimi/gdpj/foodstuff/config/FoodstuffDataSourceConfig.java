package indi.fimi.gdpj.foodstuff.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 后台数据库配置
 *
 * @author Mr.ZHUANG
 */
@Configuration
@MapperScan(basePackages = FoodstuffDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "foodstuffSqlSessionFactory")
public class FoodstuffDataSourceConfig {

    static final String PACKAGE = "indi.fimi.gdpj.foodstuff.repository";

    private static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Bean(name = "foodstuffDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.foodstuff")
    @Primary
    public DataSource foodstuffDataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name = "foodstuffTransactionManager")
    @Primary
    public DataSourceTransactionManager foodstuffTransactionManager() {
        return new DataSourceTransactionManager(foodstuffDataSource());
    }

    @Bean(name = "foodstuffSqlSessionFactory")
    @Primary
    public SqlSessionFactory foodstuffSqlSessionFactory(@Qualifier("foodstuffDataSource") DataSource foodstuffDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(foodstuffDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
//        sessionFactory.setTypeAliases(new Class[]{User.class, UserRole.class, UserAuth.class, ModLog.class,UserGroup.class});
        sessionFactory.setTypeAliasesPackage("indi.fimi.gdpj.foodstuff.domain");
        return sessionFactory.getObject();
    }
}
