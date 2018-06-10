package by.itacademy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "by.itacademy.repository")
@Import(PersistenceConfig.class)
public class ApplicationConfig {
}
