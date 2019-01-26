package indi.fimi.gdpj.shoppingcart.config;

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
@MapperScan(basePackages = ShoppingCartDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "shoppingCartSqlSessionFactory")
public class ShoppingCartDataSourceConfig {

    static final String PACKAGE = "indi.fimi.gdpj.shoppingCart.domain";

    private static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Bean(name = "shoppingCartDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.shoppingCart")
    @Primary
    public DataSource shoppingCartDataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name = "shoppingCartTransactionManager")
    @Primary
    public DataSourceTransactionManager shoppingCartTransactionManager() {
        return new DataSourceTransactionManager(shoppingCartDataSource());
    }

    @Bean(name = "shoppingCartSqlSessionFactory")
    @Primary
    public SqlSessionFactory shoppingCartSqlSessionFactory(@Qualifier("shoppingCartDataSource") DataSource shoppingCartDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(shoppingCartDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
//        sessionFactory.setTypeAliases(new Class[]{User.class, UserRole.class, UserAuth.class, ModLog.class,UserGroup.class});
        sessionFactory.setTypeAliasesPackage("indi.fimi.gdpj.shoppingCart.domain");
        return sessionFactory.getObject();
    }
}
