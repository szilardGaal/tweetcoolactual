package com.codecool.web.model;

import java.util.Date;

public final class Tweet {

    private final String author;
    private final String content;
    private final Date date = new Date();

    public Tweet(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("%s: \n\n %20s", content, author);
    }
}
