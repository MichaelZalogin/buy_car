package ru.buycar.repository;

import lombok.AllArgsConstructor;
import ru.buycar.entity.File;

import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class FileRepository {

    private final CrudRepository crudRepository;

    public File create(File file) {
        crudRepository.run(session -> session.persist(file));
        return file;
    }

    public void delete(Long fileId) {
        crudRepository.run(
                "DELETE FROM File WHERE id = :fId",
                Map.of("fId", fileId)
        );
    }

    public Optional<File> findById(Long fileId) {
        return crudRepository.optional(
                "FROM File WHERE id = :fId", File.class,
                Map.of("fId", fileId)
        );
    }

}