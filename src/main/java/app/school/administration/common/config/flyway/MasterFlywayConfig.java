package app.school.administration.common.config.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MasterFlywayConfig {

    @Bean(initMethod = "migrate")
    Flyway masterFlyway(DataSource dataSource) {
        return Flyway.configure()
                .dataSource(dataSource)
                .locations(
                        "classpath:db/migration/common",
                        "classpath:db/migration/master"
                )
                .schemas("master")
                .createSchemas(true)
                .baselineOnMigrate(true)
                .baselineVersion("1")
                .validateOnMigrate(true)
                .table("flyway_schema_history")
                .load();
    }

}
