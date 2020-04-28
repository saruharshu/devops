package com.sarvesh.devops.controller;

import com.sarvesh.devops.model.BookModel;
import com.sarvesh.devops.service.CreateBookService;
import com.sarvesh.devops.service.impl.CreateBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("book")
public class CreateBookController {

    @Autowired
    private CreateBookService createBookServiceImpl;

    @PostMapping
    public ResponseEntity<Long> createBook(@RequestBody @Valid BookModel bookModel) {
        return ResponseEntity.ok(createBookServiceImpl.createBook(bookModel));
    }

}
