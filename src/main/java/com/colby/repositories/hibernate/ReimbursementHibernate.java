//package com.colby.repositories.hibernate;
//
//import com.colby.models.Reimbursement;
//import com.colby.models.User;
//import com.colby.repositories.ReimbursementRepo;
//import com.colby.utils.HibernateUtil;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import java.util.List;
//
//public class ReimbursementHibernate implements ReimbursementRepo {
//
//    @Override
//    public Reimbursement add(Reimbursement reimbursement) {
//
//        Session session = HibernateUtil.getSession();
//
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            session.save(reimbursement);
//            tx.commit();
//
//
//        }catch(HibernateException e){
//            e.printStackTrace();
//            if(tx!= null){
//                tx.rollback();
//            }
//        } finally{
//            session.close();
//        }
//        return reimbursement;
//    }
//
//    @Override
//    public Reimbursement getById(Integer id) {
//
//        Session session = HibernateUtil.getSession();
//        Reimbursement r = session.get(Reimbursement.class, id);
//
//        session.close();
//        return r;
//    }
//
//    @Override
//    public List<Reimbursement> getAll() {
//        return null;
//    }
//
//    @Override
//    public User update(Reimbursement reimbursement) {
//        Transaction tx = null;
//        try(Session session = HibernateUtil.getSession()){
//            tx = session.beginTransaction();
//            session.update(reimbursement);
//            tx.commit();
//
//
//        }catch(HibernateException e){
//            e.printStackTrace();
//            if (tx != null)
//                tx.rollback();
//        }
//
//        return null;
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
//}
