package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.buycar.entity.File;
import ru.buycar.repository.BaseCrudRepository;
import ru.buycar.repository.interfaces.FileRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class HibernateFileRepository implements FileRepository {

    private final BaseCrudRepository baseCrudRepository;

    @Override
    public File saveFile(File file) {
        baseCrudRepository.run(session -> session.persist(file));
        return file;
    }

    @Override
    public void deleteFileById(Long fileId) {
        baseCrudRepository.run(
                "DELETE FROM File WHERE id = :fId",
                Map.of("fId", fileId)
        );
    }

    @Override
    public Optional<File> findFileById(Long fileId) {
        return baseCrudRepository.optional(
                "FROM File WHERE id = :fId", File.class,
                Map.of("fId", fileId)
        );
    }

    @Override
    public List<File> findAllFilesByPostId(Long postId) {
        return null;
    }

    @Override
    public void deleteFilesByPostId(Long postId) {

    }

}