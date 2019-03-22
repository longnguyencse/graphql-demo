package com.example.demo.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.bean.Post;
import com.example.demo.bean.PostBuilder;
import com.example.demo.repository.PostDao;

import java.util.UUID;

/**
 * Author Mikorn vietnam
 * Created on 22-Mar-19.
 */

public class Mutation implements GraphQLMutationResolver {
    private PostDao postDao;

    public Mutation(PostDao postDao) {
        this.postDao = postDao;
    }

    public Post writePost (String titles, String text, String category, String author) {
        Post post = new PostBuilder().withId(UUID.randomUUID().toString())
                .withTitle(titles)
                .withText(text)
                .withCategory(category)
                .withAuthorId(author)
                .build();
        postDao.savePost(post);
        return post;
    }
}
