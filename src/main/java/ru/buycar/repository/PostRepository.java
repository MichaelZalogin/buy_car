package ru.buycar.repository;

import lombok.AllArgsConstructor;
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

    public List<Post> findAllOrderByDate() {
        return crudRepository.query("FROM Post ORDER BY created ASC", Post.class);
    }

    public Optional<Post> findById(Long postId) {
        return crudRepository.optional(
                "FROM Post WHERE id = :fId", Post.class,
                Map.of("fId", postId)
        );
    }
//
//    public List<Post> findAllWithPhotoOrderByDate() {
//        return crudRepository.query("FROM Post WHERE  ORDER BY created ASC", Post.class);
//    }


}