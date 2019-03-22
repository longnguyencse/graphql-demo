package com.example.demo.bean;

/**
 * Author Mikorn vietnam
 * Created on 22-Mar-19.
 */

public final class PostBuilder {
    private String id;
    private String title;
    private String text;
    private String category;
    private String authorId;

    public PostBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public PostBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public PostBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public PostBuilder withCategory(String category) {
        this.category = category;
        return this;
    }

    public PostBuilder withAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }

    public Post build() {
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setText(text);
        post.setCategory(category);
        post.setAuthorId(authorId);
        return post;
    }
}
