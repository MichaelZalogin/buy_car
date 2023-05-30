package ru.buycar.repository.interfaces;

import ru.buycar.entity.File;

import java.util.List;
import java.util.Optional;

public interface FileRepository {

    File saveFile(File file);

    Optional<File> findFileById(Long fileId);

    void deleteFileById(Long fileId);

    List<File> findAllFilesByPostId(Long postId);

    void deleteFilesByPostId(Long postId);

}