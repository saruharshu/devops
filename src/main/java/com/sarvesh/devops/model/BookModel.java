package com.sarvesh.devops.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class BookModel {

    @NotEmpty
    private String name;
    @Positive
    private Long cost;
    @NotEmpty
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
