//package com.colby.repositories.hibernate;
//
//import com.colby.models.User;
//import com.colby.repositories.UserRepo;
//import com.colby.utils.HibernateUtil;
//import org.hibernate.Session;
//import org.hibernate.HibernateException;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.util.List;
//
//public class UserHibernate implements UserRepo {
//
//    @Override
//    public User add(User user) {
//        Session s = HibernateUtil.getSession();
//        Transaction tx = null;
//
//        try {
//            tx = s.beginTransaction();
//            s.save(user);
//            tx.commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if (tx != null)
//                tx.rollback();
//        } finally {
//            s.close();
//        }
//        return user;
//
//    }
//
//    @Override
//    public User getById(Integer id) {
//
//        Session s = HibernateUtil.getSession();
//        User u = s.get(User.class, id);
//        s.close();
//        return u;
//
////        String sql = "select * from users where id = :id";
////// We can still use native sql - but you shouldn't unless doing large updates or complicated queries.
////        NativeQuery<User> nq = s.createNativeQuery(sql);
////        nq.setParameter("id", id);
////        User u = nq.stream().findFirst().get();
////        return u;
//    }
//
//    @Override
//    public User getByUsername(String username) {
//        // Let's use the Criteria Interface
//        Session s = HibernateUtil.getSession();
//        User u = null;
//
//        try {
//
//            // Get Criteria Builder from Session
//            CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
//
//            // Create CriteriaQuery
//            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//
//            // Create Root object
//            Root<User> root = criteriaQuery.from(User.class);
//
//            // Use Predicates to narrow down our query
//            Predicate predicate = criteriaBuilder.equal(root.get("username"), username);
//            // you can create multiple predicates (i.e. username AND password)
//
//            // Bringing our Criteria Builder and our Criteria Query together...
//            // select * from users where username = ?
//            criteriaQuery.select(root).where(predicate); // if using multiple predicates -> .where(cb.and(pred1, pred2)
//
//            // Save that result into an object
//            u = s.createQuery(criteriaQuery).getSingleResult();
//
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        } finally {
//            s.close();
//        }
//
//        return u;
//
//    }
//
//    @Override
//    public List<User> getAll() {
//        Session s = HibernateUtil.getSession();
//        // new query obj
//        String query = "from User";
//        Query<User> q = s.createQuery(query, User.class);
//        List<User> users = q.getResultList();
//        s.close();
//        return users;
//
//    }
//    @Override
//    public User update(User user) {
//        Transaction tx = null;
//        try (Session s = HibernateUtil.getSession()) {
//            tx = s.beginTransaction();
//            s.update(user);
//            tx.commit();
//
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if (tx != null)
//                tx.rollback();
//        }
//
//
//        return user;
//    }
//
//    @Override
//    public void delete(Integer id) {
//        Transaction tx = null;
//
//        try (Session s = HibernateUtil.getSession()) {
//            tx = s.beginTransaction();
//            s.delete(id);
//            tx.commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if (tx != null)
//                tx.rollback();
//        }
//
//    }
//} // ends user repo
