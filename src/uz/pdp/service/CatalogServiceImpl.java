package uz.pdp.service;

import uz.pdp.entity.Catalog;
import uz.pdp.payment.CatalogDTO;
import uz.pdp.payment.Result;

public class CatalogServiceImpl implements CatalogService{
    @Override
    public Result create(CatalogDTO catalogDTO) {
        Result result = new Result();
        if(!isHere(catalogDTO)){
            Catalog catalog = new Catalog(catalogDTO.getName());
            catalogs.add(catalog);
            result.setSuccess(true);
            result.setMessage("Katalog muvaffaqiyatli qo'shildi");
        }else{
            result.setMessage("Katalog qo'shilmadi / bunday katalog mavjud bo'lishi mumkin");
        }
        return result;
    }

    public static boolean isHere(CatalogDTO catalogDTO){
        for(Catalog catalog:catalogs){
            if(catalog.getName().equals(catalogDTO.getName())){
                return true;
            }
        }
        return false;
    }
}
