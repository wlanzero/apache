package uz.pdp.service;

import uz.pdp.entity.Basket;
import uz.pdp.payment.Result;

import java.util.ArrayList;

public interface BasketService {
    ArrayList<Basket> baskets = new ArrayList<>();
    Result create(Basket basket);
}
