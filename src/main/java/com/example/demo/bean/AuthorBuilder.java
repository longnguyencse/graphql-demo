package com.example.demo.bean;

/**
 * Author Mikorn vietnam
 * Created on 22-Mar-19.
 */

public final class AuthorBuilder {
    private String id;
    private String name;
    private String thumbnail;

    public AuthorBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public AuthorBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AuthorBuilder withThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public Author build() {
        Author author = new Author();
        author.setId(id);
        author.setName(name);
        author.setThumbnail(thumbnail);
        return author;
    }
}
