package com.example.demo.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.bean.Author;
import com.example.demo.bean.Post;
import com.example.demo.repository.AuthorDao;

import java.net.Authenticator;
import java.util.Optional;

/**
 * Author Mikorn vietnam
 * Created on 21-Mar-19.
 */

public class PostResolver implements GraphQLResolver<Post> {
    private AuthorDao authorDao;

    public PostResolver(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public Optional<Author> getAuthor(Post post) {
        return authorDao.getAuthor(post.getAuthorId());
    }
}
