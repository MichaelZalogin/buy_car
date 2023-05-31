package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.buycar.entity.Brand;
import ru.buycar.entity.Post;
import ru.buycar.repository.BaseCrudRepository;

import java.time.LocalDateTime;
import java.util.*;

@AllArgsConstructor
@Repository
public class HibernatePostRepository {

    private BaseCrudRepository baseCrudRepository;

    public Post create(Post post) {
        baseCrudRepository.run(session -> session.persist(post));
        return post;
    }

    public void update(Post post) {
        baseCrudRepository.run(session -> session.merge(post));
    }

    public void delete(Long postId) {
        baseCrudRepository.run(
                "DELETE FROM Post WHERE id = :fId",
                Map.of("fId", postId)
        );
    }

    public Optional<Post> findById(Long postId) {
        return baseCrudRepository.optional(
                "FROM Post WHERE id = :fId", Post.class,
                Map.of("fId", postId)
        );
    }

    public List<Post> findAllOrderByDate() {
        return baseCrudRepository.query("FROM Post ORDER BY created ASC", Post.class);
    }

    public List<Post> findAllWithPhotoOrderByDate() {
        return baseCrudRepository.query("""
                FROM Post
                WHERE File NOT NULL
                ORDER BY created ASC
                  """, Post.class);
    }

    public List<Post> findAllPostForToday() {
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        return baseCrudRepository.query("""
                FROM Post
                WHERE created >= :fYesterday
                ORDER BY created ASC
                 """, Post.class, Map.of("fYesterday", yesterday));
    }

    public List<Post> findAllPostWithCurrentDate(Brand brand) {
        return baseCrudRepository.query("""
                SELECT t
                FROM Post p
                JOIN FETCH p.car c
                JOIN FETCH c.carBrand cb
                WHERE cb = :fBrand
                ORDER BY created ASC
                """, Post.class, Map.of("fBrand", brand));
    }

}