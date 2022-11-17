package uz.pdp.service;

import uz.pdp.entity.Catalog;
import uz.pdp.payment.CatalogDTO;
import uz.pdp.payment.Result;

import java.util.ArrayList;

public interface CatalogService {
    ArrayList<Catalog> catalogs = new ArrayList<>();
    Result create(CatalogDTO catalogDTO);

}
