package it.aulab.blogmongo.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest;

import it.aulab.blogmongo.models.Author;
import it.aulab.blogmongo.models.Comment;
import it.aulab.blogmongo.models.Post;

@DataMongoTest // = @DataJpaTest, ma per MongoDB (import già verificato per Spring Boot 4)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @BeforeEach
    public void load() {
        postRepository.deleteAll();

        Author mario = new Author("Mario", "Rossi");
        Author luigi = new Author("Luigi", "Verdi");

        Post primo = new Post("Primo post", "Testo 1", "20261120", mario);
        primo.setViews(1);
        primo.setComments(List.of(
                new Comment("anna@example.com", "Bel post!", "20261121"),
                new Comment("luca@example.com", "Grazie!", "20261122")));

        postRepository.save(primo);
        Post secondo = new Post("Secondo post", "Testo 2", "20261121", luigi);
        secondo.setViews(3);
        secondo.setComments(List.of(
                new Comment("anna@example.com", "Bel post!", "20261121"),
                new Comment("marina@example.com", "Grazie!", "20261122")));

        postRepository.save(secondo);
        Post terzo = new Post("Terzo post", "Testo 3", "20261122", mario);
        terzo.setViews(5);
        terzo.setComments(List.of(
                new Comment("giada@example.com", "Bel post!", "20261121"),
                new Comment("luca@example.com", "Grazie!", "20261122")));

        postRepository.save(terzo);

    }

    @Test
    void findByAuthorName() {
        List<Post> result = postRepository.findByAuthorName("Mario");

        assertThat(result)
                .hasSize(2)
                .extracting("title")
                .containsOnly("Primo post", "Terzo post");
    }

    @Test
    void findByTitle() {
        List<Post> result = postRepository.findByTitle("Secondo post");
        assertThat(result)
                .hasSize(1)
                .extracting("publishDate")
                .containsOnly("20261121");
    }

    @Test
    void findByViewsGreaterThanOrderByViewsDesc() {
        List<Post> result = postRepository.findByViewsGreaterThanOrderByViewsDesc(2);
        assertThat(result)
                .hasSize(2)
                .extracting("title")
                .containsExactly("Terzo post", "Secondo post");

    }

    @Test
    void findByPublishDate() {
        List<Post> result = postRepository.findByPublishDate("20261122");
        assertThat(result)
                .hasSize(1)
                .extracting("title")
                .containsOnly("Terzo post");

    }

    @Test
    void findByCommentsEmail() {
        List<Post> result = postRepository.findByCommentsEmail("luca@example.com");
        assertThat(result)
                .hasSize(2)
                .extracting("title")
                .containsOnly("Primo post", "Terzo post");
    }

    @Test
    void findByViewsBetween() {
        List<Post> result = postRepository.findByViewsBetween(3, 5);
        assertThat(result)
                .hasSize(2)
                .extracting("title")
                .containsOnly("Secondo post", "Terzo post");

    }
}
