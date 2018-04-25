package com.shopping.dao;

import com.shopping.entity.Evaluation;
import com.shopping.entity.ShoppingCar;
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

@Repository(value = "shoppingCarDao")
public class ShoppingCarDao{
    private Session session = MainDAO.getSession();

    public ShoppingCar getShoppingCar(int userId, int productId) {
        String hql = "from ShoppingCar where userId=? and productId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, userId);
        query.setParameter(1, productId);
        return (ShoppingCar) query.uniqueResult();
    }

    public void addShoppingCar(ShoppingCar shoppingCar) {
        Transaction tx = session.beginTransaction();
        session.save(shoppingCar);
        tx.commit();
    }

    public boolean deleteShoppingCar(int userId, int productId) {
        String hqlSearch = "from ShoppingCar where userId=? and productId=?";
        org.hibernate.query.Query querySearch = session.createQuery(hqlSearch);
        querySearch.setParameter(0, userId);
        querySearch.setParameter(1, productId);
        List<Evaluation> list = querySearch.list();
        if(list.isEmpty())
            return true;
        Transaction tx = session.beginTransaction();
        String hql = "delete ShoppingCar where userId=? and productId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, userId);
        query.setParameter(1, productId);
        int num = query.executeUpdate();
        tx.commit();
        return num > 0;
    }


    public boolean updateShoppingCar(ShoppingCar shoppingCar) {
        Transaction tx = session.beginTransaction();
        String hql = "update ShoppingCar set productPrice=?,counts=? where userId=? and productId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,shoppingCar.getProductPrice());
        query.setParameter(1,shoppingCar.getCounts());
        query.setParameter(2,shoppingCar.getUserId());
        query.setParameter(3,shoppingCar.getProductId());
        int num = query.executeUpdate();
        tx.commit();
        return num > 0;
    }

    public List<ShoppingCar> getShoppingCars(int userId) {
        String hql = "from ShoppingCar where userId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,userId);
        return query.list();
    }

    public boolean deleteShoppingCarByUser(int userId) {
        String hqlSearch = "from ShoppingCar where userId=?";
        org.hibernate.query.Query querySearch = session.createQuery(hqlSearch);
        querySearch.setParameter(0, userId);
        List<Evaluation> list = querySearch.list();
        if(list.isEmpty())
            return true;
        Transaction tx = session.beginTransaction();
        String hql = "delete ShoppingCar where userId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, userId);
        int num = query.executeUpdate();
        tx.commit();
        return  num > 0;
    }

    public boolean deleteShoppingCarByProduct(int productId) {
        String hqlSearch = "from ShoppingCar where productId=?";
        org.hibernate.query.Query querySearch = session.createQuery(hqlSearch);
        querySearch.setParameter(0, productId);
        List<Evaluation> list = querySearch.list();
        if(list.isEmpty())
            return true;
        Transaction tx = session.beginTransaction();
        String hql = "delete ShoppingCar where productId=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, productId);
        int num = query.executeUpdate();
        tx.commit();
        return  num > 0;
    }
}
