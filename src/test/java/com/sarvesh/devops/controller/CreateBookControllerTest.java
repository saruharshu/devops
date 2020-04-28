package com.sarvesh.devops.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sarvesh.devops.model.BookModel;
import com.sarvesh.devops.service.CreateBookService;
import com.sarvesh.devops.service.impl.CreateBookServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CreateBookController.class)
public class CreateBookControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CreateBookService createBookServiceImpl;
    private BookModel bookModel;
    private ObjectMapper mapper;

    @Before
    public void setUp() {
        mapper = new ObjectMapper();
        bookModel = new BookModel();
        bookModel.setName("DevOps");
        bookModel.setAuthor("Sarvesh");
        bookModel.setCost(1L);
        given(this.createBookServiceImpl.createBook(any(BookModel.class))).willReturn(1L);
    }

    @Test
    public void testCreateBookSuccess() throws Exception {
        this.mockMvc.perform(post("/book")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(mapper.writeValueAsString(bookModel))
            .accept(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk())
            .andExpect(content().string(mapper.writeValueAsString(1L)));
    }

    @Test
    public void testCreateBookWithNameAsNull() throws Exception {
        bookModel.setName(null);
        this.mockMvc.perform(post("/book")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(mapper.writeValueAsString(bookModel))
            .accept(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateBookWithAuthorAsNull() throws Exception {
        bookModel.setAuthor(null);
        this.mockMvc.perform(post("/book")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(mapper.writeValueAsString(bookModel))
            .accept(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateBookWithCostAsNegative() throws Exception {
        bookModel.setCost(-1L);
        this.mockMvc.perform(post("/book")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(mapper.writeValueAsString(bookModel))
            .accept(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isBadRequest());
    }

}
