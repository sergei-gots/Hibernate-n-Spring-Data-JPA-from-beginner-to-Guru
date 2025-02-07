package guru.springframework.sdjpaintro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * To the Lesson 32 'Configuring MySQL with Spring Boot'.
 * Helper Class to ensure that connection to the Database is being established
 * Created by sergei gots on 07/02/2025
 */
@Component
public class DataSourceChecker implements CommandLineRunner {

    private final DataSource dataSource;

    public DataSourceChecker(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("✅ DataSource Connection Successful!");
        } catch (SQLException e) {
            System.out.println("❌ Error obtaining DataSource connection: " + e.getMessage());
        }
    }
}
