package com.shopping.service;

import com.shopping.dao.*;
import com.shopping.entity.User;
import com.shopping.entity.UserDetail;
import com.shopping.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 14437 on 2017/3/1.
 */
@Service(value = "userService")
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDetailDao userDetailDao;
    @Autowired
    private ShoppingRecordDao shoppingRecordDao;
    @Autowired
    private ShoppingCarDao shoppingCarDao;
    @Autowired
    private EvaluationDao evaluationDao;

    public User getUser(int id) {
        return userDao.getUser(id);
    }

    public User getUser(String nameOrEmail) {
        return userDao.getUser(nameOrEmail);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    //推荐写法，具体业务逻辑放在Service实现方法里面
    @Transactional
    public Response deleteUser(int id) {
        //判断此用户是否存在购买记录、评价记录、购物车记录，如果存在，则应该先删除对应的记录，否则后续删除会出错
        try {
            evaluationDao.deleteEvaluationByUser(id);
            shoppingCarDao.deleteShoppingCarByUser(id);
            shoppingRecordDao.deleteShoppingRecordByUser(id);
            userDetailDao.deleteUserDetail(id);
            userDao.deleteUser(id);
            return new Response(1, "删除成功", null);
        }catch (Exception e) {
            return new Response(0, "删除失败", null);
        }
    }

    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}
