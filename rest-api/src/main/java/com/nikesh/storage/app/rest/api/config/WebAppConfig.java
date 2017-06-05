package com.nikesh.storage.app.rest.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Nikesh Maharjan
 *         nikeshmhr@gmail.com
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.nikesh.storage.app.rest.api", "storage.services"})
@EnableJpaRepositories(basePackages = "storage.repositories")
public class WebAppConfig {
}
