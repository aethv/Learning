package info.kzthink.flywaydemo.migration;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class V3_0__TestJavaMigration implements SpringJdbcMigration {

    @Override
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        jdbcTemplate.query("SELECT * FROM users", new RowMapper<Object>() {
            @Nullable
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                System.out.println(resultSet.getString("username"));
                return null;
            }
        });
    }
}
