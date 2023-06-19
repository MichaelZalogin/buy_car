package ru.buycar.service.interfaces;

import ru.buycar.dto.FileDto;
import ru.buycar.entity.File;
import ru.buycar.entity.Post;

import java.util.List;
import java.util.Optional;

public interface FileService {

    File saveFile(FileDto fileDto, Post post);

    Optional<FileDto> findFileById(Long fileId);

    void deleteFileById(Long fileId);

    List<File> findAllFilesByPostId(Long postId);

    void deleteFilesByPostId(Long postId);

}