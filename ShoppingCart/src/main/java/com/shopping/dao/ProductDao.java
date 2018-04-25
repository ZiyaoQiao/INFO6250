package com.shopping.dao;

import com.shopping.entity.Evaluation;
import com.shopping.entity.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


@Repository(value = "productDao")
public class ProductDao {

    private Session session = MainDAO.getSession();

    public Product getProduct(int id) {
        String hql = "from Product where id=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        return (Product) query.uniqueResult();
    }

    public Product getProduct(String name) {
        String hql = "from Product where name=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,name);
        return (Product) query.uniqueResult();
    }

    public void addProduct(Product product) {
        Transaction tx = session.beginTransaction();

        session.save(product);
        tx.commit();
    }

    public boolean deleteProduct(int id) {
        String hqlSearch = "from Product where id=?";
        org.hibernate.query.Query querySearch = session.createQuery(hqlSearch);
        querySearch.setParameter(0, id);
        List<Evaluation> list = querySearch.list();
        if(list.isEmpty())
            return true;
        Transaction tx = session.beginTransaction();
        String hql = "delete Product where id=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, id);
        int num = query.executeUpdate();
        tx.commit();
        return  num > 0;
    }

    public boolean updateProduct(Product product) {
        Transaction tx = session.beginTransaction();
        String hql = "update Product set name=?,description=?,keyWord=?,price=?,counts=?,type=? where id=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,product.getName());
        query.setParameter(1,product.getDescription());
        query.setParameter(2,product.getKeyWord());
        query.setParameter(3,product.getPrice());
        query.setParameter(4,product.getCounts());
        query.setParameter(5,product.getType());
        query.setParameter(6,product.getId());
        int num = query.executeUpdate();
        tx.commit();
        return num > 0;
    }

    public List<Product> getProductsByKeyWord(String searchKeyWord) {
        String queryKeyWord = "%";
        for(int i=0;i<searchKeyWord.length();i++){
            queryKeyWord += String.valueOf(searchKeyWord.charAt(i)) +"%";
        }
        System.out.println("我搜索了"+queryKeyWord);
        String hql = "from Product where name like ? or key_word like ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,queryKeyWord);
        query.setParameter(1,queryKeyWord);
        return query.list();
    }

    public List<Product> getProductsByType(int type) {
        String hql = "from Product where type=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,type);
        return query.list();
    }


    public List<Product> getAllProduct() {
        String hql = "from Product";
        Query query = session.createQuery(hql);
        return query.list();
    }
}
