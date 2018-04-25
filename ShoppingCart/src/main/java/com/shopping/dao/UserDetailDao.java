package com.shopping.dao;

import com.shopping.entity.Evaluation;
import com.shopping.entity.UserDetail;
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
@Repository(value = "userDetailDao")
public class UserDetailDao{

    private Session session = MainDAO.getSession();

    public UserDetail getUserDetail(int id) {
        String hql = "from UserDetail where id=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        return (UserDetail)query.uniqueResult();
    }

    public void addUserDetail(UserDetail userDetail) {
        Transaction tx = session.beginTransaction();
        session.save(userDetail);
        tx.commit();
    }

    public boolean deleteUserDetail(int id) {
        String hqlSearch = "from UserDetail where id=?";
        org.hibernate.query.Query querySearch = session.createQuery(hqlSearch);
        querySearch.setParameter(0, id);
        List<Evaluation> list = querySearch.list();
        if(list.isEmpty())
            return true;
        Transaction tx = session.beginTransaction();
        String hql = "delete UserDetail where id=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        int num = query.executeUpdate();
        tx.commit();
        return num > 0;
    }

    public boolean updateUserDetail(UserDetail userDetail) {
        String hql = "update UserDetail set password=?,phoneNumber=?,address=? where id=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,userDetail.getPassword());
        query.setParameter(1,userDetail.getPhoneNumber());
        query.setParameter(2,userDetail.getAddress());
        query.setParameter(3,userDetail.getId());
        return query.executeUpdate() > 0;
    }

    public List<UserDetail> getAllUserDetail() {
        String hql = "from UserDetail";
        Query query = session.createQuery(hql);
        return query.list();
    }
}