package app.school.administration.common.tenant.service;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
@RequiredArgsConstructor
public class TenantMigrationService {

    private final DataSource dataSource;

    public void migrateTenant(String schema) {
        Flyway.configure()
                .dataSource(dataSource)
                .schemas(schema)
                .locations("classpath:db/migration/master")
                .baselineOnMigrate(true)
                .table("flyway_schema_history")
                .load()
                .migrate();
    }

}
