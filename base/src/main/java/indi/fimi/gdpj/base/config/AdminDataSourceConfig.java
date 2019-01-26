package indi.fimi.gdpj.base.config;

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
@MapperScan(basePackages = AdminDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "adminSqlSessionFactory")
public class AdminDataSourceConfig {

    static final String PACKAGE = "indi.fimi.gdpj.base.domain";

    private static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Bean(name = "adminDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.admin")
    @Primary
    public DataSource adminDataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name = "adminTransactionManager")
    @Primary
    public DataSourceTransactionManager adminTransactionManager() {
        return new DataSourceTransactionManager(adminDataSource());
    }

    @Bean(name = "adminSqlSessionFactory")
    @Primary
    public SqlSessionFactory adminSqlSessionFactory(@Qualifier("adminDataSource") DataSource adminDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(adminDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
//        sessionFactory.setTypeAliases(new Class[]{User.class, UserRole.class, UserAuth.class, ModLog.class,UserGroup.class});
        sessionFactory.setTypeAliasesPackage("indi.fimi.gdpj.base.domain");
        return sessionFactory.getObject();
    }
}
