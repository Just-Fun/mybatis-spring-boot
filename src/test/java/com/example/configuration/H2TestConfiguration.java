package com.example.configuration;

import com.example.DemoApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author sergii.zagryvyi on 13.10.2017
 */
@Configuration
@Import(DemoApplication.class)
public class H2TestConfiguration {

/*
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }
*/
}
