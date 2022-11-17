package uz.pdp.service;

import uz.pdp.entity.Basket;
import uz.pdp.payment.Result;

public class BasketServiceImpl implements BasketService{
    @Override
    public Result create(Basket basket) {
        Result result = new Result();
        if (!isHere(basket)){
            Basket basket1 = new Basket(basket.getUser_id(), basket.getProduct_id());
            baskets.add(basket1);
            result.setSuccess(true);
            result.setMessage("Mahsulot basketga qo'shildi");
        }else{
            result.setMessage("Mahsulot savatga qo'shilmadi / mahsulot allaqachon savatga qo'shilgan bo'lishi mumkin");
        }
        return result;
    }

    public static boolean isHere(Basket basket){
        for (Basket basket1:baskets){
            if(basket1.getProduct_id()==basket.getProduct_id()&&basket1.getUser_id()==basket.getUser_id()){
                return true;
            }
        }
        return false;
    }
}
