package com.shopping.dao;

import com.shopping.entity.Evaluation;
import com.shopping.entity.ShoppingCar;
import com.shopping.entity.ShoppingRecord;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 14437 on 2017/3/3.
 */
@Repository(value = "shoppingRecordDao")
public class ShoppingRecordDao {
    private Session session = MainDAO.getSession();

    public ShoppingRecord getShoppingRecord(int userId, int productId,String time) {
        String hql = "from ShoppingRecord where userId=? and productId=? and time=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, userId);
        query.setParameter(1, productId);
        query.setParameter(2, time);
        return (ShoppingRecord) query.uniqueResult();
    }

    public void addShoppingRecord(ShoppingRecord shoppingRecord) {
        Transaction tx = session.beginTransaction();
        session.save(shoppingRecord);
        tx.commit();
    }

    public boolean deleteShoppingRecord(int userId, int productId) {
        String hqlSearch = "from ShoppingRecord where userId=? and productId=?";
        org.hibernate.query.Query querySearch = session.createQuery(hqlSearch);
        querySearch.setParameter(0, userId);
        querySearch.setParameter(0, productId);
        List<Evaluation> list = querySearch.list();
        if(list.isEmpty())
            return true;
        Transaction tx = session.beginTransaction();
        String hql = "delete ShoppingRecord where userId=? and productId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, userId);
        query.setParameter(1, productId);
        int num = query.executeUpdate();
        tx.commit();

        return num > 0;
    }

    public boolean updateShoppingRecord(ShoppingRecord shoppingRecord) {
        Transaction tx = session.beginTransaction();
        String hql = "update ShoppingRecord set orderStatus=? where userId=? and productId=? and time=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, shoppingRecord.getOrderStatus());
        query.setParameter(1, shoppingRecord.getUserId());
        query.setParameter(2, shoppingRecord.getProductId());
        query.setParameter(3,shoppingRecord.getTime());
        int num = query.executeUpdate();
        tx.commit();
        return num > 0;
    }

    public List<ShoppingRecord> getShoppingRecords(int userId) {
        String hql = "from ShoppingRecord where userId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,userId);
        return query.list();
    }

    public List<ShoppingRecord> getAllShoppingRecords() {
        String hql = "from ShoppingRecord";
        Query query = session.createQuery(hql);
        return query.list();
    }

    public List<ShoppingRecord> getShoppingRecordsByOrderStatus(int orderStatus) {
        String hql = "from ShoppingRecord where orderStatus=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,orderStatus);
        return query.list();
    }

    public boolean getUserProductRecord(int userId,int productId) {
        String hql = "from ShoppingRecord where userId=? and productId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,userId);
        query.setParameter(1,productId);
        return query.list().size()>0;
    }

    public boolean deleteShoppingRecordByUser(int userId) {
        String hqlSearch = "from ShoppingRecord where userId=?";
        org.hibernate.query.Query querySearch = session.createQuery(hqlSearch);
        querySearch.setParameter(0, userId);
        List<Evaluation> list = querySearch.list();
        if(list.isEmpty())
            return true;
        Transaction tx = session.beginTransaction();
        String hql = "delete ShoppingRecord where userId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, userId);
        int num = query.executeUpdate();
        tx.commit();
        return  num > 0;
    }

    public boolean deleteShoppingRecordByProductId(int productId) {
        String hqlSearch = "from ShoppingRecord where productId=?";
        org.hibernate.query.Query querySearch = session.createQuery(hqlSearch);
        querySearch.setParameter(0, productId);
        List<Evaluation> list = querySearch.list();
        if(list.isEmpty())
            return true;
        Transaction tx = session.beginTransaction();
        String hql = "delete ShoppingRecord where productId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, productId);
        int num = query.executeUpdate();
        tx.commit();
        return  num > 0;
    }
}
