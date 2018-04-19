package com.shopping.service;

import com.shopping.dao.EvaluationDao;
import com.shopping.dao.ProductDao;
import com.shopping.dao.ShoppingCarDao;
import com.shopping.dao.ShoppingRecordDao;
import com.shopping.entity.Product;
import com.shopping.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 14437 on 2017/3/2.
 */

@Service(value = "productService")
public class ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ShoppingRecordDao shoppingRecordDao;
    @Autowired
    private ShoppingCarDao shoppingCarDao;
    @Autowired
    private EvaluationDao evaluationDao;

    public Product getProduct(int id) {
        return productDao.getProduct(id);
    }

    public Product getProduct(String name) {
        return productDao.getProduct(name);
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Transactional
    public Response deleteProduct(int id) {
        try {
            evaluationDao.deleteEvaluationByProduct(id);
            shoppingCarDao.deleteShoppingCarByProduct(id);
            shoppingRecordDao.deleteShoppingRecordByProductId(id);
            productDao.deleteProduct(id);
            return new Response(1, "删除商品成功", null);
        }catch (Exception e){
            return new Response(0,"删除商品失败",null);
        }
    }

    public boolean updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    public List<Product> getProductsByKeyWord(String searchKeyWord) {
        return productDao.getProductsByKeyWord(searchKeyWord);
    }

    public List<Product> getProductsByType(int type) {
        return productDao.getProductsByType(type);
    }

    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }
}
