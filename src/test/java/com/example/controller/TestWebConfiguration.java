package com.example.controller;

import com.example.dao.BookMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static org.mockito.Mockito.mock;

/**
 * @author sergii.zagryvyi on 16.10.2017
 */
@Configuration
//TODO: added support for https://stackoverflow.com/questions/34981198/spring-mvc-configuration-with-enablewebmvc-and-webmvcconfigureradapter-for-stat
@EnableWebMvc
@ComponentScan(basePackages = {"com.example.controller"})
public class TestWebConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public BookMapper bookMapper() {
        return mock(BookMapper.class);
    }

    @Bean
    public BookController bookController() {
        return new BookController(bookMapper());
    }

}
