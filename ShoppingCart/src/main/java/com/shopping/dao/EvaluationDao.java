package com.shopping.dao;

import com.shopping.entity.Evaluation;
import com.shopping.entity.Product;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "evaluationDao")
public class EvaluationDao {

    private Session session;

    public Evaluation getEvaluation(int userId, int productId, String time) {
        String hql = "from Evaluation where userId=? and productId=? and time=?";

        session = MainDAO.getSession();

        Query query = session.createQuery(hql);
        query.setParameter(0, userId);
        query.setParameter(1, productId);
        query.setParameter(2, time);


        Criteria crit = session.createCriteria(Product.class);
        Criteria prdCrit = crit.createCriteria("products");
        crit.add(Restrictions.like("time","Tab%"));
        crit.add(Restrictions.ilike("time","Tab%"));
        List<Product> results = crit.list();

        session.close();

        return (Evaluation) query.uniqueResult();
    }

    public void addEvaluation(Evaluation evaluation) {
        session = MainDAO.getSession();
        Transaction tx = session.beginTransaction();
        session.save(evaluation);
        tx.commit();
        session.close();
    }

    public boolean deleteEvaluation(int userId, int productId, String time) {
        String hqlSearch = "from Evaluation where userId=? and productId=? and time=?";
        session = MainDAO.getSession();
        Query querySearch = session.createQuery(hqlSearch);
        querySearch.setParameter(0, userId);
        querySearch.setParameter(1, productId);
        querySearch.setParameter(2, time);
        querySearch.setParameter(0, userId);
        List<Evaluation> list = querySearch.list();
        if(list.isEmpty()) {
            session.close();
            return true;
        }
        Transaction tx = session.beginTransaction();
        String hql = "delete Evaluation where userId=? and productId=? and time=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, userId);
        query.setParameter(1, productId);
        query.setParameter(2, time);
        int num = query.executeUpdate();
        tx.commit();
        session.close();
        return num > 0;
    }

    public boolean updateEvaluation(Evaluation evaluation) {
        session = MainDAO.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "update Evaluation set content=? where userId=? and productId=? and time=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, evaluation.getContent());
        query.setParameter(1, evaluation.getUserId());
        query.setParameter(2, evaluation.getProductId());
        query.setParameter(3, evaluation.getTime());
        int num = query.executeUpdate();
        tx.commit();
        session.close();
        return num > 0;

    }

    public List<Evaluation> getProductEvaluation(int productId) {
        String hql = "from Evaluation where productId=?";
        session = MainDAO.getSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, productId);
        List<Evaluation> list = query.list();
        session.close();
        return  list;
    }

    public boolean deleteEvaluationByUser(int userId) {
        String hqlSearch = "from Evaluation where userId=?";
        session = MainDAO.getSession();
        Query querySearch = session.createQuery(hqlSearch);
        querySearch.setParameter(0, userId);
        List<Evaluation> list = querySearch.list();
        if(list.isEmpty()) {
            session.close();
            return true;
        }
        Transaction tx = session.beginTransaction();
        String hql = "delete Evaluation where userId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, userId);
        int num = query.executeUpdate();
        tx.commit();
        session.close();
        return  num > 0;
    }

    public boolean deleteEvaluationByProduct(int productId) {
        session = MainDAO.getSession();
        String hqlSearch = "from Evaluation where productId=?";
        Query querySearch = session.createQuery(hqlSearch);
        querySearch.setParameter(0, productId);
        List<Evaluation> list = querySearch.list();
        if(list.isEmpty()){
            session.close();

            return true;
        }
        Transaction tx = session.beginTransaction();
        String hql = "delete Evaluation where productId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, productId);
        int num = query.executeUpdate();
        tx.commit();
        session.close();
        return  num > 0;
    }
}
