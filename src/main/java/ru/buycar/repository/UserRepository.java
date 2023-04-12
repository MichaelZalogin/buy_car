package ru.buycar.repository;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.buycar.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UserRepository {

    private final SessionFactory sf;

    public User create(User user) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return user;
    }

    public void update(User user) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery("""
                            UPDATE User
                            SET login = :fLogin, password = :fPassword
                            WHERE id = :fId
                            """)
                    .setParameter("fLogin", user.getLogin())
                    .setParameter("fPassword", user.getPassword())
                    .setParameter("fId", user.getId())
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void delete(int userId) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery("""
                            DELETE User
                            WHERE id = :fId
                            """)
                    .setParameter("fId", userId)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public List<User> findAllOrderById() {
        Session session = sf.openSession();
        List<User> userList = new ArrayList<>();
        try {
            session.beginTransaction();
            Query<User> query = session.createQuery("""
                    FROM User
                    ORDER BY id
                    """);
            userList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return userList;
    }

    public Optional<User> findById(int userId) {
        Session session = sf.openSession();
        Optional<User> userOptional = Optional.empty();
        try {
            Query<User> query = session.createQuery("""
                            FROM User
                            WHERE id = :fId
                            """)
                    .setParameter("fId", userId);
            userOptional = query.uniqueResultOptional();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return userOptional;
    }

    public List<User> findByLikeLogin(String key) {
        Session session = sf.openSession();
        List<User> userList = new ArrayList<>();
        try {
            Query<User> query = session.createQuery("""
                            FROM User
                            WHERE login LIKE :fKey
                            """)
                    .setParameter("fKey", "%" + key + "%");
            userList = query.list();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return userList;
    }

    public Optional<User> findByLogin(String login) {
        Session session = sf.openSession();
        Optional<User> userOptional = Optional.empty();
        try {
            Query<User> query = session.createQuery("""
                            FROM User
                            WHERE login LIKE :fLogin
                            """)
                    .setParameter("fLogin", login);
            userOptional = query.uniqueResultOptional();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return userOptional;
    }
}