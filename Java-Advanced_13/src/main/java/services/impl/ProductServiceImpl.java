package services.impl;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import domain.Product;
import services.ProductService;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class ProductServiceImpl implements ProductService {
    private static ProductService productServiceImpl;
    private ProductDao productDao;

    private ProductServiceImpl() {

        productDao = new ProductDaoImpl();

    }

    public static ProductService getProductService() {
        if (productServiceImpl == null) {
            productServiceImpl = new ProductServiceImpl();
        }

        return productServiceImpl;
    }

    @Override
    public Product create(Product t) {
        return productDao.create(t);
    }

    @Override
    public Product read(Integer id) {
        return productDao.read(id);
    }

    @Override
    public Product update(Product t) {
        return productDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        productDao.delete(id);
    }

    @Override
    public List<Product> readAll() {
        return productDao.readAll();
    }

    @Override
    public Map<Integer, Product> readAllMap() {
        return readAll().stream().collect(Collectors.toMap(Product::getId, Function.identity()));
    }
}
