package com.example.demo.controller;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.bean.Post;
import com.example.demo.graphql.GraphqlConfiguration;
import com.example.demo.repository.PostDao;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author Mikorn vietnam
 * Created on 21-Mar-19.
 */
@RestController
@Import(GraphqlConfiguration.class)
public class Controller implements GraphQLQueryResolver {

    @GetMapping("/")
    public String hello() {
        return "Hello";
    }
    private PostDao postDao;

    public List<Post> getRecentPosts(int count, int offset) {
        return postDao.getRecentPosts(count, offset);
    }

}
