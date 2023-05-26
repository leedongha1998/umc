package com.example.demo.src.product;

import com.example.demo.src.product.model.GetProductRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<GetProductRes> getProductList() {
        return productDao.getProductList();
    }

    public List<GetProductRes> findProductBySearch(String search) {
        return productDao.findProductBySearch(search);
    }
}
