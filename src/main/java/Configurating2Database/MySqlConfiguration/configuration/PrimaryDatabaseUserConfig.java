package Configurating2Database.MySqlConfiguration.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement // mainly to enable the @Transactional annotation
@EnableJpaRepositories(      // to define the base package of repo that extended the JPA
        basePackages ="Configurating2Database.MySqlConfiguration.repository.primary",
        entityManagerFactoryRef = "primaryEntityManagerFactory",
        transactionManagerRef = "primaryTransactionManager"
)
public class PrimaryDatabaseUserConfig {

    @Primary // indicate which data source should be the default
    @Bean(name = "primaryDataSource") //giving a specific name to the bean,
    @ConfigurationProperties(prefix = "spring.datasource.primary") //binds the properties from the application’s configuration file application.properties
    public DataSource primaryDataSource() { //responsible for creating and configuring a DataSource bean for particular database.
                                              // mainly managing a connection to a databaseIt provides a way to configure, manage, and retrieve database connections
        return DataSourceBuilder.create().build();
    }


    //This method sets up the EntityManagerFactory for managing
    // JPA entities related to the primary database
    @Primary
    @Bean(name = "primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("primaryDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("Configurating2Database.MySqlConfiguration.model.primary")  // Primary DB entity package
                .persistenceUnit("primary")
                .build();
    }

  //This method configures a TransactionManager
  // for handling transactions in the primary database
    @Primary
    @Bean(name = "primaryTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(
            @Qualifier("primaryEntityManagerFactory") EntityManagerFactory primaryEntityManagerFactory) {
        return new JpaTransactionManager(primaryEntityManagerFactory);
    }
}
