package com.example.demo.repository;

import com.example.demo.bean.Post;
import javafx.geometry.Pos;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author Mikorn vietnam
 * Created on 21-Mar-19.
 */

public class PostDao {
    private List<Post> posts;

    public PostDao(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return posts.stream()
                .skip(offset)
                .limit(count)
                .collect(Collectors.toList());
    }

    public List<Post> getAuthorPosts(String author) {
        return posts.stream()
                .filter(post -> author.equals(post.getAuthorId()))
                .collect(Collectors.toList());
    }

    public void savePost(Post post) {
        posts.add(0, post);
    }

}
