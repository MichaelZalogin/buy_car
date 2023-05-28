package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import ru.buycar.entity.File;
import ru.buycar.repository.BaseCrudRepository;

import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class HibernateFileRepository {

    private final BaseCrudRepository baseCrudRepository;

    public File create(File file) {
        baseCrudRepository.run(session -> session.persist(file));
        return file;
    }

    public void delete(Long fileId) {
        baseCrudRepository.run(
                "DELETE FROM File WHERE id = :fId",
                Map.of("fId", fileId)
        );
    }

    public Optional<File> findById(Long fileId) {
        return baseCrudRepository.optional(
                "FROM File WHERE id = :fId", File.class,
                Map.of("fId", fileId)
        );
    }

}