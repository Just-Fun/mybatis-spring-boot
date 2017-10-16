package com.example.controller;

import com.example.dao.BookMapper;
import com.example.model.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookControllerTest extends AbstractControllerTest {

    @Autowired
    protected BookMapper bookMapper;

    @Test
    public void home() throws Exception {
        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setId(1);
        Book book2 = new Book();
        book2.setId(2);
        books.add(book1);
        books.add(book2);

        when(bookMapper.findAll()).thenReturn(books);

        MvcResult result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        verify(bookMapper, times(1)).findAll();
        assertTrue(response.startsWith("[{\"id\":1,\"isbn\":null,\"title\":null,"));
    }

    @Test
    public void books() throws Exception {
    }

    @Test
    public void bookByIsbn() throws Exception {
    }

}