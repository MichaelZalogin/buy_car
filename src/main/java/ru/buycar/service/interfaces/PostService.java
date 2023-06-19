package ru.buycar.service.interfaces;

import ru.buycar.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Post addPost(Post post);

    void updatePost(Post post);

    void deletePost(Post post);

    Optional<Post> findPostById(Long postId);

    List<Post> findAllPosts();

    List<Post> findPostsByLastDay();

    List<Post> findPostsWithPhoto();

    List<Post> findPostsByBrandId(Long brandId);

    List<Post> findPostsByReleaseYearId(Long releaseYearId);

    List<Post> findPostsByBodyId(Long bodyId);

    List<Post> findPostsByColourId(Long colourId);

    List<Post> findPostsByTransmissionId(Long transmissionId);

    List<Post> findPostsByEngineVolumeId(Long engineVolumeId);

    List<Post> findPostsByUserId(Long userId);

    List<Post> findFavouritePosts(Long userId);

}