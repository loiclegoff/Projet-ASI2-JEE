package fr.cpe.dao;

import fr.cpe.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by ubuntu on 9/24/16.
 */

//@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Stateless
public class UserDao {

    @PersistenceContext
    EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public List<User> listUser() {
        List<User> users = em.createNamedQuery("Users.list")
            .getResultList();

        return users;
    }

    public User getUserById(int id) {
        User user = (User)em.createQuery("from User u where u.id = :id")
                .setParameter("id", id)
                .getSingleResult();

        return user;
    }

    public List<User> getUserByLogin(String login) {
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<User> crit = builder.createQuery(User.class);
        Root<User> root = crit.from(User.class);
        crit.select(root)
                .where(builder.like(builder.lower(root.get("login")), "%" + login.toLowerCase() + "%"));

        List<User> users = em.createQuery(crit).getResultList();

        return users;
    }
}
