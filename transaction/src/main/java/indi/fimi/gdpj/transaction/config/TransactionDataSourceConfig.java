package indi.fimi.gdpj.transaction.config;

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
@MapperScan(basePackages = TransactionDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "transactionSqlSessionFactory")
public class TransactionDataSourceConfig {

    static final String PACKAGE = "indi.fimi.gdpj.transaction.domain";

    private static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Bean(name = "transactionDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.transaction")
    @Primary
    public DataSource transactionDataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name = "transactionTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionTransactionManager() {
        return new DataSourceTransactionManager(transactionDataSource());
    }

    @Bean(name = "transactionSqlSessionFactory")
    @Primary
    public SqlSessionFactory transactionSqlSessionFactory(@Qualifier("transactionDataSource") DataSource transactionDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(transactionDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
//        sessionFactory.setTypeAliases(new Class[]{User.class, UserRole.class, UserAuth.class, ModLog.class,UserGroup.class});
        sessionFactory.setTypeAliasesPackage("indi.fimi.gdpj.transaction.domain");
        return sessionFactory.getObject();
    }
}
