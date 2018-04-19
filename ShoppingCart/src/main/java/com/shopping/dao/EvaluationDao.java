package com.shopping.dao;

import com.shopping.entity.Evaluation;
import com.shopping.entity.Product;
import org.hibernate.Criteria;
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
        session.save(evaluation);
    }

    public boolean deleteEvaluation(int userId, int productId, String time) {
        String hql = "delete Evaluation where userId=? and productId=? and time=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, userId);
        query.setParameter(1, productId);
        query.setParameter(2, time);
        return query.executeUpdate() > 0;
    }

    public boolean updateEvaluation(Evaluation evaluation) {
        String hql = "update Evaluation set content=? where userId=? and productId=? and time=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, evaluation.getContent());
        query.setParameter(1, evaluation.getUserId());
        query.setParameter(2, evaluation.getProductId());
        query.setParameter(3, evaluation.getTime());
        return query.executeUpdate() > 0;
    }

    public List<Evaluation> getProductEvaluation(int productId) {
        String hql = "from Evaluation where productId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, productId);
        return  query.list();
    }

    public boolean deleteEvaluationByUser(int userId) {
        String hql = "delete Evaluation where userId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, userId);
        return query.executeUpdate() > 0;
    }

    public boolean deleteEvaluationByProduct(int productId) {
        String hql = "delete Evaluation where productId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, productId);
        return query.executeUpdate() > 0;
    }
}
