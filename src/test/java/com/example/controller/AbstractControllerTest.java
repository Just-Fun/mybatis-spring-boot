package com.example.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author sergii.zagryvyi on 16.10.2017
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestWebConfiguration.class})
@WebAppConfiguration
public abstract class AbstractControllerTest {

    @Autowired
    private WebApplicationContext context;

    MockMvc mockMvc;

    @Before
    public void setup() throws Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
}
