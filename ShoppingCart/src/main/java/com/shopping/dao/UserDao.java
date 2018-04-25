package com.shopping.dao;

import com.shopping.entity.Evaluation;
import com.shopping.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 14437 on 2017/3/1.
 */
@Repository(value = "userDao")
public class UserDao{

    private Session session = MainDAO.getSession();

    public User getUser(int id) {
        String hql = "from User where id=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        return (User)query.uniqueResult();
    }

    public User getUser(String nameOrEmail) {
        String hql = "from User where email=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, nameOrEmail);
        if(query.uniqueResult() == null){
            hql = "from User where name=?";
            query = session.createQuery(hql);
            query.setParameter(0, nameOrEmail);
        }
        return (User)query.uniqueResult();
    }

    public void addUser(User user) {
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
    }

    public boolean deleteUser(int id) {
        String hqlSearch = "from User where id=?";
        org.hibernate.query.Query querySearch = session.createQuery(hqlSearch);
        querySearch.setParameter(0, id);
        List<Evaluation> list = querySearch.list();
        if(list.isEmpty())
            return true;
        Transaction tx = session.beginTransaction();
        String hql = "delete User where id=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        int num = query.executeUpdate();
        tx.commit();
        return num > 0;
    }

    public boolean updateUser(User user) {
        String hql = "update User set name = ?,email=? where id=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,user.getName());
        query.setParameter(1,user.getEmail());
//        query.setParameter(2,user.getNickName());
        query.setParameter(2,user.getId());
        return query.executeUpdate() > 0;
    }

    public List<User> getAllUser() {
        String hql = "from User";
        Query query = session.createQuery(hql);
        return query.list();
    }
}
