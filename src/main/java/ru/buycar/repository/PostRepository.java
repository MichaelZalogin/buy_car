package ru.buycar.repository;

import lombok.AllArgsConstructor;
import ru.buycar.entity.CarBrand;
import ru.buycar.entity.Post;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class PostRepository {

    private CrudRepository crudRepository;

    public Post create(Post post) {
        crudRepository.run(session -> session.persist(post));
        return post;
    }

    public void update(Post post) {
        crudRepository.run(session -> session.merge(post));
    }

    public void delete(Long postId) {
        crudRepository.run(
                "DELETE FROM Post WHERE id = :fId",
                Map.of("fId", postId)
        );
    }

    public Optional<Post> findById(Long postId) {
        return crudRepository.optional(
                "FROM Post WHERE id = :fId", Post.class,
                Map.of("fId", postId)
        );
    }

    public List<Post> findAllOrderByDate() {
        return crudRepository.query("FROM Post ORDER BY created ASC", Post.class);
    }

    public List<Post> findAllWithPhotoOrderByDate() {
        return crudRepository.query("""
                FROM Post
                WHERE File NOT NULL
                ORDER BY created ASC
                  """, Post.class);
    }

    public List<Post> findAllPostForToday() {
        return crudRepository.query("""
                FROM Post
                WHERE DATE(created) = CURRENT_DATE
                ORDER BY created ASC
                 """, Post.class);
    }

    public List<Post> findAllPostWithCurrentDate(CarBrand brand) {
        return crudRepository.query("""
                SELECT t
                FROM Post p
                JOIN FETCH p.car c
                JOIN FETCH c.carBrand cb
                WHERE cb = :fBrand
                ORDER BY created ASC
                """, Post.class, Map.of("fBrand", brand));
    }
}