package com.example.demo.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.bean.Author;
import com.example.demo.bean.Post;
import com.example.demo.repository.PostDao;

import java.util.List;

/**
 * Author Mikorn vietnam
 * Created on 21-Mar-19.
 */

public class AuthorResolver implements GraphQLResolver<Author> {
    private PostDao postDao;

    public AuthorResolver(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<Post> getPosts(Author author) {
        return postDao.getAuthorPosts(author.getId());
    }
}
