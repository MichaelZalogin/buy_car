package ru.buycar.service.interfaces;

import ru.buycar.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User addUser(User user);

    void updateUser(User user);

    void deleteUser(Long userId);

    List<User> findAllUsersOrderById();

    Optional<User> findUserById(Long userId);

    List<User> findUserByLikeLogin(String key);

    Optional<User> findUserByLogin(String login);

    Optional<User> findUserByLoginAndPassword(String login, String password);

}