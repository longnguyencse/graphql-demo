package com.example.demo.graphql;

import com.example.demo.bean.Author;
import com.example.demo.bean.AuthorBuilder;
import com.example.demo.bean.Post;
import com.example.demo.bean.PostBuilder;
import com.example.demo.repository.AuthorDao;
import com.example.demo.repository.PostDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Mikorn vietnam
 * Created on 22-Mar-19.
 */
@Configuration
public class GraphqlConfiguration {
    @Bean
    public PostDao postDao() {
        List<Post> posts = new ArrayList<>();
        for (int postId = 0; postId < 10; ++postId) {
            for (int authorId = 0; authorId < 10; ++ authorId) {
                Post post = new PostBuilder().withId("Post " + authorId + postId)
                                .withTitle("Post " + authorId + ":" + postId)
                                .withText("Post " + postId + " by author " + authorId)
                                .withAuthorId("Author" + authorId)
                                .build();
                posts.add(post);
            }
        }
        return new PostDao(posts);
    }

    @Bean
    public AuthorDao authorDao() {
        List<Author> authors = new ArrayList<>();
        for (int authorId = 0; authorId < 10; ++ authorId) {
            Author author = new AuthorBuilder().withId("Author" + authorId)
                    .withName("Author" + authorId)
                    .withThumbnail("http://example.com/authors/" + authorId)
                    .build();
            authors.add(author);
        }
        return new AuthorDao(authors);
    }

    @Bean
    public PostResolver postResolver(AuthorDao authorDao) {
        return new PostResolver(authorDao);
    }

    @Bean
    public AuthorResolver authorResolver(PostDao postDao) {
        return new AuthorResolver(postDao);
    }

    @Bean
    public Query query(PostDao postDao) {
        return new Query(postDao);
    }

    @Bean
    public Mutation mutation(PostDao postDao) {
        return new Mutation(postDao);
    }
}
