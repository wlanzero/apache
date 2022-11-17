package uz.pdp.service;

import uz.pdp.entity.Product;
import uz.pdp.payment.ProductDTO;
import uz.pdp.payment.Result;

public class ProductServiceImpl implements ProductService{
    @Override
    public Result create(ProductDTO productDTO) {
        Result result = new Result();
        if(!isHere(productDTO)){
            Product product = new Product(productDTO.getName(), productDTO.getPrice(), productDTO.getCatalog_id());
            products.add(product);
            result.setSuccess(true);
            result.setMessage("Mahsulot muvaffaqiyatli qo'shildi");
        }else{
            result.setMessage("Mahsulot qo'shilmadi / mahsulot ma'lumotlar bazasida mavjud bo'lishi mumkin");
        }
        return result;
    }

    public static boolean isHere(ProductDTO productDTO){
        for(Product product:products){
            if(product.getName().equals(productDTO.getName())&&product.getPrice()==productDTO.getPrice()){
                return true;
            }
        }
        return false;
    }

}
