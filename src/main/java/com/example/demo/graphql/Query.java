package com.example.demo.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.bean.Post;
import com.example.demo.repository.PostDao;

import java.util.List;

/**
 * Author Mikorn vietnam
 * Created on 22-Mar-19.
 */

public class Query implements GraphQLQueryResolver {
    private PostDao postDao;

    public Query(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<Post> recentPosts(int count, int offset) {
        return postDao.getRecentPosts(count, offset);
    }
}
