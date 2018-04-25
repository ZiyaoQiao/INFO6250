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

    private Session session = MainDAO.getSession();

    public Evaluation getEvaluation(int userId, int productId, String time) {
        String hql = "from Evaluation where userId=? and productId=? and time=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, userId);
        query.setParameter(1, productId);
        query.setParameter(2, time);


        Criteria crit = session.createCriteria(Product.class);
        Criteria prdCrit = crit.createCriteria("products");
        crit.add(Restrictions.like("time","Tab%"));
        crit.add(Restrictions.ilike("time","Tab%"));
        List<Product> results = crit.list();


        return (Evaluation) query.uniqueResult();
    }

    public void addEvaluation(Evaluation evaluation) {
        Transaction tx = session.beginTransaction();
        session.save(evaluation);
        tx.commit();
    }

    public boolean deleteEvaluation(int userId, int productId, String time) {
        String hqlSearch = "from Evaluation where userId=? and productId=? and time=?";
        Query querySearch = session.createQuery(hqlSearch);
        querySearch.setParameter(0, userId);
        querySearch.setParameter(1, productId);
        querySearch.setParameter(2, time);
        querySearch.setParameter(0, userId);
        List<Evaluation> list = querySearch.list();
        if(list.isEmpty())
            return true;
        Transaction tx = session.beginTransaction();
        String hql = "delete Evaluation where userId=? and productId=? and time=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, userId);
        query.setParameter(1, productId);
        query.setParameter(2, time);
        int num = query.executeUpdate();
        tx.commit();
        return num > 0;
    }

    public boolean updateEvaluation(Evaluation evaluation) {
        Transaction tx = session.beginTransaction();
        String hql = "update Evaluation set content=? where userId=? and productId=? and time=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, evaluation.getContent());
        query.setParameter(1, evaluation.getUserId());
        query.setParameter(2, evaluation.getProductId());
        query.setParameter(3, evaluation.getTime());
        int num = query.executeUpdate();
        tx.commit();
        return num > 0;

    }

    public List<Evaluation> getProductEvaluation(int productId) {
        String hql = "from Evaluation where productId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, productId);
        return  query.list();
    }

    public boolean deleteEvaluationByUser(int userId) {
        String hqlSearch = "from Evaluation where userId=?";
        Query querySearch = session.createQuery(hqlSearch);
        querySearch.setParameter(0, userId);
        List<Evaluation> list = querySearch.list();
        if(list.isEmpty())
            return true;
        Transaction tx = session.beginTransaction();
        String hql = "delete Evaluation where userId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, userId);
        int num = query.executeUpdate();
        tx.commit();
        return  num > 0;
    }

    public boolean deleteEvaluationByProduct(int productId) {
        String hqlSearch = "from Evaluation where productId=?";
        Query querySearch = session.createQuery(hqlSearch);
        querySearch.setParameter(0, productId);
        List<Evaluation> list = querySearch.list();
        if(list.isEmpty())
            return true;
        Transaction tx = session.beginTransaction();
        String hql = "delete Evaluation where productId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, productId);
        int num = query.executeUpdate();
        tx.commit();
        return  num > 0;
    }
}
