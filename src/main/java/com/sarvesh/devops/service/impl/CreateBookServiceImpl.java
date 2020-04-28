package com.sarvesh.devops.service.impl;

import com.sarvesh.devops.model.BookModel;
import com.sarvesh.devops.service.CreateBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateBookServiceImpl implements CreateBookService {

    Logger logger = LoggerFactory.getLogger(CreateBookServiceImpl.class);

    @Override
    public Long createBook(BookModel bookModel) {
        logger.info("created book with id" + 1);
        return 1L;
    }

}
