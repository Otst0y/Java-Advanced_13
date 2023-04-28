package services;

import domain.Product;
import shared.AbstractCRUD;

import java.util.Map;

public interface ProductService extends AbstractCRUD<Product> {
    public Map<Integer, Product> readAllMap();
}
