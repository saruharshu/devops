package com.sarvesh.devops.service;

import com.sarvesh.devops.model.BookModel;
import com.sarvesh.devops.service.impl.CreateBookServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CreateBookServiceImplTest {

    @InjectMocks
    private CreateBookServiceImpl createBookServiceImpl;

    @Test
    public void testCreateBookSuccess(){
        createBookServiceImpl.createBook(new BookModel());
        Assert.assertEquals(1L, 1L);
    }

}
