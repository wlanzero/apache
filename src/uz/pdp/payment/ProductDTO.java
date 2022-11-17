package uz.pdp.payment;

public class ProductDTO {
    private String name;
    private int price;
    private int catalog_id;

    public ProductDTO() {
    }

    public ProductDTO(String name, int price, int catalog_id) {
        this.name = name;
        this.price = price;
        this.catalog_id = catalog_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(int catalog_id) {
        this.catalog_id = catalog_id;
    }
}
