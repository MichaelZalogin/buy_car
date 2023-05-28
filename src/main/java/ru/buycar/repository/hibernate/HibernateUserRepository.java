package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import ru.buycar.entity.User;
import ru.buycar.repository.BaseCrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class HibernateUserRepository {

    private final BaseCrudRepository baseCrudRepository;

    /**
     * Сохранить в базе.
     *
     * @param user пользователь.
     * @return пользователь с id.
     */
    public User create(User user) {
        baseCrudRepository.run(session -> session.persist(user));
        return user;
    }

    /**
     * Обновить в базе пользователя.
     *
     * @param user пользователь.
     */
    public void update(User user) {
        baseCrudRepository.run(session -> session.merge(user));
    }

    /**
     * Удалить пользователя по id.
     *
     * @param userId ID
     */
    public void delete(int userId) {
        baseCrudRepository.run(
                "DELETE FROM User WHERE id = :fId",
                Map.of("fId", userId)
        );
    }

    /**
     * Список пользователь отсортированных по id.
     *
     * @return список пользователей.
     */
    public List<User> findAllOrderById() {
        return baseCrudRepository.query("FROM User ORDER BY id ASC", User.class);
    }

    /**
     * Найти пользователя по ID
     *
     * @return пользователь.
     */
    public Optional<User> findById(int userId) {
        return baseCrudRepository.optional(
                "FROM User WHERE id = :fId", User.class,
                Map.of("fId", userId)
        );
    }

    /**
     * Список пользователей по login LIKE %key%
     *
     * @param key key
     * @return список пользователей.
     */
    public List<User> findByLikeLogin(String key) {
        return baseCrudRepository.query(
                "FROM User WHERE login LIKE :fKey", User.class,
                Map.of("fKey", "%" + key + "%")
        );
    }

    /**
     * Найти пользователя по login.
     *
     * @param login login.
     * @return Optional or user.
     */
    public Optional<User> findByLogin(String login) {
        return baseCrudRepository.optional(
                "FROM User WHERE login = :fLogin", User.class,
                Map.of("fLogin", login)
        );
    }
}