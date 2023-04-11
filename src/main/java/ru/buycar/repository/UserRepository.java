package ru.buycar.repository;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.buycar.entity.User;
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
                    .setParameter("fId", user.getId());
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
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
                    .setParameter("fId", userId);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public List<User> findAllOrderById() {
        Session session = sf.openSession();
        Query<User> query = session.createQuery("FROM User");
        List<User> sortedList = query.list();
        sortedList.sort((user1, user2) ->
                Integer.compare(user1.getId(), user2.getId()));
        return sortedList;
    }

    public Optional<User> findById(int userId) {
        Session session = sf.openSession();
        Query<User> query = session.createQuery("""
                        FROM User
                        WHERE id = :fId
                        """)
                .setParameter("fId", userId);
        User user = query.uniqueResult();
        return Optional.ofNullable(user);
    }

    public List<User> findByLikeLogin(String key) {
        Session session = sf.openSession();
        Query<User> query = session.createQuery("""
                        FROM User
                        WHERE login LIKE %:fKey%
                        """)
                .setParameter("fKey", key);
        return query.list();
    }

    public Optional<User> findByLogin(String login) {
        Session session = sf.openSession();
        Query<User> query = session.createQuery("""
                        FROM User
                        WHERE login LIKE :fLogin
                        """)
                .setParameter("fLogin", login);
        User user = query.uniqueResult();
        return Optional.ofNullable(user);
    }
}