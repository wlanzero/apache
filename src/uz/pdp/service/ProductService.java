package uz.pdp.service;

import uz.pdp.entity.Product;
import uz.pdp.payment.ProductDTO;
import uz.pdp.payment.Result;

import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> products = new ArrayList<>();
    Result create(ProductDTO productDTO);
}
