package it.aulab.blogmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import it.aulab.blogmongo.models.Post;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByAuthorName(String name);

    List<Post> findByTitle(String title);

    List<Post> findByPublishDate(String publishDate);

    List<Post> findByViewsGreaterThanOrderByViewsDesc(Integer views);

    List<Post> findByCommentsEmail(String email);

    @Query("{ 'views': { '$gte': ?0, '$lte': ?1 } }")
    List<Post> findByViewsBetween(Integer minViews, Integer maxViews);
}

