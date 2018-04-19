package com.shopping.dao;

import com.shopping.entity.UserDetail;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        session.save(userDetail);
    }

    public boolean deleteUserDetail(int id) {
        String hql = "delete UserDetail where id=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        return query.executeUpdate() > 0;
    }

    public boolean updateUserDetail(UserDetail userDetail) {
        String hql = "update UserDetail set password=?,phoneNumber=?,sex=?,birthday=?,postNumber=?,address=? where id=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,userDetail.getPassword());
        query.setParameter(1,userDetail.getPhoneNumber());
        query.setParameter(2,userDetail.getSex());
        query.setParameter(3,userDetail.getBirthday());
        query.setParameter(4,userDetail.getPostNumber());
        query.setParameter(5,userDetail.getAddress());
        query.setParameter(6,userDetail.getId());
        return query.executeUpdate() > 0;
    }

    public List<UserDetail> getAllUserDetail() {
        String hql = "from UserDetail";
        Query query = session.createQuery(hql);
        return query.list();
    }
}
